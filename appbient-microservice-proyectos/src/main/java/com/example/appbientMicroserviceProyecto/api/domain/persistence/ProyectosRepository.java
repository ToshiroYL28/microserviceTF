package com.example.appbientMicroserviceProyecto.api.domain.persistence;

import com.example.appbientMicroserviceProyecto.api.domain.model.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProyectosRepository extends JpaRepository<Proyecto,Long> {
}
