package com.example.appbientMicroserviceEvento.api.resource.ParticipantesEvento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateParticipantesEventoResource {
    @NotNull
    @NotBlank
    private Long userId;
}
