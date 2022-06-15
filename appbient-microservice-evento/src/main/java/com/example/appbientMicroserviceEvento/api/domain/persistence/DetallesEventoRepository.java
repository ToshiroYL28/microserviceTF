package com.example.appbientMicroserviceEvento.api.domain.persistence;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.DetallesEventoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallesEventoRepository extends JpaRepository<DetallesEventoEvento, Long> {
}
