package com.example.appbientMicroserviceEvento.api.controllers;

import com.example.appbientMicroserviceEvento.api.domain.service.ParticipantesEventoService;
import com.example.appbientMicroserviceEvento.api.mapping.ParticipantesEventoMapper;
import com.example.appbientMicroserviceEvento.api.resource.ParticipantesEvento.CreateParticipantesEventoResource;
import com.example.appbientMicroserviceEvento.api.resource.ParticipantesEvento.ParticipantesEventoResource;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/eventos/{eventoId}/participantes")
@Api(tags = "ParticipantesEvento")
public class ParticipantesEventoController {
    @Autowired
    private ParticipantesEventoService participantesEventoService;
    @Autowired
    ParticipantesEventoMapper mapper;
    @GetMapping
    public Page<ParticipantesEventoResource> getAll(@PathVariable Long eventoId, Pageable pageable){
        return mapper.modelListToPage(participantesEventoService.getAll(), pageable);
    }
    @PostMapping
    public ParticipantesEventoResource createLugaresEvento(@PathVariable Long detallesEventoId, @RequestBody CreateParticipantesEventoResource resource){
        return mapper.toResource(participantesEventoService.create(detallesEventoId, resource));
    }
    @DeleteMapping("/{id}")
    public void deleteLugaresEvento(@PathVariable Long id){
        participantesEventoService.delete(id);
    }
}
