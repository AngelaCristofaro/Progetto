package it.ariadne.progetto.dao;

import java.util.TreeMap;

import it.ariadne.progetto.model.Prenotazioni;

public class PrenotazioniDao <T extends Prenotazioni> implements InterfacciaDao <T>{
	public static TreeMap<Integer, Prenotazioni> treeMapPrenotazione = new TreeMap<>();
		@Override
		public void insert(T p) {
			treeMapPrenotazione.put(p.getIdPrenotazione(), p);	
		}

		@Override
		public void delete(T p) {
			treeMapPrenotazione.remove(p.getIdPrenotazione(), p);		
		}

		@Override
		public void update(T p) {
			treeMapPrenotazione.put(p.getIdPrenotazione(), p);	
		}
		
		public static TreeMap<Integer,Prenotazioni> getListaPrenotazioni() {
			return treeMapPrenotazione;
		}
		}
			
		