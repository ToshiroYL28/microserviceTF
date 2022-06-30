package com.example.appbient_microservice_usuarios.api.domain.service;

import com.example.appbient_microservice_usuarios.api.domain.model.entity.Local;
import com.example.appbient_microservice_usuarios.api.resource.Local.CreateLocalResource;


import java.util.List;

public interface LocalService {
    List<Local> findByOngId(Long ongId);
    Local create(Long ongId,CreateLocalResource request);
    Local update(Long id, Local Local);
}
