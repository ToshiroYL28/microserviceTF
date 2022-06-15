package com.example.appbientMicroserviceEvento.api.controllers;

import com.example.appbientMicroserviceEvento.api.domain.service.ActividadesEventoService;
import com.example.appbientMicroserviceEvento.api.mapping.ActividadesEventoMapper;
import com.example.appbientMicroserviceEvento.api.resource.ActividadesEvento.ActividadesEventoResource;
import com.example.appbientMicroserviceEvento.api.resource.ActividadesEvento.CreateActividadesEventoResource;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/eventos/{eventoId}/detallesEvento/actividades")
@Api(tags = "ActividadesEvento")
public class ActividadesEventoController {
    @Autowired
    private ActividadesEventoService actividadesEventoService;
    @Autowired
    private ActividadesEventoMapper mapper;

    @GetMapping
    public Page<ActividadesEventoResource> getAllActividadesEnEvento(@PathVariable Long eventoId, Pageable pageable){
        return mapper.modelListToPage(actividadesEventoService.getAll(), pageable);
    }
    @PostMapping
    public ActividadesEventoResource createActividadesEnEvento(@PathVariable Long detallesEventoId, @RequestBody CreateActividadesEventoResource resource){
        return mapper.toResource(actividadesEventoService.create(detallesEventoId, resource));
    }
    //@PutMapping
    //public ActvidadesEventoResource updateactvidadesEventoResource(@PathVariable Long id, @RequestBody UpdateActividadesEventoResource resource){
    //    return mapper.toResource(actividadesEventoService.update(id, mapper.toModel(resource)));
    //}
    @DeleteMapping("/{id}")
    public void deleteActividadesEvento(@PathVariable Long id){
        actividadesEventoService.delete(id);
    }
}
