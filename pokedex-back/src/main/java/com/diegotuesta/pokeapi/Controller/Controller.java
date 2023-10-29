package com.diegotuesta.pokeapi.Controller;

import com.diegotuesta.pokeapi.Models.Color;
import com.diegotuesta.pokeapi.Models.Pokemon;
import com.diegotuesta.pokeapi.Models.PokemonType;
import com.diegotuesta.pokeapi.Models.PokemonUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/pokeapi/v3")
@CrossOrigin("*")
public class Controller {
    private final RestTemplate restTemplate;
    private  String url;

    @Autowired
    public Controller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        url = "https://pokeapi.co/api/v2";
    }

    @GetMapping("/pokemon")
    public PokemonUrl getApi(){
        PokemonUrl pokemonUrl =  restTemplate.getForObject(url+"/pokemon?offset=0&limit=1500", PokemonUrl.class);
        return pokemonUrl;
    }
    @GetMapping("/pokemon/{valor}")
    public ResponseEntity<?> getPokemonSearch(@PathVariable String valor){
        try {
            Pokemon pokemon = restTemplate.getForObject(url + "/pokemon/" + valor, Pokemon.class);
            return ResponseEntity.ok(pokemon);
        } catch (HttpClientErrorException.NotFound e) {
            // Manejar el error de recurso no encontrado (404)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokémon no encontrado");
        } catch (Exception e) {
            // Manejar otros errores
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }

    }
    @GetMapping("/type")
    public PokemonUrl getTypesPokemons(){
        PokemonUrl pokemonUrl =  restTemplate.getForObject(url+"/type", PokemonUrl.class);
        return pokemonUrl;
    }
    @GetMapping("/type/{id}")
    public PokemonType getPokemonType(@PathVariable String id){
        PokemonType pokemonType = restTemplate.getForObject(url+"/type/"+id, PokemonType.class);
        return pokemonType;
    }
    @GetMapping("/specie/{id}")
    public Color getColorPokemon(@PathVariable String id){
        Color color =  restTemplate.getForObject(url+"/pokemon-species/"+id, Color.class);
        return color;
    }


}
