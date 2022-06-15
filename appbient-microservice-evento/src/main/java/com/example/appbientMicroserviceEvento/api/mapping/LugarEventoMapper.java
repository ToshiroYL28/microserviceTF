package com.example.appbientMicroserviceEvento.api.mapping;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.LugarEvento;
import com.example.appbientMicroserviceEvento.api.resource.LugarEvento.CreateLugarEventoResource;
import com.example.appbientMicroserviceEvento.api.resource.LugarEvento.LugarEventoResource;
import com.example.appbientMicroserviceEvento.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class LugarEventoMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public LugarEventoResource toResource(LugarEvento pub){
        return mapper.map(pub, LugarEventoResource.class);
    }
    public Page<LugarEventoResource> modelListToPage(List<LugarEvento> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, LugarEventoResource.class), pageable, modelList.size());
    }
    public LugarEvento toModel(CreateLugarEventoResource resource){
        return mapper.map(resource, LugarEvento.class);
    }
}
