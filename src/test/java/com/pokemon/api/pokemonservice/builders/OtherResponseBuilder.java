package com.pokemon.api.pokemonservice.builders;

import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.spriteArt.OficialArtWorkResponse;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.spriteArt.OtherResponseDto;

public class OtherResponseBuilder {
        private OficialArtWorkResponse officialArtWork;

        public OtherResponseBuilder withOfficialArtWork(OficialArtWorkResponse officialArtWork) {
            this.officialArtWork = officialArtWork;
            return this;
        }

        public OtherResponseDto build() {
            return new OtherResponseDto(officialArtWork);
        }
}
