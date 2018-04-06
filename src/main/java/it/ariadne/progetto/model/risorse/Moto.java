package it.ariadne.progetto.model.risorse;

import javax.persistence.Entity;

import it.ariadne.progetto.model.Risorsa;

@Entity(name = "Moto")
public class Moto extends Risorsa {
	
	private static final long serialVersionUID = 1L;

	public Moto() {
		// TODO Auto-generated constructor stub
	}
	public Moto(int cilindrata) {
		// TODO Auto-generated constructor stub
		super(cilindrata);
	}


}
