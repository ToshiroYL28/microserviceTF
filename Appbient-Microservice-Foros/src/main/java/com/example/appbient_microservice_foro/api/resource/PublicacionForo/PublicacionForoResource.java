package com.example.appbient_microservice_foro.api.resource.PublicacionForo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicacionForoResource {
    private Long id;
    private boolean active;
    private String name;
    private String description;
}
