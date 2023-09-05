package com.pokemon.api.pokemonservice.clients.vos.pokemon.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public record PokemonResponseDto(String name) {
}

