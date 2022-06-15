package com.example.appbientMicroserviceEvento.api.resource.DetallesEvento;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class DetallesEventoResource {
    private Long id;
    private String place;
    private Date start_date;
    private Date end_date;
}
