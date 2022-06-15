package com.example.appbient_microservice_usuarios.api.domain.persistence;

import com.example.appbient_microservice_usuarios.api.domain.model.entity.Ong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngRepository extends JpaRepository<Ong, Long> {
}
