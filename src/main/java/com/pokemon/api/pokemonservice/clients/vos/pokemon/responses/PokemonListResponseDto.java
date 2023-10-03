package com.pokemon.api.pokemonservice.clients.vos.pokemon.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public record PokemonListResponseDto (
        Integer count,
        List<PokemonResponseDto> results
){
}
