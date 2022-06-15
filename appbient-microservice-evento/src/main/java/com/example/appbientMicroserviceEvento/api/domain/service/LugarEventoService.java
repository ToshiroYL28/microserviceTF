package com.example.appbientMicroserviceEvento.api.domain.service;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.LugarEvento;
import com.example.appbientMicroserviceEvento.api.resource.LugarEvento.CreateLugarEventoResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LugarEventoService {
    List<LugarEvento> getAll();
    LugarEvento getById(Long id);
    LugarEvento create(Long detallesEventoId, CreateLugarEventoResource request);
    ResponseEntity<?> delete(Long id);
}
