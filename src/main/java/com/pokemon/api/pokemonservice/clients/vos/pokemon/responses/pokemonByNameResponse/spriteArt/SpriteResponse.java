package com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.spriteArt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public record SpriteResponse(OtherResponseDto other) {
}
