package com.dev.api.service;

import java.util.ArrayList;
import com.dev.api.model.PokemonDTO;
import com.dev.api.model.PokemonEntity;

/**
 * Métodos abstractos para aplicar la lógica de negocio a el Pokémon API
 * @author LINESOFT
 *
 */
public interface PokemonService {
	ArrayList<PokemonDTO> getPokemonesGenaracion(int generacion);
	ArrayList<PokemonDTO> getRangoPokemones(int a, int b);
	PokemonDTO getPokemon(String identificador);
	PokemonEntity guardarPokemon(PokemonEntity pokemon);
	PokemonEntity consultarPokemon(String apodo);
	ArrayList<PokemonEntity> consultarPokemonesPorEspecie(String especie);
}
