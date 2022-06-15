package com.example.appbientMicroserviceEvento.api.service;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.ParticipantesEvento;
import com.example.appbientMicroserviceEvento.api.domain.persistence.ParticipantesEventoRepository;
import com.example.appbientMicroserviceEvento.api.domain.service.ParticipantesEventoService;
import com.example.appbientMicroserviceEvento.api.resource.ParticipantesEvento.CreateParticipantesEventoResource;
import com.example.appbientMicroserviceEvento.shared.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantesEventoServiceImpl implements ParticipantesEventoService {
    private static final String ENTITY = "Participantes";
    private final ParticipantesEventoRepository participantesEventoRepository;

    public ParticipantesEventoServiceImpl(ParticipantesEventoRepository participantesEventoRepository) {
        this.participantesEventoRepository = participantesEventoRepository;
    }

    @Override
    public List<ParticipantesEvento> getAll() {
        return participantesEventoRepository.findAll();
    }

    @Override
    public ParticipantesEvento getById(Long id) {
        return participantesEventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ParticipantesEvento create(Long detallesEventoId, CreateParticipantesEventoResource request) {
        ParticipantesEvento participantesEvento = new ParticipantesEvento();
        participantesEvento.setUserId(participantesEvento.getUserId());
        return participantesEventoRepository.save(participantesEvento);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return participantesEventoRepository.findById(id).map( participantesEvento -> {
            participantesEventoRepository.delete(participantesEvento);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }
}
