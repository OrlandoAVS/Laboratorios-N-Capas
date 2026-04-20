package com.example.labo1ncapas.repository;

import com.example.labo1ncapas.model.Pokemon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PokemonRepository {

    public List<Pokemon> findAll() {
        return List.of(
                new Pokemon("Charmander", "Fuego",
                        List.of("Agua", "Roca", "Tierra"),
                        List.of("Cueva", "Montaña"), "Kanto"),

                new Pokemon("Squirtle", "Agua",
                        List.of("Planta", "Eléctrico"),
                        List.of("Lago", "Mar"), "Kanto"),

                new Pokemon("Bulbasaur", "Planta",
                        List.of("Fuego", "Hielo", "Veneno", "Volador"),
                        List.of("Bosque", "Hierba Alta"), "Kanto"),

                new Pokemon("Pikachu", "Eléctrico",
                        List.of("Tierra"),
                        List.of("Bosque", "Hierba Alta"), "Kanto"),

                new Pokemon("Geodude", "Roca",
                        List.of("Agua", "Planta", "Tierra", "Acero"),
                        List.of("Cueva", "Montaña"), "Kanto"),

                new Pokemon("Psyduck", "Agua",
                        List.of("Planta", "Eléctrico"),
                        List.of("Lago", "Mar"), "Kanto"),

                new Pokemon("Vulpix", "Fuego",
                        List.of("Agua", "Roca", "Tierra"),
                        List.of("Hierba Alta", "Montaña"), "Kanto"),

                new Pokemon("Oddish", "Planta",
                        List.of("Fuego", "Hielo", "Veneno", "Volador"),
                        List.of("Bosque", "Hierba Alta"), "Kanto"),

                new Pokemon("Magikarp", "Agua",
                        List.of("Planta", "Eléctrico"),
                        List.of("Mar", "Lago"), "Kanto"),

                new Pokemon("Jolteon", "Eléctrico",
                        List.of("Tierra"),
                        List.of("Bosque", "Hierba Alta"), "Kanto")
        );
    }
}
