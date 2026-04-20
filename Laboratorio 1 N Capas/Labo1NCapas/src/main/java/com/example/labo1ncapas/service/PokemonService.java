package com.example.labo1ncapas.service;

import com.example.labo1ncapas.model.Pokemon;
import com.example.labo1ncapas.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> filtrarPorTipo(String tipo) {
        return pokemonRepository.findAll().stream()
                .filter(p -> p.getTipo().equalsIgnoreCase(tipo))
                .toList();
    }

    public List<Pokemon> filtrarPorZona(String zona) {
        return pokemonRepository.findAll().stream()
                .filter(p -> p.getZonas().stream()
                        .anyMatch(z -> z.equalsIgnoreCase(zona)))
                .toList();
    }

    public List<Pokemon> filtrarPorDebilidad(String debilidad) {
        return pokemonRepository.findAll().stream()
                .filter(p -> p.getDebilidades().stream()
                        .anyMatch(d -> d.equalsIgnoreCase(debilidad)))
                .toList();
    }
}