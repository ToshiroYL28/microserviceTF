package com.example.appbient_microservice_foro.api.controllers;

import com.example.appbient_microservice_foro.api.domain.service.ComentarioForoService;
import com.example.appbient_microservice_foro.api.mapping.ComentarioForoMapper;
import com.example.appbient_microservice_foro.api.resource.ComentarioForo.ComentarioForoResource;
import com.example.appbient_microservice_foro.api.resource.ComentarioForo.CreateComentarioForoResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/publicacion/{publicacionId}/comentarios")
@Tag(name = "ComentarioForo")
public class ComentarioForoController {
    @Autowired
    private ComentarioForoService comentarioForoService;
    @Autowired
    private ComentarioForoMapper mapper;

    @GetMapping
    public Page<ComentarioForoResource> getAllComentariosEnPublicacion(@PathVariable Long publicacionId, Pageable pageable){
        return mapper.modelListToPage(comentarioForoService.findByForoId(publicacionId), pageable);
    }

    @PostMapping
    public ComentarioForoResource createComentario(@PathVariable Long publicacionId,@RequestBody CreateComentarioForoResource resource){
        return mapper.toResource(comentarioForoService.create(publicacionId,resource));
    }

    @DeleteMapping("/{id}")
    public void deleteComentario(@PathVariable Long id){
        comentarioForoService.delete(id);
    }

}
