package com.example.appbientMicroserviceEvento.api.service;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.DetallesEventoEvento;
import com.example.appbientMicroserviceEvento.api.domain.persistence.DetallesEventoRepository;
import com.example.appbientMicroserviceEvento.api.domain.persistence.EventosEventoRepository;
import com.example.appbientMicroserviceEvento.api.domain.service.DetallesEventoService;
import com.example.appbientMicroserviceEvento.api.resource.DetallesEvento.CreateDetallesEventoResource;
import com.example.appbientMicroserviceEvento.shared.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetallesEventoServiceImpl implements DetallesEventoService {
    private static final String ENTITY = "DetallesEvento";
    private final DetallesEventoRepository detallesEventoRepository;
    private final EventosEventoRepository eventosEventoRepository;

    public DetallesEventoServiceImpl(DetallesEventoRepository detallesEventoRepository, EventosEventoRepository eventosEventoRepository) {
        this.detallesEventoRepository = detallesEventoRepository;
        this.eventosEventoRepository = eventosEventoRepository;
    }

    @Override
    public List<DetallesEventoEvento> getAll() {
        return detallesEventoRepository.findAll();
    }

    @Override
    public DetallesEventoEvento getById(Long id) {
        return detallesEventoRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public DetallesEventoEvento create(Long eventoId, CreateDetallesEventoResource resource) {
        DetallesEventoEvento detallesEvento = new DetallesEventoEvento();
        detallesEvento.setPlace(detallesEvento.getPlace());
        detallesEvento.setStart_date(detallesEvento.getStart_date());
        detallesEvento.setEnd_date(detallesEvento.getEnd_date());
        return detallesEventoRepository.save(detallesEvento);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return detallesEventoRepository.findById(id).map(detallesEventoEvento -> {
            detallesEventoRepository.delete(detallesEventoEvento);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }
}
