package com.diegotuesta.pokeapi.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonType {
    private List<PokemonElement> pokemon;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class PokemonElement {
    private Result pokemon;
}