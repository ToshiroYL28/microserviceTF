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
@Table(name = "ActividadesEvento")
public class ActividadesEvento {
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

    @ManyToOne(targetEntity =  DetallesEventoEvento.class)
    @JoinColumn(name = "detalleseventoid")
    private DetallesEventoEvento detallesEventoEvento;
}
