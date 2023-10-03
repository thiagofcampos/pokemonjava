package com.pokemon.api.pokemonservice.builders;

import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.PokemonResponseDto;

public class PokemonResponseBuilder {
    private String name;

    public PokemonResponseBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PokemonResponseDto build() {
        return new PokemonResponseDto(name);
    }
}
