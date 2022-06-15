package com.example.appbientMicroserviceEvento.api.domain.service;


import com.example.appbientMicroserviceEvento.api.domain.model.entity.ParticipantesEvento;
import com.example.appbientMicroserviceEvento.api.resource.ParticipantesEvento.CreateParticipantesEventoResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParticipantesEventoService {
    List<ParticipantesEvento> getAll();
    ParticipantesEvento getById(Long id);
    ParticipantesEvento create(Long detallesEventoId, CreateParticipantesEventoResource request);
    ResponseEntity<?> delete(Long id);
}
