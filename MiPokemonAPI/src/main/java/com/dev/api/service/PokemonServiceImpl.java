package com.dev.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import com.dev.api.controller.PokemonController;
import com.dev.api.model.PokemonDTO;
import com.dev.api.model.PokemonEntity;
import com.dev.api.repository.PokemonEntityRepo;

/**
 * Clase en la que escribimos toda la lógica de negocio
 * @author LINESOFT
 *
 */
@Service
public class PokemonServiceImpl implements PokemonService {

	/**
	 * Auto Inyección de dependencia 
	 */
	@Autowired RestTemplate restTemplate;
	@Autowired HttpHeaders headers;
	@Autowired PokemonEntityRepo pokemonRepo;
	
	//Url de pokeapi 
	public static final String URL_API_GET_POKEMON = "https://pokeapi.co/api/v2/pokemon/";
	//logger para imprimir errores o comentarios
	private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);

	/**
	 * Implementando lógica de negocio
	 * Servicio obtiene Pokémones por generación, consumiendo PokeApi (https://pokeapi.co/)
	 */
	@Override
	public ArrayList<PokemonDTO> getPokemonesGenaracion(int generacion) {
		ArrayList<PokemonDTO> generaciones = null;
		switch (generacion) {
		case 1:
			generaciones = getRangoPokemones(1, 151);
			break;
		case 2:
			generaciones = getRangoPokemones(152, 251);
			break;
		case 3:
			generaciones = getRangoPokemones(252, 386);
			break;
		case 4:
			generaciones = getRangoPokemones(387, 493);
			break;
		case 5:
			generaciones = getRangoPokemones(494, 649);
			break;
		case 6:
			generaciones = getRangoPokemones(650, 721);
			break;
		}
		return generaciones;
	}
	
	/**
	 * Implementando lógica de negocio
	 * Obtiene una lista de Pokémones con un rango que va del Pokémon número a al b, consumiendo PokeApi (https://pokeapi.co/)
	 */
	@Override
	public ArrayList<PokemonDTO> getRangoPokemones(int a, int b) {
		ArrayList<PokemonDTO> pokemones = null;
		if (!(a == b) || !(a > b)) {
			pokemones = new ArrayList<PokemonDTO>();
			for (int i = a; i <= b; i++) {
				PokemonDTO pokemon = getPokemon(i+"");
				if(pokemon != null) {
					pokemones.add(pokemon);
				}
			}
		}

		return pokemones;
	}

	/**
	 * Implementando lógica de negocio
	 * Obtiene el nombre, número y tipos de un Pokemon buscándolo por su nombre o número, consumiendo PokeApi (https://pokeapi.co/)
	 */
	@Override
	public PokemonDTO getPokemon(String identificador) {
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add(HttpHeaders.USER_AGENT, "Mozilla/5.0 Firefox/26.0");
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		try {
			ResponseEntity<PokemonDTO> response = restTemplate.exchange(URL_API_GET_POKEMON + identificador, HttpMethod.GET,
					entity, PokemonDTO.class);
			logger.info("Petición exitosa: " + URL_API_GET_POKEMON + identificador);
			return response.getBody();
		} catch (HttpStatusCodeException e) {
			logger.error("Petición fallida: " + URL_API_GET_POKEMON + identificador + ", Causa: " + e.toString());
			return null;
		}
	}

	/**
	 * Implementando lógica de negocio
	 * Almacena un Pokémon en la base de datos H2, guardando un apodo para él, debe ser único, su especie, su ataque, su defensa y su salud (Estos tres últimos la aplicación genera los valores al azar en un rango de 0 a 15 con números enteros).
	 */
	@Override
	public PokemonEntity guardarPokemon(PokemonEntity pokemon) {
		pokemon.setAtaque((byte) ThreadLocalRandom.current().nextInt(0, 15));
		pokemon.setDefensa((byte) ThreadLocalRandom.current().nextInt(0, 15));
		pokemon.setSalud((byte) ThreadLocalRandom.current().nextInt(0, 15));
				 
		return pokemonRepo.save(pokemon);
	}

	/**
	 * Implementando lógica de negocio
	 * Consulta desde la base de datos (H2) un Pokémon capturado por su apodo, devuelve el apodo, la especie, ataque, defensa, salud y número.
	 */
	@Override
	public PokemonEntity consultarPokemon(String apodo) {
		//Escribir lógica de negocio aqui
		return pokemonRepo.findByApodo(apodo);
	}

	/**
	 * Implementando lógica de negocio
	 * Consulta desde la base de datos (H2) todos los Pokémon capturados de una misma especie.
	 */
	@Override
	public ArrayList<PokemonEntity> consultarPokemonesPorEspecie(String especie) {
		//Escribir lógica de negocio aqui
		return pokemonRepo.findByEspecie(especie);
	}
	
}
