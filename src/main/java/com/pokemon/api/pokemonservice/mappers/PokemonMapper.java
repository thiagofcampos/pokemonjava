package com.pokemon.api.pokemonservice.mappers;

import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.PokemonResponseDto;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.PokemonByNameResponseDto;
import com.pokemon.api.pokemonservice.controllers.dtos.PokemonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@Component
public interface PokemonMapper {

    PokemonMapper INSTANCE = Mappers.getMapper(PokemonMapper.class);

    default List<PokemonDto> pokemonByNameResponseToPokemonDto(final List<PokemonByNameResponseDto> pokemons) {

        return pokemons.stream().map(pokemon -> {

            List<String> typeToNames = pokemon.types().stream()
                    .map(typeResponse -> typeResponse.type().name())
                    .collect(Collectors.toList());

            final PokemonDto pokemonDto = new PokemonDto(
                    pokemon.name(),
                    pokemon.sprites().other().officialArtWork().front_default(),
                    typeToNames
            );

            return pokemonDto;
        }).collect(Collectors.toList());
    }
}
