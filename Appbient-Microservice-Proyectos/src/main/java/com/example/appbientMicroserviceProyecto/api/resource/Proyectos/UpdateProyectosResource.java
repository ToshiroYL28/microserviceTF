package com.example.appbientMicroserviceProyecto.api.resource.Proyectos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateProyectosResource {
    @NotNull
    @NotBlank
    private Long idOng;

    @NotNull
    @NotBlank
    private String name;

    private boolean active;
}
