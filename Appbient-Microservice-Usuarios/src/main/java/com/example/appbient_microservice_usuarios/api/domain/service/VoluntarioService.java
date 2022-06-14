package com.example.appbient_microservice_usuarios.api.domain.service;

import com.example.appbient_microservice_usuarios.api.domain.model.entity.Voluntario;
import com.example.appbient_microservice_usuarios.api.resource.Voluntario.CreateVoluntarioResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VoluntarioService {
    List<Voluntario> getAll();
    Voluntario getById(Long id);
    Voluntario create(CreateVoluntarioResource request);
    Voluntario update(Long id, Voluntario request);
    ResponseEntity<?> delete(Long Voluntarioid);
}
