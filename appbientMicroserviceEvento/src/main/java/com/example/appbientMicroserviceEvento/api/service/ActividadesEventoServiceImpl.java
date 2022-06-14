package com.example.appbientMicroserviceEvento.api.service;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.ActividadesEvento;
import com.example.appbientMicroserviceEvento.api.domain.persistence.ActividadesEventoRepository;
import com.example.appbientMicroserviceEvento.api.domain.service.ActividadesEventoService;
import com.example.appbientMicroserviceEvento.api.resource.ActividadesEvento.CreateActividadesEventoResource;
import com.example.appbientMicroserviceEvento.shared.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActividadesEventoServiceImpl implements ActividadesEventoService {
    private static final String ENTITY = "Actividades";
    private final ActividadesEventoRepository actividadesEventoRepository;

    public ActividadesEventoServiceImpl(ActividadesEventoRepository actividadesEventoRepository) {
        this.actividadesEventoRepository = actividadesEventoRepository;
    }

    @Override
    public List<ActividadesEvento> getAll() {
        return actividadesEventoRepository.findAll();
    }

    @Override
    public ActividadesEvento getById(Long id) {
        return actividadesEventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public ActividadesEvento create(Long detallesEventoId, CreateActividadesEventoResource request) {
        ActividadesEvento actividadesEvento = new ActividadesEvento();
        actividadesEvento.setName(actividadesEvento.getName());
        actividadesEvento.setDescription(actividadesEvento.getDescription());
        return actividadesEventoRepository.save(actividadesEvento);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return actividadesEventoRepository.findById(id).map(actividadesEvento -> {
            actividadesEventoRepository.delete(actividadesEvento);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }
}
