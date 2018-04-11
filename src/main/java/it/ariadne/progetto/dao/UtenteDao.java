package it.ariadne.progetto.dao;


import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import it.ariadne.progetto.model.Utente;

@Service
@Transactional
public interface UtenteDao <T extends Utente> extends CrudRepository<Utente,Integer>{
	
	public Utente findByUsername(String username);
	
}
