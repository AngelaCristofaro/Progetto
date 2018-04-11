package it.ariadne.progetto.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import it.ariadne.progetto.model.Risorsa;


@Service
@Transactional
public interface RisorsaDao <T extends Risorsa> extends CrudRepository<Risorsa,Integer> {

	
}

