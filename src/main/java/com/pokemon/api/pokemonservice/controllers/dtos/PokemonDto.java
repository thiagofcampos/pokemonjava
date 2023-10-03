package com.pokemon.api.pokemonservice.controllers.dtos;

import java.util.List;
public class PokemonDto {
    private String name;
    private String sprite;
    private List<String> types;

    public PokemonDto(String name, String sprite, List<String> types) {
        this.name = name;
        this.sprite = sprite;
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
