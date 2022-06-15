package com.example.appbient_microservice_foro.api.domain.persistence;

import com.example.appbient_microservice_foro.api.domain.model.entity.PublicacionForo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionForoRepository extends JpaRepository<PublicacionForo, Long> {

}
