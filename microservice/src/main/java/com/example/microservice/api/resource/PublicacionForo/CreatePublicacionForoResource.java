package com.example.appbient_microservice_foro.api.resource.PublicacionForo;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePublicacionForoResource {
    private boolean active;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String description;
    private Long voluntarioId;
    private Long ongId;
    private Long topicoId;
}
