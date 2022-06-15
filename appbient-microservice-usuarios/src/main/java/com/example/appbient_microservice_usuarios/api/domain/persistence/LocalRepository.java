package com.example.appbient_microservice_usuarios.api.domain.persistence;

import com.example.appbient_microservice_usuarios.api.domain.model.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalRepository extends JpaRepository<Local, Long> {
    List<Local> findAllByOngId(Long ongId);
}
