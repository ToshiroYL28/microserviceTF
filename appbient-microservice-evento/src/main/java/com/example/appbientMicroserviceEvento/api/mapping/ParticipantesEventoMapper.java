package com.example.appbientMicroserviceEvento.api.mapping;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.ParticipantesEvento;
import com.example.appbientMicroserviceEvento.api.resource.ParticipantesEvento.CreateParticipantesEventoResource;
import com.example.appbientMicroserviceEvento.api.resource.ParticipantesEvento.ParticipantesEventoResource;
import com.example.appbientMicroserviceEvento.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ParticipantesEventoMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ParticipantesEventoResource toResource(ParticipantesEvento pub){
        return mapper.map(pub, ParticipantesEventoResource.class);
    }
    public Page<ParticipantesEventoResource> modelListToPage(List<ParticipantesEvento> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, ParticipantesEventoResource.class), pageable, modelList.size());
    }
    public ParticipantesEvento toModel(CreateParticipantesEventoResource resource){
        return mapper.map(resource, ParticipantesEvento.class);
    }
}
