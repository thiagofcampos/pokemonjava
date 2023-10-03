package com.pokemon.api.pokemonservice.builders;

import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.PokemonByNameResponseDto;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.spriteArt.SpriteResponse;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.types.PokemonTypesResponse;

import java.util.List;

public class PokemonByNameResponseBuilder {
    private String name;
    private SpriteResponse sprites;
    List<PokemonTypesResponse> types;

    public PokemonByNameResponseBuilder withName(final String name) {
        this.name = name;
        return this;
    }

    public PokemonByNameResponseBuilder withSprites(final SpriteResponse sprites) {
        this.sprites = sprites;
        return this;
    }

    public PokemonByNameResponseBuilder withTypes(final List<PokemonTypesResponse> types) {
        this.types = types;
        return this;
    }

    public PokemonByNameResponseDto build() {
        return new PokemonByNameResponseDto(
                name,
                sprites,
                types
        );
    }
}
