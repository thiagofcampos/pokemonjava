package com.pokemon.api.pokemonservice.controllers;

import com.pokemon.api.pokemonservice.clients.vos.pokemon.responses.pokemonByNameResponse.PokemonByNameResponseDto;
import com.pokemon.api.pokemonservice.controllers.dtos.PokemonDto;
import com.pokemon.api.pokemonservice.services.PokemonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="v1/pokemon", produces = MediaType.APPLICATION_JSON_VALUE)
public class PokemonController {
    final Integer LIMIT = 151;
    final Integer OFFSET = 0;
    final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<PokemonDto> listPokemon(){
        return  pokemonService.getPokemon(LIMIT, OFFSET);
    }
}
