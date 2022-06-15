package com.example.appbientMicroserviceEvento.api.controllers;

import com.example.appbientMicroserviceEvento.api.domain.service.EventosEventoService;
import com.example.appbientMicroserviceEvento.api.mapping.EventosEventoMapper;
import com.example.appbientMicroserviceEvento.api.resource.EventosEvento.CreateEventosEventoResource;
import com.example.appbientMicroserviceEvento.api.resource.EventosEvento.EventosEventoResource;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/eventos")
@Api(tags = "Evento")
public class EventosEventoController {
    @Autowired
    private EventosEventoService eventosEventoService;
    //a
    @Autowired
    private EventosEventoMapper mapper;

    @GetMapping
    public Page<EventosEventoResource> getAll(Pageable pageable){
        return mapper.modelListToPage(eventosEventoService.getAll(), pageable);
    }
    @PostMapping
    public EventosEventoResource createEvento(@RequestBody CreateEventosEventoResource resource){
        return mapper.toResource(eventosEventoService.create(resource));
    }
    @DeleteMapping("/{id}")
    public void deleteEvento(@PathVariable Long id){
        eventosEventoService.delete(id);
    }

}
