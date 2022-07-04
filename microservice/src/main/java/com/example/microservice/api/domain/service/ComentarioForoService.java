package com.example.appbient_microservice_foro.api.domain.service;

import com.example.appbient_microservice_foro.api.domain.model.entity.ComentariosForo;
import com.example.appbient_microservice_foro.api.resource.ComentarioForo.CreateComentarioForoResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComentarioForoService {
    List<ComentariosForo> findByForoId(Long foroId);
    ComentariosForo create(Long foroId,CreateComentarioForoResource comentario);
    ResponseEntity<?> delete(Long id);
}
