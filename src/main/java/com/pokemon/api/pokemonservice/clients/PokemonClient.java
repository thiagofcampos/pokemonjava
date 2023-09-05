package com.pokemon.api.pokemonservice.clients;

import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.PokemonListResponseDto;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.PokemonResponseDto;
import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.PokemonByNameResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "https://pokeapi.co/api/v2", name="pokemon-client")
public interface PokemonClient {

    @GetMapping(path = "/pokemon", produces = MediaType.APPLICATION_JSON_VALUE)
    PokemonListResponseDto getAllPokemon(
            @RequestParam(value="limit", required = false) final Integer limit,
            @RequestParam(value="offset", required = false) final Integer offset
    );

    @GetMapping(path = "/pokemon/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    PokemonByNameResponseDto getPokemonByName(
            @PathVariable(value="name") final String name
    );
}