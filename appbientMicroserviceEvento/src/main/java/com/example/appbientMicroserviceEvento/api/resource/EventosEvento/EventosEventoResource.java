package com.example.appbientMicroserviceEvento.api.resource.EventosEvento;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class EventosEventoResource {
    private Long id;
    private String name;
    private String description;
    private Boolean active;
    private Date start_date;
}
