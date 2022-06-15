package com.example.appbientMicroserviceEvento.api.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("FortlomMappingConfiguration")

public class MapperConfiguration {
    @Bean
    public EventosEventoMapper eventosEventoMapper(){
        return new EventosEventoMapper();
    }
    @Bean
    public DetallesEventoMapper detallesEventoMapper(){
        return new DetallesEventoMapper();
    }
    @Bean
    public LugarEventoMapper lugarEventoMapper(){
        return new LugarEventoMapper();
    }
    @Bean
    public ActividadesEventoMapper actividadesEventoMapper(){
        return new ActividadesEventoMapper();
    }
    @Bean
    public ParticipantesEventoMapper participantesEventoMapper(){
        return new ParticipantesEventoMapper();
    }
}
