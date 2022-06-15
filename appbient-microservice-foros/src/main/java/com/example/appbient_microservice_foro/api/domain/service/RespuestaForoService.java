package com.example.appbient_microservice_foro.api.domain.service;

import com.example.appbient_microservice_foro.api.domain.model.entity.RespuestaForo;
import com.example.appbient_microservice_foro.api.resource.RespuestaForo.CreateRespuestaForoResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RespuestaForoService {
    List<RespuestaForo> findByComentario(Long ComentarioId);
    RespuestaForo create(Long comentarioId,CreateRespuestaForoResource respuestaForo);
    ResponseEntity<?> delete(Long id);
}
