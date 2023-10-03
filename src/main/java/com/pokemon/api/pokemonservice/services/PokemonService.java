package com.pokemon.api.pokemonservice.services;

import com.pokemon.api.pokemonservice.clients.PokemonClient;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.PokemonByNameResponseDto;
import com.pokemon.api.pokemonservice.controllers.dtos.PokemonDto;
import com.pokemon.api.pokemonservice.mappers.PokemonMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    private final PokemonClient pokemonClient;

    private final PokemonMapper pokemonMapper;

    public PokemonService(PokemonClient pokemonClient, PokemonMapper pokemonMapper) {
        this.pokemonClient = pokemonClient;
        this.pokemonMapper = pokemonMapper;
    }

    public List<PokemonDto> getPokemon(Integer limit, Integer offset) {
        final var pokemonList = pokemonClient.getAllPokemon(limit, offset);

        List<PokemonByNameResponseDto> response = pokemonList.results().stream()
                .map(item -> pokemonClient.getPokemonByName(item.name()))
                .collect(Collectors.toList());

        return pokemonMapper.pokemonByNameResponseToPokemonDto(response);
    }
}
