package com.example.appbient_microservice_foro.api.mapping;

import com.example.appbient_microservice_foro.api.domain.model.entity.PublicacionForo;
import com.example.appbient_microservice_foro.api.resource.PublicacionForo.CreatePublicacionForoResource;
import com.example.appbient_microservice_foro.api.resource.PublicacionForo.PublicacionForoResource;
import com.example.appbient_microservice_foro.api.resource.PublicacionForo.UpdatePublicacionForoResource;
import com.example.appbient_microservice_foro.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class PublicacionForoMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public PublicacionForoResource toResource(PublicacionForo pub) {
        return mapper.map(pub, PublicacionForoResource.class);
    }
    public Page<PublicacionForoResource> modelListToPage(List<PublicacionForo> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PublicacionForoResource.class), pageable, modelList.size());
    }
    
    public PublicacionForo toModel(CreatePublicacionForoResource PublicacionForoResource) {
        return mapper.map(PublicacionForoResource, PublicacionForo.class);
    }
    
    public PublicacionForo toModel(UpdatePublicacionForoResource PublicacionForoResource) {
        return mapper.map(PublicacionForoResource, PublicacionForo.class);
    }

}
