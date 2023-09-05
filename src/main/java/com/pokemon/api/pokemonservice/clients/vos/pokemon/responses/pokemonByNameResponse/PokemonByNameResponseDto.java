package com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse;

import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.spriteArt.SpriteResponse;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.types.PokemonTypesResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public record PokemonByNameResponseDto(String name, SpriteResponse sprites, List<PokemonTypesResponse> types) {
}

