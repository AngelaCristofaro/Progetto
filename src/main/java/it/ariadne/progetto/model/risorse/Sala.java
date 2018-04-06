package it.ariadne.progetto.model.risorse;

import javax.persistence.Entity;

import it.ariadne.progetto.model.Risorsa;

@Entity(name = "Sala")
public class Sala extends Risorsa {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Sala() {
	// TODO Auto-generated constructor stub
}
		public Sala(int posti) {
			// TODO Auto-generated constructor stub
			super(posti);
		}


}
