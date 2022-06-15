package com.example.appbient_microservice_foro.api.mapping;

import com.example.appbient_microservice_foro.api.domain.model.entity.ComentariosForo;
import com.example.appbient_microservice_foro.api.resource.ComentarioForo.ComentarioForoResource;
import com.example.appbient_microservice_foro.api.resource.ComentarioForo.CreateComentarioForoResource;
import com.example.appbient_microservice_foro.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ComentarioForoMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ComentarioForoResource toResource(ComentariosForo ComentariosForo) {
        return mapper.map(ComentariosForo, ComentarioForoResource.class);
    }

    public Page<ComentarioForoResource> modelListToPage(List<ComentariosForo> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ComentarioForoResource.class), pageable, modelList.size());
    }

    public ComentariosForo toModel(CreateComentarioForoResource ComentarioForoResource) {
        return mapper.map(ComentarioForoResource, ComentariosForo.class);
    }
}
