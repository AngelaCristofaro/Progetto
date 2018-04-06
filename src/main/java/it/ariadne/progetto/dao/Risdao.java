package it.ariadne.progetto.dao;

import org.springframework.data.repository.CrudRepository;

import it.ariadne.progetto.model.Risorsa;


public interface Risdao<T>extends CrudRepository<Risorsa,Integer> {
	
}
