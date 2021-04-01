package com.dev.api.model;

import java.util.ArrayList;

/**
 * DTO para parsear los atributos de los Pokémones que vienen de https://pokeapi.co/api/v2/pokemon/{id} a Objeto Pokémon
 * Tomando en cuenta que solo extraemos los atributos de nuestro interés (todos los atributos de esta clase) 
 * @author LINESOFT
 *
 */
public class PokemonDTO {
	
    private int id;
    private String name;
    private ArrayList<TypesDTO> types;   
    
	public PokemonDTO(int id, String name, ArrayList<TypesDTO> types) {
		super();
		this.id = id;
		this.name = name;
		this.types = types;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<TypesDTO> getTypes() {
		return types;
	}
	public void setTypes(ArrayList<TypesDTO> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", types=" + types + "]";
	}
    
}
