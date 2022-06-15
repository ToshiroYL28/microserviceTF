package com.example.appbientMicroserviceProyecto.api.resource.Proyectos;

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
public class CreateProyectosResource {
    @NotNull
    @NotBlank
    private Long idOng;

    @NotNull
    @NotBlank
    private String name;
}
