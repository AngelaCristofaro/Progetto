package it.ariadne.progetto.dao;

import org.springframework.data.repository.CrudRepository;

import it.ariadne.progetto.model.Utente;


public interface Indao<T>extends CrudRepository<Utente,Integer> {

	public Utente findByUsername(String username);

}
