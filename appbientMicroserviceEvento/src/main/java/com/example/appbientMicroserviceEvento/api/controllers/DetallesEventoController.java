package com.example.appbientMicroserviceEvento.api.controllers;

import com.example.appbientMicroserviceEvento.api.domain.service.DetallesEventoService;
import com.example.appbientMicroserviceEvento.api.mapping.DetallesEventoMapper;
import com.example.appbientMicroserviceEvento.api.resource.DetallesEvento.CreateDetallesEventoResource;
import com.example.appbientMicroserviceEvento.api.resource.DetallesEvento.DetallesEventoResource;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/eventos/{eventoId}/detallesEvento")
@Api(tags = "DetallesEvento")
public class DetallesEventoController {
    @Autowired
    private DetallesEventoService detallesEventoService;

    @Autowired
    private DetallesEventoMapper mapper;

    @GetMapping
    public Page<DetallesEventoResource> getDetallesEventos(Pageable pageable){
        return mapper.modelListToPage(detallesEventoService.getAll(), pageable);
    }
    @PostMapping
    public DetallesEventoResource createDetallesEvento(@PathVariable Long eventoId, @RequestBody CreateDetallesEventoResource resource){
        return mapper.toResource(detallesEventoService.create(eventoId, resource));
    }
    @DeleteMapping("/{id}")
    public void deleteDetallesEvento(@PathVariable Long id){
        detallesEventoService.delete(id);
    }
}
