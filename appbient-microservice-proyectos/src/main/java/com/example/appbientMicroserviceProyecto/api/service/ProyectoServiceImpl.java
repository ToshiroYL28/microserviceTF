package com.example.appbientMicroserviceProyecto.api.service;

import com.example.appbientMicroserviceProyecto.api.domain.model.entity.Proyecto;
import com.example.appbientMicroserviceProyecto.api.domain.persistence.ProyectosRepository;
import com.example.appbientMicroserviceProyecto.api.domain.service.ProyectoService;
import com.example.appbientMicroserviceProyecto.api.resource.proyectos.CreateProyectosResource;
import com.example.appbientMicroserviceProyecto.shared.exception.ResourceNotFoundException;
import com.example.appbientMicroserviceProyecto.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    private static final String ENTITY = "Proyectos";
    private final ProyectosRepository proyectosRepository;


    public ProyectoServiceImpl(ProyectosRepository proyectosRepository) {
        this.proyectosRepository = proyectosRepository;
    }

    @Override
    public List<Proyecto> getAll() {
        return proyectosRepository.findAll();
    }

    @Override
    public Proyecto getById(Long id) {
        return proyectosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Proyecto create(CreateProyectosResource request) {
        Proyecto pro = new Proyecto();
        pro.setIdOng(request.getIdOng());
        pro.setName(request.getName());
        pro.setActive(true);
        return proyectosRepository.save(pro);
    }

    @Override
    public Proyecto update(Long id, Proyecto request) {


        return proyectosRepository.findById(id).map( pub ->
                        proyectosRepository.save(
                                pub.withName(request.getName())
                                        .withActive(request.getActive())
                                        .withIdOng(request.getIdOng())
                        ))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, request.getId()));
    }

    @Override
    public ResponseEntity<?> delete(Long ProyectosId) {
        return proyectosRepository.findById(ProyectosId).map( pub -> {
            proyectosRepository.delete(pub);
            return ResponseEntity.ok().build();
        }).orElseThrow((() -> new ResourceNotFoundException(ENTITY, ProyectosId)));
    }
}
