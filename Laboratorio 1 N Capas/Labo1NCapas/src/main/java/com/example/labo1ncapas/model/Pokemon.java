package com.example.labo1ncapas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Pokemon {
    private String nombre;
    private String tipo;
    private List<String> debilidades;
    private List<String> zonas;
    private String region;
}