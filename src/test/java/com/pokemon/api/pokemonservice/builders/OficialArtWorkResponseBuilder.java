package com.pokemon.api.pokemonservice.builders;

import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.spriteArt.OficialArtWorkResponse;

public class OficialArtWorkResponseBuilder {
    private String front_default;
    public OficialArtWorkResponseBuilder withFrontDefault(String front_default) {
        this.front_default = front_default;
        return this;
    }

    public OficialArtWorkResponse build() {
        return new OficialArtWorkResponse(front_default);
    }
}
