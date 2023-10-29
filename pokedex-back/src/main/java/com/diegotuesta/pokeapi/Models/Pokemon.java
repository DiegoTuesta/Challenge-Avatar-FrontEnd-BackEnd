package com.diegotuesta.pokeapi.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    private List<AbilityElement> abilities;
    private long height;
    private long id;
    private List<Move> moves;
    private String name;
    private Sprites sprites;
    private List<Type> types;
    private Result species;
    private long weight;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Sprites {
    private Other other;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class AbilityElement {
    private MoveClass ability;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class MoveClass {
    private String name;
    private String url;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Move {
    private MoveClass move;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Type {
    private MoveClass type;
}
@Data
class Other {
    private DreamWorld dream_world;
}
@Data
class DreamWorld {
    private String front_default;
}