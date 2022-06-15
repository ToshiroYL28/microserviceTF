package com.example.appbient_microservice_usuarios.api.service;

import com.example.appbient_microservice_usuarios.api.domain.model.entity.Ong;
import com.example.appbient_microservice_usuarios.api.domain.persistence.OngRepository;
import com.example.appbient_microservice_usuarios.api.domain.service.OngService;
import com.example.appbient_microservice_usuarios.api.resource.Ong.CreateOngResource;
import com.example.appbient_microservice_usuarios.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class OngServiceImpl implements OngService {
    private final String ENTITY="ONG";

    private final OngRepository ongRepository;
    private final Validator validator;

    public OngServiceImpl(OngRepository ongRepository, Validator validator) {
        this.ongRepository = ongRepository;
        this.validator = validator;
    }

    @Override
    public List<Ong> getAll() {
        return ongRepository.findAll();
    }

    @Override
    public Ong getById(Long id) {
        return ongRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ONG not found"));
    }

    @Override
    public Ong create(CreateOngResource request) {
        Ong ong = new Ong();
        ong.setName(request.getEmail());
        ong.setDescription(request.getDescription());
        ong.setEmail(request.getEmail());
        return ongRepository.save(ong);
    }

    @Override
    public Ong update(Long id, Ong request) {
        Set<ConstraintViolation<Ong>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return ongRepository.findById(id).map(ong ->
            ongRepository.save(
                    ong.withName(request.getName())
                            .withDescription(request.getDescription())
                            .withEmail(request.getEmail()))
        ).orElseThrow(() -> new IllegalArgumentException("ONG not found"));
    }

    @Override
    public ResponseEntity<?> delete(Long Ongid) {
        return ongRepository.findById(Ongid).map(ong -> {
            ongRepository.delete(ong);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException("ONG not found"));
    }
}
