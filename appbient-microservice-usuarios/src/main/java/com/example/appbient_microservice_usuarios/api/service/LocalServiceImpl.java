package com.example.appbient_microservice_usuarios.api.service;

import com.example.appbient_microservice_usuarios.api.domain.model.entity.Local;
import com.example.appbient_microservice_usuarios.api.domain.model.entity.Ong;
import com.example.appbient_microservice_usuarios.api.domain.persistence.LocalRepository;
import com.example.appbient_microservice_usuarios.api.domain.persistence.OngRepository;
import com.example.appbient_microservice_usuarios.api.domain.service.LocalService;
import com.example.appbient_microservice_usuarios.api.resource.Local.CreateLocalResource;
import com.example.appbient_microservice_usuarios.shared.exception.ResourceNotFoundException;
import com.example.appbient_microservice_usuarios.shared.exception.ResourceValidationException;

import org.springframework.stereotype.Service;



import java.util.List;


@Service
public class LocalServiceImpl implements LocalService {
    private static final String ENTITY="Local";

    private final LocalRepository localRepository;
    private final OngRepository ongRepository;


    public LocalServiceImpl(LocalRepository localRepository,OngRepository ongRepository) {
        this.localRepository = localRepository;
        this.ongRepository=ongRepository;


    }
    @Override
    public List<Local> findByOngId(Long ongId) {   return localRepository.findByOngId(ongId);    }
    @Override
    public Local create(Long ongId, CreateLocalResource request) {
        Ong ong= ongRepository.findById(ongId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, ongId));
        Local local=new Local();
        local.setAddress(request.getAddress());
        local.setOng(ong);
        return localRepository.save(local);
    }

    @Override
    public Local update(Long id, Local request) {
        return localRepository.findById(id).map( l->
                localRepository.save(l.withAddress(request.getAddress())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, request.getId()));
    }



}
