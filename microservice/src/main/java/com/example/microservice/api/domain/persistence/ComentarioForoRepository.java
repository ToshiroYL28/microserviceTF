package com.example.appbient_microservice_foro.api.domain.persistence;

import com.example.appbient_microservice_foro.api.domain.model.entity.ComentariosForo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioForoRepository extends JpaRepository<ComentariosForo, Long> {
    List<ComentariosForo> findByPublicacionId(Long foroId);
}
