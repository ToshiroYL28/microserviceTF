package com.example.appbientMicroserviceProyecto.api.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@With
@Table(name = "Proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idOng;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;

    private Date createDate;
    @NotNull
    @NotBlank
    private  Boolean active;
}