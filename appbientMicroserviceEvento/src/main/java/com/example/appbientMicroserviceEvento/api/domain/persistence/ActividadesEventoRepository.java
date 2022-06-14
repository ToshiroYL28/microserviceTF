package com.example.appbientMicroserviceEvento.api.domain.persistence;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.ActividadesEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadesEventoRepository extends JpaRepository<ActividadesEvento, Long> {
}
