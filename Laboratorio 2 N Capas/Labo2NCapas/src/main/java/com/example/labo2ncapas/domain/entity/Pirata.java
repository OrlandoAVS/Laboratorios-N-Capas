package com.example.labo2ncapas.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "pirata")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pirata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(name = "nombre_del_pirata", nullable = false)
    private String name;

    @Column(name = "recompensa_del_pirata", nullable = false)
    private Double bounty;

    @Column(name = "tripulacion_pertenece", nullable = false)
    private String crew;

    @Column(name = "indica_si_vivo", nullable = false)
    private boolean alive;
}