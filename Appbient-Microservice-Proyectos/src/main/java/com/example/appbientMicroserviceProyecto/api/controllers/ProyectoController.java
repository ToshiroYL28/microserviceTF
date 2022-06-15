package com.example.appbientMicroserviceProyecto.api.controllers;

import com.example.appbientMicroserviceProyecto.api.domain.service.ProyectoService;
import com.example.appbientMicroserviceProyecto.api.mapping.ProyectoMapper;
import com.example.appbientMicroserviceProyecto.api.resource.Proyectos.CreateProyectosResource;
import com.example.appbientMicroserviceProyecto.api.resource.Proyectos.ProyectosResource;
import com.example.appbientMicroserviceProyecto.api.resource.Proyectos.UpdateProyectosResource;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/proyectos")
@Api(tags = "Proyectos")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private ProyectoMapper mapper;

    @GetMapping
    public Page<ProyectosResource> getAllComentariosEnPublicacion( Pageable pageable){
        return mapper.modelListToPage(proyectoService.getAll(), pageable);
    }

    @GetMapping("/{id}")
    public ProyectosResource getPublicacionById(@PathVariable Long id){
        return mapper.toResource(proyectoService.getById(id));
    }

    @PutMapping("/{id}")
    public ProyectosResource updatePublicacionForo(@PathVariable Long id ,@RequestBody UpdateProyectosResource resource){
        return mapper.toResource(proyectoService.update(id,mapper.toModel(resource)));
    }


    @PostMapping
    public ProyectosResource createComentario(@RequestBody CreateProyectosResource resource){
        return mapper.toResource(proyectoService.create(resource));
    }

    @DeleteMapping("/{id}")
    public void deleteComentario(@PathVariable Long id){
        proyectoService.delete(id);
    }

}
