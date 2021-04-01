package com.dev.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * Objeto que usamos para mapear una tabla en base de datos h2 que almacenara Pokémones
 * @author LINESOFT
 *
 */
@Entity(name="Pokemon")
public class PokemonEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	@NotBlank(message = "apodo: es obligatorio") 
	@Column(unique=true)
	private String apodo;
	
	@NotBlank(message = "especie: es obligatorio")
	private String especie;
	
	private byte ataque;
	
	private byte defensa;
	
	private byte salud;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public byte getAtaque() {
		return ataque;
	}

	public void setAtaque(byte ataque) {
		this.ataque = ataque;
	}

	public byte getDefensa() {
		return defensa;
	}

	public void setDefensa(byte defensa) {
		this.defensa = defensa;
	}

	public byte getSalud() {
		return salud;
	}

	public void setSalud(byte salud) {
		this.salud = salud;
	}

	@Override
	public String toString() {
		return "PokemonEntity [id=" + id + ", apodo=" + apodo + ", especie=" + especie + ", ataque=" + ataque
				+ ", defensa=" + defensa + ", salud=" + salud + "]";
	}
	
}
