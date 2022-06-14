package com.example.appbient_microservice_usuarios.api.domain.service;

import com.example.appbient_microservice_usuarios.api.domain.model.entity.Ong;
import com.example.appbient_microservice_usuarios.api.resource.Ong.CreateOngResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OngService {
    List<Ong> getAll();
    Ong getById(Long id);
    Ong create(CreateOngResource request);
    Ong update(Long id, Ong request);
    ResponseEntity<?> delete(Long Ongid);
}
