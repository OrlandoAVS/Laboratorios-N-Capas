package com.example.labo2ncapas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Piratas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoPiratas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nombre_del_pirata")
    private String name;

    @Column(name = "recompensa_del_pirata")
    private Double bounty;

    @Column(name = "tripulacion_pertenece")
    private String crew;

    @Column(name = "indica_si_vivo")
    private Boolean isAlive;
}


