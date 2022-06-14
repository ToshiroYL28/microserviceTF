package com.example.appbientMicroserviceEvento.api.domain.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@With
@Table(name = "EventosEvento")
public class EventosEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String description;

    private Boolean active;

    @NotNull
    @NotBlank
    private Date start_date;

    @OneToMany(targetEntity = ParticipantesEvento.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "eventosid", referencedColumnName = "id")
    private List<ParticipantesEvento> participantesEvento;
}
