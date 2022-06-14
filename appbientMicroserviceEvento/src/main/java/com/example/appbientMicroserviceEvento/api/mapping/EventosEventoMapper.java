package com.example.appbientMicroserviceEvento.api.mapping;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.EventosEvento;
import com.example.appbientMicroserviceEvento.api.resource.EventosEvento.CreateEventosEventoResource;
import com.example.appbientMicroserviceEvento.api.resource.EventosEvento.EventosEventoResource;
import com.example.appbientMicroserviceEvento.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class EventosEventoMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public EventosEventoResource toResource(EventosEvento pub){
        return mapper.map(pub, EventosEventoResource.class);
    }
    public Page<EventosEventoResource> modelListToPage(List<EventosEvento> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, EventosEventoResource.class), pageable, modelList.size());
    }
    public EventosEvento toModel(CreateEventosEventoResource resource){
        return mapper.map(resource, EventosEvento.class);
    }
}
