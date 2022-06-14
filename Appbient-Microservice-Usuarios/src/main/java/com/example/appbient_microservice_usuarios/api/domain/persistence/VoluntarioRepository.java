package com.example.appbient_microservice_usuarios.api.domain.persistence;

import com.example.appbient_microservice_usuarios.api.domain.model.entity.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {

}
