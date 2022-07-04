package com.example.appbient_microservice_foro.api.controllers;

import com.example.appbient_microservice_foro.api.domain.service.PublicacionForoService;
import com.example.appbient_microservice_foro.api.mapping.PublicacionForoMapper;
import com.example.appbient_microservice_foro.api.resource.PublicacionForo.CreatePublicacionForoResource;
import com.example.appbient_microservice_foro.api.resource.PublicacionForo.PublicacionForoResource;
import com.example.appbient_microservice_foro.api.resource.PublicacionForo.UpdatePublicacionForoResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/publicacion")
@Tag(name = "Publicaciones")
public class PublicacionForoController {
    @Autowired
    private PublicacionForoService PublicacionForoService;

    @Autowired
    private PublicacionForoMapper mapper;

    @GetMapping
    public Page<PublicacionForoResource> getAllPublicacions(Pageable pageable){
        return mapper.modelListToPage(PublicacionForoService.getAll(), pageable);
    }

    @GetMapping("/{id}")
    public PublicacionForoResource getPublicacionById(@PathVariable Long id){
        return mapper.toResource(PublicacionForoService.getById(id));
    }

    @PostMapping
    public PublicacionForoResource createPublicacionForo(@RequestBody CreatePublicacionForoResource resource){
        return mapper.toResource(PublicacionForoService.create(resource));
    }

    @PutMapping("/{id}")
    public PublicacionForoResource updatePublicacionForo(@PathVariable Long id ,@RequestBody UpdatePublicacionForoResource resource){
        return mapper.toResource(PublicacionForoService.update(id,mapper.toModel(resource)));
    }

    @DeleteMapping("/{id}")
    public void deletePublicacionForo(@PathVariable Long id){
        PublicacionForoService.delete(id);
    }
}
