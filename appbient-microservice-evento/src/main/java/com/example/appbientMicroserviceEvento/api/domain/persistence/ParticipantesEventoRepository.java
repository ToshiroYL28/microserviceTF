package com.example.appbientMicroserviceEvento.api.domain.persistence;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.ParticipantesEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantesEventoRepository extends JpaRepository<ParticipantesEvento, Long> {
}
