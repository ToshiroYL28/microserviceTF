package com.example.appbientMicroserviceEvento.api.resource.DetallesEvento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDetallesEventoResource {
    @NotNull
    @NotBlank
    private String place;

    @NotNull
    @NotBlank
    private Date start_date;

    @NotNull
    @NotBlank
    private Date end_date;
}
