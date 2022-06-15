package com.example.appbientMicroserviceProyecto.api.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration("FortlomMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ProyectoMapper publicacionForoMapper() {
        return new ProyectoMapper();
    }



}
