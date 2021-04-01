package com.dev.api.controller;

import java.util.ArrayList;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dev.api.model.PokemonDTO;
import com.dev.api.model.PokemonEntity;
import com.dev.api.service.PokemonServiceImpl;

/**
 * Principal controlado de servicios REST, los principales métodos que interactúan con los clientes en cada llamada 
 * @author LINESOFT
 *
 */
@RestController
public class PokemonController {

	/**
	 * Auto Inyección de dependencia de PokemonServiceImpl 
	 */
	@Autowired
	PokemonServiceImpl pokemonService;

	/**
	 * Servicio obtiene Pokémones por generación, consumiendo PokeApi (https://pokeapi.co/)
	 * @param generacion válida que puede ser del 1 al 6
	 * @return Lista de Pokémones que pertenecen a una generación
	 */
	@GetMapping("/generaciones/{generacion}")
	public ResponseEntity<ArrayList<PokemonDTO>> getGeneraciones(@PathVariable("generacion") int generacion) {
		ArrayList<PokemonDTO> lst = pokemonService.getPokemonesGenaracion(generacion);
		return new ResponseEntity<ArrayList<PokemonDTO>>(lst, HttpStatus.OK);
	}
	
	/**
	 * Obtiene una lista de Pokémones con un rango que va del Pokémon número a al b, consumiendo PokeApi (https://pokeapi.co/)  
	 * @param a Índice desde donde empezar
	 * @param b Índice de dónde terminar
	 * @return ArrayList<PokemonDTO> de Pokémones que se encuentran en el rango especificado
	 */
	@GetMapping("/listaPokemones/{a}/{b}")
	public ResponseEntity<ArrayList<PokemonDTO>> getListaPokemones(@PathVariable("a") int a, @PathVariable("b") int b) {
		ArrayList<PokemonDTO> lst = pokemonService.getRangoPokemones(a, b);
		return new ResponseEntity<ArrayList<PokemonDTO>>(lst, HttpStatus.OK);
	}
	
	/**
	 * Obtiene el nombre, número y tipos de un Pokemon buscándolo por su nombre o número, consumiendo PokeApi (https://pokeapi.co/)
	 * @param identificador que puede ser nombre o número
	 * @return PokemonDTO Pokémon que coincide con el nombre o número
	 */
	@GetMapping("/buscarPokemon/{identificador}")
	public ResponseEntity<PokemonDTO> getPokemon(@PathVariable("identificador") String identificador) {
		PokemonDTO pkmn = pokemonService.getPokemon(identificador);
		return new ResponseEntity<PokemonDTO>(pkmn, HttpStatus.OK);
	}

	/**
	 * Almacena un Pokémon en la base de datos H2, guardando un apodo para él, debe ser único, su especie, su ataque, su defensa y su salud (Estos tres últimos la aplicación genera los valores al azar en un rango de 0 a 15 con números enteros).
	 * @param pokemon PokemonEntity válido
	 * @return HttpStatus.CREATED si el Pokémon se guardo correctamente, de lo contrario HttpStatus.ACCEPTED
	 */
	@PutMapping("/guardarPokemon")
	public ResponseEntity<String> getPokemon(@Valid @RequestBody PokemonEntity pokemon)  {
		try {
			PokemonEntity pkmn = pokemonService.guardarPokemon(pokemon);
		    return new ResponseEntity<>("¡Pokemon guardado! "+pkmn.toString(), HttpStatus.CREATED);
		} catch (DataIntegrityViolationException ex) {
			return new ResponseEntity<>("No guardado (Ya existe un pokemon con el apodo: "+pokemon.getApodo()+")", HttpStatus.ACCEPTED);
		}
	}
	
	/**
	 * Consulta desde la base de datos (H2) un Pokémon capturado por su apodo, devuelve el apodo, la especie, ataque, defensa, salud y número.
	 * @param apodo del Pokémon
	 * @return PokemonEntity que coincide con el apodo 
	 */

	@GetMapping("/obtenerPokemon/{apodo}")
	public ResponseEntity<PokemonEntity> obtenerPokemon(@PathVariable("apodo") String apodo)  {
		PokemonEntity pkmn = pokemonService.consultarPokemon(apodo);
		return new ResponseEntity<PokemonEntity>(pkmn, HttpStatus.OK);
	}
	
	/**
	 * Consulta desde la base de datos (H2) todos los Pokémon capturados de una misma especie.
	 * @param especie de Pokémon
	 * @return ArrayList<PokemonEntity> de Pokémones de la misma especie 
	 */
	@GetMapping("/consultarPokemonesPorEspecie/{especie}")
	public ResponseEntity<ArrayList<PokemonEntity>> consultarPokemonesPorEspecie(@PathVariable("especie") String especie)  {
		ArrayList<PokemonEntity> lst = pokemonService.consultarPokemonesPorEspecie(especie);
		return new ResponseEntity<ArrayList<PokemonEntity>>(lst, HttpStatus.OK);
	}
}
