package com.example.appbientMicroserviceEvento.api.mapping;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.DetallesEventoEvento;
import com.example.appbientMicroserviceEvento.api.resource.DetallesEvento.DetallesEventoResource;
import com.example.appbientMicroserviceEvento.api.resource.EventosEvento.CreateEventosEventoResource;
import com.example.appbientMicroserviceEvento.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class DetallesEventoMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public DetallesEventoResource toResource(DetallesEventoEvento pub){
        return mapper.map(pub, DetallesEventoResource.class);
    }
    public Page<DetallesEventoResource> modelListToPage(List<DetallesEventoEvento> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, DetallesEventoResource.class), pageable, modelList.size());
    }
    public DetallesEventoEvento toModel(CreateEventosEventoResource resource){
        return mapper.map(resource, DetallesEventoEvento.class);
    }
}
