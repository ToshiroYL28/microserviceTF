package com.example.appbient_microservice_foro.api.service;

import com.example.appbient_microservice_foro.api.domain.model.entity.PublicacionForo;
import com.example.appbient_microservice_foro.api.domain.persistence.PublicacionForoRepository;
import com.example.appbient_microservice_foro.api.domain.service.PublicacionForoService;
import com.example.appbient_microservice_foro.api.resource.PublicacionForo.CreatePublicacionForoResource;
import com.example.appbient_microservice_foro.shared.exception.ResourceNotFoundException;
import com.example.appbient_microservice_foro.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PublicacionForoServiceImpl implements PublicacionForoService {
    
    private static final String ENTITY = "PublicacionForo";
    private final PublicacionForoRepository pubForoRepository;
    private final Validator validator;

    public PublicacionForoServiceImpl(PublicacionForoRepository pubForoRepository, Validator validator) {
        this.pubForoRepository = pubForoRepository;
        this.validator = validator;
    }

    @Override
    public List<PublicacionForo> getAll() {
        return pubForoRepository.findAll();
    }

    @Override
    public PublicacionForo getById(Long id) {
        return pubForoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public PublicacionForo create(CreatePublicacionForoResource request) {
        PublicacionForo publicacion = new PublicacionForo();
            publicacion.setTopicoId(request.getTopicoId());
            publicacion.setVoluntario(request.getVoluntarioId());
            publicacion.setName(request.getName());
            publicacion.setDescription(request.getDescription());
            publicacion.setActive(request.isActive());
        return pubForoRepository.save(publicacion);
    }

    @Override
    public PublicacionForo update(Long id ,PublicacionForo request) {
       Set<ConstraintViolation<PublicacionForo>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return pubForoRepository.findById(id).map( pub ->
                        pubForoRepository.save(
                                pub.withName(request.getName())
                                        .withDescription(request.getDescription())
                                        .withActive(request.getActive())
                        ))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, request.getId()));
    }

    @Override
    public ResponseEntity<?> delete(Long PublicacionForoId) {
        return pubForoRepository.findById(PublicacionForoId).map( pub -> {
            pubForoRepository.delete(pub);
            return ResponseEntity.ok().build();
        }).orElseThrow((() -> new ResourceNotFoundException(ENTITY, PublicacionForoId)));
    }
}
