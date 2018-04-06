package it.ariadne.progetto.dao;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ariadne.progetto.model.Risorsa;


@Service
@Transactional
public class RisorsaDao <T extends Risorsa> {
	
	@Autowired
	private final Risdao<?> ind; 
	
	
	public RisorsaDao(Risdao<T> ind) {
		super();
		this.ind = ind;
	}
	
	public List<Risorsa> findAll(){
		List <Risorsa> risorsa= new ArrayList<>();
		for (Risorsa r : ind.findAll()) {
			risorsa.add(r);
		}
		return risorsa;
	}

	public void insertR(T u) {
	   ind.save(u);
	}

	public void deleteR(int id) {
		 ind.delete(id);		
	}
	
	public Risorsa findRisorsa(int id) {
		return ind.findOne(id);

	}
}

