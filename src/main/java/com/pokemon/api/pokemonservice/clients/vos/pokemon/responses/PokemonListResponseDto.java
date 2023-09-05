package com.pokemon.api.pokemonservice.clients.vos.pokemon.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public record PokemonListResponseDto (
        int count,
        String next,
        String previous,
        List<PokemonResponseDto> results
){
}
