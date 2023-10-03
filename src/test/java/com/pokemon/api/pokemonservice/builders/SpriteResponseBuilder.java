package com.pokemon.api.pokemonservice.builders;

import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.PokemonByNameResponseDto;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.spriteArt.OtherResponseDto;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.spriteArt.SpriteResponse;

public class SpriteResponseBuilder {
    private OtherResponseDto other;

    public SpriteResponseBuilder withOther(OtherResponseDto other) {
        this.other = other;
        return this;
    }

    public SpriteResponse build() {
        return new SpriteResponse(other);
    }
}
