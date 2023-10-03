package com.pokemon.api.pokemonservice.services;

import com.pokemon.api.pokemonservice.builders.*;
import com.pokemon.api.pokemonservice.clients.PokemonClient;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.PokemonListResponseDto;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.PokemonResponseDto;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.PokemonByNameResponseDto;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.spriteArt.OficialArtWorkResponse;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.spriteArt.OtherResponseDto;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.spriteArt.SpriteResponse;
import com.pokemon.api.pokemonservice.controllers.dtos.PokemonDto;
import com.pokemon.api.pokemonservice.mappers.PokemonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {
    @InjectMocks private PokemonService pokemonService;
    @Mock private PokemonMapper pokemonMapper;

    @Mock private PokemonClient pokemonClient;

    @BeforeEach
    void setUp() {
        pokemonService = new PokemonService(pokemonClient, pokemonMapper);
    }
    private PokemonResponseDto getPokemonResponse() {
        return new PokemonResponseBuilder()
                .withName("Bulbasaur")
                .build();
    }

    private PokemonListResponseDto getPokemonList() {
        return new PokemonListResponseBuilder()
                .withCount(1)
                .withResults(List.of(getPokemonResponse()))
                .build();
    }
    private OficialArtWorkResponse getOficialArtWork() {
        return new OficialArtWorkResponseBuilder()
                .withFrontDefault("default")
                .build();
    }
    private OtherResponseDto getOther() {
        return new OtherResponseBuilder()
                .withOfficialArtWork(getOficialArtWork())
                .build();
    }
    private SpriteResponse getStripte() {
        return new SpriteResponseBuilder()
                .withOther(getOther())
                .build();
    }

    private PokemonByNameResponseDto getPokemonsByName(){
        return new PokemonByNameResponseBuilder()
                .withName("Bulbasaur")
                .withSprites(getStripte())
                .withTypes(Collections.emptyList())
                .build();
    }

    @Test
    void testPokemonServiceCallWithSuccess() {
        List<String> types = new ArrayList<>();
        types.add("Water");
        types.add("Fire");

        PokemonDto mockPokemonDto = new PokemonDto("Squirtle", "squirtle.png", types);

        final PokemonListResponseDto mockedPokemonList = getPokemonList();

        when(pokemonMapper.pokemonByNameResponseToPokemonDto(any())).thenReturn(List.of(mockPokemonDto));
        when(pokemonClient.getAllPokemon(any(), any())).thenReturn(mockedPokemonList);

        PokemonByNameResponseDto mockPokemonResponse = getPokemonsByName();
        when(pokemonClient.getPokemonByName(anyString())).thenReturn(mockPokemonResponse);

        List<PokemonDto> result = pokemonService.getPokemon(10, 0);

        verify(pokemonClient).getAllPokemon(10, 0);
        verify(pokemonClient, times(1)).getPokemonByName(anyString());

        assertEquals(1, result.size());
    }
}
