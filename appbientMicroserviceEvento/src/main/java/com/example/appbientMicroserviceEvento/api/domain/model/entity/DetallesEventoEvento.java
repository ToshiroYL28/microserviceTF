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
@Table(name = "DetallesEventoEvento")
public class DetallesEventoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String place;

    @NotNull
    @NotBlank
    private Date start_date;

    @NotNull
    @NotBlank
    private Date end_date;

    @OneToMany(targetEntity =  LugarEvento.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "detalleseventoid", referencedColumnName = "id")
    private List<ActividadesEvento> actividadesEvento;

    @OneToMany(targetEntity =  LugarEvento.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "detalleseventoid", referencedColumnName = "id")
    private List<LugarEvento> lugarEvento;
}
