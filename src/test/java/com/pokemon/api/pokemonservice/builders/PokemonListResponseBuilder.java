package com.pokemon.api.pokemonservice.builders;

import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.PokemonListResponseDto;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.PokemonResponseDto;

import java.util.List;

public class PokemonListResponseBuilder {
    private Integer count;
    private List<PokemonResponseDto> results;

    public PokemonListResponseBuilder withCount(Integer count) {
        this.count = count;
        return this;
    }

    public PokemonListResponseBuilder withResults(List<PokemonResponseDto> results) {
        this.results = results;
        return this;
    }

    public PokemonListResponseDto build() {
        return new PokemonListResponseDto(count, results);
    }
}
