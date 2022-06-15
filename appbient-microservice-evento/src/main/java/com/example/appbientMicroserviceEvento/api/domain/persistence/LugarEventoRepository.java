package com.example.appbientMicroserviceEvento.api.domain.persistence;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.LugarEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LugarEventoRepository extends JpaRepository<LugarEvento, Long> {
}
