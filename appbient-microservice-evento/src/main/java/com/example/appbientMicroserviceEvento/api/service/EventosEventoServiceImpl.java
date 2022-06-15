package com.example.appbientMicroserviceEvento.api.service;

import com.example.appbientMicroserviceEvento.api.domain.model.entity.EventosEvento;
import com.example.appbientMicroserviceEvento.api.domain.persistence.EventosEventoRepository;
import com.example.appbientMicroserviceEvento.api.domain.service.EventosEventoService;
import com.example.appbientMicroserviceEvento.api.resource.EventosEvento.CreateEventosEventoResource;
import com.example.appbientMicroserviceEvento.shared.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventosEventoServiceImpl implements EventosEventoService {
    private static final String ENTITY = "Eventos";
    private final EventosEventoRepository eventosEventoRepository;

    public EventosEventoServiceImpl(EventosEventoRepository eventosEventoRepository) {
        this.eventosEventoRepository = eventosEventoRepository;
    }

    @Override
    public List<EventosEvento> getAll() {
        return eventosEventoRepository.findAll();
    }

    @Override
    public EventosEvento getById(Long id) {
        return eventosEventoRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public EventosEvento create(CreateEventosEventoResource request) {
        EventosEvento evento = new EventosEvento();
        evento.setActive(evento.getActive());
        evento.setName(evento.getName());
        evento.setDescription(evento.getDescription());
        evento.setStart_date(evento.getStart_date());
        return eventosEventoRepository.save(evento);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return eventosEventoRepository.findById(id).map(evento ->{
            eventosEventoRepository.delete(evento);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }


    //@Override
    //public EventosEvento create(CreateEventosEventoResource resource) {
    //    EventosEvento eventosEvento = new EventosEvento();
    //        eventosEvento.setActive(eventosEvento.getActive());
    //        eventosEvento.setName(eventosEvento.getName());
    //        eventosEvento.setDescription(eventosEvento.getDescription());
    //        eventosEvento.setStart_date(eventosEvento.getStart_date());
    //    return eventosEventoRepository.save(eventosEvento);
    //}
    //
    //
    //
    //
    //@Override
    //public ResponseEntity<?> delete(Long id) {
    //    return eventosEventoRepository.findById(id).map(
    //            eventosEvento -> {
    //                eventosEventoRepository.delete(eventosEvento);
    //                return ResponseEntity.ok().build();
    //            }
    //    ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    //}
}
