package it.ariadne.progetto.model.risorse;

import javax.persistence.Entity;

import it.ariadne.progetto.model.Risorsa;

@Entity(name = "Laptop")
public class Laptop extends Risorsa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Laptop() {
		// TODO Auto-generated constructor stub
	}
	public Laptop(int ram) {
		// TODO Auto-generated constructor stub
		super(ram);
	}

}
