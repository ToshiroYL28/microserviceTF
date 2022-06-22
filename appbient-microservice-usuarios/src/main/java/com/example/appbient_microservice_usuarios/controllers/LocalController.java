package com.example.appbient_microservice_usuarios.controllers;

import com.example.appbient_microservice_usuarios.api.domain.service.LocalService;
import com.example.appbient_microservice_usuarios.api.mapping.LocalMapper;
import com.example.appbient_microservice_usuarios.api.resource.Local.CreateLocalResource;
import com.example.appbient_microservice_usuarios.api.resource.Local.LocalResource;

import com.example.appbient_microservice_usuarios.api.resource.Local.UpdateLocalResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ong/{ongId}/local")
@Tag(name = "Local")
public class LocalController {
    @Autowired
    private LocalService localService;
    @Autowired
    private LocalMapper mapper;


    @PostMapping
    public LocalResource createLocal(@RequestBody CreateLocalResource resource) {
        return mapper.toResource(localService.create(resource));
    }

    @PutMapping("/{localId}")
    public LocalResource updateLocal(@PathVariable Long localId, @RequestBody UpdateLocalResource resource) {
        return mapper.toResource(localService.update(localId, mapper.toModel(resource)));
    }


}
