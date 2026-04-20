package com.example.labo1ncapas.runner;

import com.example.labo1ncapas.model.Pokemon;
import com.example.labo1ncapas.service.PokemonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokedexRunner implements CommandLineRunner {

    private final PokemonService pokemonService;

    public PokedexRunner(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Override
    public void run(String... args) {

        System.out.println("\n===== FILTRO POR TIPO: Fuego =====");
        imprimirLista(pokemonService.filtrarPorTipo("Fuego"));

        System.out.println("\n===== FILTRO POR ZONA: Bosque =====");
        imprimirLista(pokemonService.filtrarPorZona("Bosque"));

        System.out.println("\n===== FILTRO POR DEBILIDAD: Agua =====");
        imprimirLista(pokemonService.filtrarPorDebilidad("Agua"));
    }

    private void imprimirLista(List< Pokemon> lista) {
        lista.forEach(p ->
                System.out.printf("[PKMN] Nombre: %s | Tipo: %s | Debilidades: %s%n",
                        p.getNombre(),
                        p.getTipo(),
                        String.join(", ", p.getDebilidades()))
        );
    }
}
