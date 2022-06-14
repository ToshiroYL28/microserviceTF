package com.example.appbientMicroserviceEvento.api.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@With
@Table(name = "ParticipantesEvento")
public class ParticipantesEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private Long userId;

    @ManyToOne(targetEntity = EventosEvento.class)
    @JoinColumn(name = "eventosid")
    private EventosEvento eventosEvento;
}
