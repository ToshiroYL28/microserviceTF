package com.example.appbientMicroserviceEvento.api.mapping;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.ActividadesEvento;
import com.example.appbientMicroserviceEvento.api.resource.ActividadesEvento.ActividadesEventoResource;
import com.example.appbientMicroserviceEvento.api.resource.ActividadesEvento.CreateActividadesEventoResource;
import com.example.appbientMicroserviceEvento.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ActividadesEventoMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ActividadesEventoResource toResource(ActividadesEvento pub){
        return mapper.map(pub, ActividadesEventoResource.class);
    }
    public Page<ActividadesEventoResource> modelListToPage(List<ActividadesEvento> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, ActividadesEventoResource.class), pageable, modelList.size());
    }
    public ActividadesEvento toModel(CreateActividadesEventoResource resource){
        return mapper.map(resource, ActividadesEvento.class);
    }
}
