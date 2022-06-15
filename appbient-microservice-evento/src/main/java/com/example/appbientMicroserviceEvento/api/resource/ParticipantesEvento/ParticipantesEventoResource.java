package com.example.appbientMicroserviceEvento.api.resource.ParticipantesEvento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class ParticipantesEventoResource {
    private Long id;
    private Long userId;
}
