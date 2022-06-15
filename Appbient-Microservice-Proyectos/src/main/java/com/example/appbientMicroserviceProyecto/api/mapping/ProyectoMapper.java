package com.example.appbientMicroserviceProyecto.api.mapping;

import com.example.appbientMicroserviceProyecto.api.domain.model.entity.Proyecto;
import com.example.appbientMicroserviceProyecto.api.resource.Proyectos.CreateProyectosResource;
import com.example.appbientMicroserviceProyecto.api.resource.Proyectos.ProyectosResource;
import com.example.appbientMicroserviceProyecto.api.resource.Proyectos.UpdateProyectosResource;
import com.example.appbientMicroserviceProyecto.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ProyectoMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ProyectosResource toResource(Proyecto ComentariosForo) {
        return mapper.map(ComentariosForo, ProyectosResource.class);
    }

    public Page<ProyectosResource> modelListToPage(List<Proyecto> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ProyectosResource.class), pageable, modelList.size());
    }

    public Proyecto toModel(UpdateProyectosResource ProyectosResource) {
        return mapper.map(ProyectosResource, Proyecto.class);
    }
}
