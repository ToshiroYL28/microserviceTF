package com.example.appbientMicroserviceEvento.api.domain.service;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.DetallesEventoEvento;
import com.example.appbientMicroserviceEvento.api.domain.model.entity.EventosEvento;
import com.example.appbientMicroserviceEvento.api.resource.DetallesEvento.CreateDetallesEventoResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetallesEventoService {
    List<DetallesEventoEvento> getAll();
    DetallesEventoEvento getById(Long id);
    DetallesEventoEvento create(Long eventoId, CreateDetallesEventoResource resource);
    ResponseEntity<?> delete(Long id);
}
