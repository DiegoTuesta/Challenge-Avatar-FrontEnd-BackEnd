package com.diegotuesta.pokeapi.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonUrl {
    private long count;
    private String next;
    private Object previous;
    private List<Result> results;
}
