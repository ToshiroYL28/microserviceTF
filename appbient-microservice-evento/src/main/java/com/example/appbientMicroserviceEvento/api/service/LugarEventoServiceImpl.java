package com.example.appbientMicroserviceEvento.api.service;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.LugarEvento;
import com.example.appbientMicroserviceEvento.api.domain.persistence.LugarEventoRepository;
import com.example.appbientMicroserviceEvento.api.domain.service.LugarEventoService;
import com.example.appbientMicroserviceEvento.api.resource.LugarEvento.CreateLugarEventoResource;
import com.example.appbientMicroserviceEvento.shared.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LugarEventoServiceImpl implements LugarEventoService {
    private static final String ENTITY = "Lugar";
    private final LugarEventoRepository lugarEventoRepository;

    public LugarEventoServiceImpl(LugarEventoRepository lugarEventoRepository) {
        this.lugarEventoRepository = lugarEventoRepository;
    }

    @Override
    public List<LugarEvento> getAll() {
        return lugarEventoRepository.findAll();
    }

    @Override
    public LugarEvento getById(Long id) {
        return lugarEventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public LugarEvento create(Long detallesEventoId, CreateLugarEventoResource request) {
        LugarEvento lugarEvento = new LugarEvento();
        lugarEvento.setAddress(lugarEvento.getAddress());
        return lugarEventoRepository.save(lugarEvento);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return lugarEventoRepository.findById(id).map(lugarEvento -> {
            lugarEventoRepository.delete(lugarEvento);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }
}
