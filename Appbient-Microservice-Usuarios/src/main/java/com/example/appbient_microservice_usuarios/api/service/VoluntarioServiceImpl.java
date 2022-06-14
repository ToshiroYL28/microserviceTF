package com.example.appbient_microservice_usuarios.api.service;

import com.example.appbient_microservice_usuarios.api.domain.model.entity.Voluntario;
import com.example.appbient_microservice_usuarios.api.domain.persistence.VoluntarioRepository;
import com.example.appbient_microservice_usuarios.api.domain.service.VoluntarioService;
import com.example.appbient_microservice_usuarios.api.resource.Voluntario.CreateVoluntarioResource;
import com.example.appbient_microservice_usuarios.shared.exception.ResourceNotFoundException;
import com.example.appbient_microservice_usuarios.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class VoluntarioServiceImpl implements VoluntarioService {

    private static final String ENTITY = "Voluntario";

    private final VoluntarioRepository voluntarioRepository;
    private final Validator validator;

    public VoluntarioServiceImpl(VoluntarioRepository voluntarioRepository, Validator validator) {
        this.voluntarioRepository = voluntarioRepository;
        this.validator = validator;
    }


    @Override
    public List<Voluntario> getAll() {
        return voluntarioRepository.findAll();
    }

    @Override
    public Voluntario getById(Long id) {
        return voluntarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Voluntario create(CreateVoluntarioResource request) {
        Voluntario voluntario = new Voluntario();
        voluntario.setUsername(request.getUsername());
        voluntario.setFirstname(request.getFirstname());
        voluntario.setLastname(request.getLastname());
        voluntario.setEmail(request.getEmail());
        return voluntarioRepository.save(voluntario);
    }

    @Override
    public Voluntario update(Long id, Voluntario request) {
        Set<ConstraintViolation<Voluntario>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return voluntarioRepository.findById(id).map( vol ->
                voluntarioRepository.save(
                        vol.withFirstname(request.getFirstname())
                        .withLastname(request.getLastname())
                        .withUsername(request.getUsername())
                        .withEmail(request.getEmail()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, request.getId()));
    }

    @Override
    public ResponseEntity<?> delete(Long Voluntarioid) {
        return voluntarioRepository.findById(Voluntarioid).map(vol -> {
            voluntarioRepository.delete(vol);
            return ResponseEntity.ok().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, Voluntarioid));
    }
}
