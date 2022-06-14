package com.example.appbientMicroserviceEvento.api.domain.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@With
@Table(name = "LugarEvento")
public class LugarEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String address;

    @ManyToOne(targetEntity =  DetallesEventoEvento.class)
    @JoinColumn(name = "detalleseventoid")
    private DetallesEventoEvento detallesEventoEvento;
}
