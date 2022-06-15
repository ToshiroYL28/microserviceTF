package com.example.appbient_microservice_foro.api.domain.service;

import com.example.appbient_microservice_foro.api.domain.model.entity.PublicacionForo;
import com.example.appbient_microservice_foro.api.resource.PublicacionForo.CreatePublicacionForoResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublicacionForoService {
    List<PublicacionForo> getAll();
    PublicacionForo getById(Long id);
    PublicacionForo create(CreatePublicacionForoResource request);
    PublicacionForo update(Long id ,PublicacionForo publicacionForo);
    ResponseEntity<?> delete(Long PublicacionForoId);
}
