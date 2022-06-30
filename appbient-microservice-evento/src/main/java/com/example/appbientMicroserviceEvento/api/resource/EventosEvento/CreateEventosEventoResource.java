package com.example.appbientMicroserviceEvento.api.resource.EventosEvento;

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
public class CreateEventosEventoResource {

    private String name;

    private String description;

    private Boolean active;

    private Date start_date;
}
