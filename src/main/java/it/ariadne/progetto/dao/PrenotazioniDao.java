package it.ariadne.progetto.dao;

import org.springframework.data.repository.CrudRepository;

import it.ariadne.progetto.model.Prenotazioni;

public interface PrenotazioniDao <T extends Prenotazioni> extends CrudRepository<Prenotazioni,Integer>{
}
			
		