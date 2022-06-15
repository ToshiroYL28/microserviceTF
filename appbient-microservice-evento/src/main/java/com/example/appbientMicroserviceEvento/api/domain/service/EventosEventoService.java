package com.example.appbientMicroserviceEvento.api.domain.service;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.EventosEvento;
import com.example.appbientMicroserviceEvento.api.resource.EventosEvento.CreateEventosEventoResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EventosEventoService {
    List<EventosEvento> getAll();
    EventosEvento getById(Long id);
    EventosEvento create(CreateEventosEventoResource request);
    ResponseEntity<?> delete(Long id);
}
