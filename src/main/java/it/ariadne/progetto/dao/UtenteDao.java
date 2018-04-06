package it.ariadne.progetto.dao;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ariadne.progetto.dao.Indao;
import it.ariadne.progetto.model.Utente;

@Service
@Transactional
public class UtenteDao <T extends Utente>{
	
	@Autowired
	private final Indao<?> ind; 
	
	//public static TreeMap<String, Utente> treeMapUtente = new TreeMap<>();
	public UtenteDao(Indao<T> ind) {
		super();
		this.ind = ind;
	}
	
	public List<Utente> findAll(){
		List <Utente> utente= new ArrayList<>();
		for (Utente u : ind.findAll()) {
			utente.add(u);
		}
		return utente;
	}

	public void insert(T u) {
	   ind.save(u);
	}

	public void delete(int id) {
		 ind.delete(id);		
	}

	public Utente findByUsername(String username) {
		return ind.findByUsername(username);

	}

}