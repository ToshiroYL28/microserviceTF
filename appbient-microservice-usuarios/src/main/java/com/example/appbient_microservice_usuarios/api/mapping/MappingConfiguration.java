package com.example.appbient_microservice_usuarios.api.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration("FortlomMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public VoluntarioMapper voluntarioMapper() {
        return new VoluntarioMapper();
    }

    @Bean
    public OngMapper ongMapper() {
        return new OngMapper();
    }

    @Bean
    public LocalMapper localMapper() {
        return new LocalMapper();
    }




}
