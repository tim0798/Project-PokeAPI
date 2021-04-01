package com.dev.api.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dev.api.model.PokemonEntity;

/**
 * Repositorio para la persistencia de datos con Spring Data JPA
 * @author LINESOFT
 *
 */
@Repository
public interface PokemonEntityRepo  extends PagingAndSortingRepository<PokemonEntity, Long>,JpaSpecificationExecutor<PokemonEntity>{
	PokemonEntity findByApodo(String apodo);
	ArrayList<PokemonEntity> findByEspecie(String especie);
}
