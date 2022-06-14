package com.example.appbientMicroserviceEvento.api.domain.service;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.ActividadesEvento;
import com.example.appbientMicroserviceEvento.api.resource.ActividadesEvento.CreateActividadesEventoResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActividadesEventoService {
    List<ActividadesEvento> getAll();
    ActividadesEvento getById(Long id);
    ActividadesEvento create(Long detallesEventoId, CreateActividadesEventoResource request);
    ResponseEntity<?> delete(Long id);
}
