package com.example.appbientMicroserviceEvento.api.controllers;

import com.example.appbientMicroserviceEvento.api.domain.service.LugarEventoService;
import com.example.appbientMicroserviceEvento.api.mapping.LugarEventoMapper;
import com.example.appbientMicroserviceEvento.api.resource.LugarEvento.CreateLugarEventoResource;
import com.example.appbientMicroserviceEvento.api.resource.LugarEvento.LugarEventoResource;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/eventos/{eventoId}/detallesEvento/lugarEvento")
@Api(tags = "LugarEvento")
public class LugarEventoController {
    @Autowired
    private LugarEventoService lugarEventoService;
    @Autowired
    LugarEventoMapper mapper;

    @GetMapping
    public Page<LugarEventoResource> getAllLugaresEvento(@PathVariable Long eventoId, Pageable pageable){
        return mapper.modelListToPage(lugarEventoService.getAll(), pageable);
    }
    @PostMapping
    public LugarEventoResource createLugaresEvento(@PathVariable Long detallesEventoId, @RequestBody CreateLugarEventoResource resource){
        return mapper.toResource(lugarEventoService.create(detallesEventoId, resource));
    }
    //@PutMapping
    //public LugarEventoResource updateLugaresEvento(@PathVariable Long id, @RequestBody UpdateLugarEventoResource resource){
    //    return mapper.toResource(lugarEventoService.update(id, mapper.toModel(resource)));
    //}
    @DeleteMapping("/{id}")
    public void deleteLugaresEvento(@PathVariable Long id){
        lugarEventoService.delete(id);
    }
}
