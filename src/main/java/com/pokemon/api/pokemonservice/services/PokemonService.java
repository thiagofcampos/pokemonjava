package com.pokemon.api.pokemonservice.services;

import com.pokemon.api.pokemonservice.clients.PokemonClient;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.PokemonByNameResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    private final PokemonClient pokemonClient;

    public PokemonService(PokemonClient pokemonClient) {
        this.pokemonClient = pokemonClient;
    }

    public List<PokemonByNameResponseDto> getPokemon(Integer limit, Integer offset) {
        final var pokemonList = pokemonClient.getAllPokemon(limit, offset);

        List<PokemonByNameResponseDto> response = pokemonList.results().stream()
                .map(item -> pokemonClient.getPokemonByName(item.name()))
                .collect(Collectors.toList());

        return response;
    }
}
