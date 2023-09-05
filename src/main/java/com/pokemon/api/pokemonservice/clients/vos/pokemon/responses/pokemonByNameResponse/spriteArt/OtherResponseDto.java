package com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.spriteArt;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public record OtherResponseDto(@JsonAlias("official-artwork") OficialArtWorkResponse officialArtWork) {
}
