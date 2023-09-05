package com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public record PokemonTypesResponse(TypeResponse type) {
}