package it.ariadne.progetto.controllo;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import it.ariadne.progetto.dao.PrenotazioniDao;
import it.ariadne.progetto.model.Prenotazioni;
import it.ariadne.progetto.model.Risorsa;
import it.ariadne.progetto.model.Utente;


public class GestionePrenotazione {
	 static PrenotazioniDao<Prenotazioni> p = new PrenotazioniDao<Prenotazioni>();
		public int insertPre(Utente utente,Risorsa r, LocalDateTime  dataInizio,LocalDateTime  dataFine) {
			if (controllaPrenotazione(utente,r) 
					&& controlloDate(dataInizio,dataFine)
					&& risorsaDisponibile(r) 
					&&risorsaDisponibileData(r,dataInizio,dataFine)) {
				Prenotazioni prenotazioni = new Prenotazioni (utente, r, dataInizio, dataFine);
				prenotazioni.setDataFine(dataFine);
				p.insert(prenotazioni);
				return 1;
			}
			else {
				System.out.println("La Prenotazione esiste già o ci sono errori con le date o la risorsa non è disponibile");
			}	return -1;
		}
		
		public void deletePre(Prenotazioni prenotazioni) {
			if (controllaPrenotazione(prenotazioni.getUtente(), prenotazioni.getRis())) {
				p.delete(prenotazioni);}
		}
		
		public void updatePre(Prenotazioni prenotazioni) {
			if (controllaPrenotazione(prenotazioni.getUtente(), prenotazioni.getRis())) {
				p.update(prenotazioni);}
			else {
				System.out.println("La prenotazione non esiste");
			}
		}
		
		public static <T> List<Prenotazioni> ElencoMiePrenotazioni (Utente utente) {
			List<Prenotazioni> miePrenotazioni = new ArrayList<>();
			int count = 0 ;
			for(Prenotazioni pre : PrenotazioniDao.getListaPrenotazioni().values()) {
				if(utente.getUsername().equals(pre.getUtente().getUsername())) {
					miePrenotazioni.add(pre);
					count= count +1;
				}
			}
			if(count > 0) {
				System.out.printf("Le prenotazioni di " + utente.getUsername() + " sono:" + miePrenotazioni);
			}
			else {
				System.out.println("Non ci sono prenotazioni");
			}
			return miePrenotazioni;
		}
		
		public static <T> List<Prenotazioni> ElencoMiePrenotazioniOra (Utente utente) {
			List<Prenotazioni> miePrenotazioniOra = new ArrayList<>();
			int count = 0 ;
			for(Prenotazioni pre : PrenotazioniDao.getListaPrenotazioni().values()) {
				if(utente.getUsername().equals(pre.getUtente().getUsername()) && pre.getDataFine().isAfter(LocalDateTime.now())) {
					miePrenotazioniOra.add(pre);
					count= count +1;
				}
			}
			if(count > 0) {
				System.out.printf("Le prenotazioni di " + utente.getUsername() + " sono:" + miePrenotazioniOra);
			}
			else {
				System.out.print("Non ci sono prenotazioni");
			}
			return miePrenotazioniOra;
		}
		
		public static <T> List<Prenotazioni> StampaPrenotazioni() {
			List<Prenotazioni> StampaPrenotazioni = new ArrayList<>();
			for(Prenotazioni pre : PrenotazioniDao.getListaPrenotazioni().values()) {
				StampaPrenotazioni.add(pre);
			}
			return StampaPrenotazioni;
		}
		
		public static <T> List<Prenotazioni> StampaPrenotazioniPerData(LocalDateTime dataInizio) {
			List<Prenotazioni> StampaPrenotazioniData = new ArrayList<>();
			for(Prenotazioni pre : PrenotazioniDao.getListaPrenotazioni().values()) {
				if(pre.getDataInizio().isAfter(dataInizio) || pre.getDataInizio().isEqual(dataInizio)) {
				StampaPrenotazioniData.add(pre);
				}
			}
			return StampaPrenotazioniData;
		}
		
		public boolean controllaPrenotazione(Utente utente, Risorsa ris) {
			for (Prenotazioni pre : PrenotazioniDao.getListaPrenotazioni().values()) {
				if(pre.getUtente().getUsername()== utente.getUsername() && (pre.getR() == ris.getId())) 
				{return false;} 
			}
			return true;    
		}
		
		public boolean controlloDate(LocalDateTime dataInizio, LocalDateTime dataFine) {
			if((dataInizio.isBefore(dataFine) || dataInizio.isEqual(dataFine))) {
			return true;
			}
			System.out.println("Attenzione alle date!");
			return false;
			
		}
		
		public boolean controlloRitardo(Prenotazioni pre, LocalDateTime dataConsegna) {
			if (pre.getDataFine().isBefore(dataConsegna) == true) {
				return true;
			} else {
				List<Utente> ritardatari = new ArrayList<Utente>();
					ritardatari.add(pre.getUtente());
				System.out.println("Messaggio sollecito al cliente : " + pre.getUtente().getUsername());
				System.out.println("Sei in ritardo di : " + ChronoUnit.DAYS.between(dataConsegna, pre.getDataFine()) +" giorni");
				return false; 
			}
		}
		
		public void consegna(Prenotazioni pre, LocalDateTime dataConsegna) {
			pre.setDataConsegna(dataConsegna);
		}
		
		public boolean risorsaDisponibile(Risorsa r) {
			for (Prenotazioni prenotazione : PrenotazioniDao.getListaPrenotazioni().values()) {
				if(prenotazione.getDataFine().isBefore(LocalDateTime.now())
					|| (r.getId() != prenotazione.getR())) 
						{
					return true;}
				else {
					System.out.println("Non disponibile");
				}
			}
			if(PrenotazioniDao.getListaPrenotazioni().values().isEmpty()) {
				return true;
			}
			return false;	
		}
		
		
		public static boolean risorsaDisponibileData(Risorsa r,LocalDateTime inizio, LocalDateTime fine) {
			for (Prenotazioni prenotazione : PrenotazioniDao.getListaPrenotazioni().values()) {
				if((r.getId() == prenotazione.getR() 
					&& fine.compareTo(prenotazione.getDataInizio()) <=0 
					&& inizio.compareTo(prenotazione.getDataFine()) >=0)) 
					{
					return true;}
				else {
					System.out.println("Non disponibile");
					return false;
				}
			}
			
			if(PrenotazioniDao.getListaPrenotazioni().values().isEmpty()) {
				return true;
			}
			return false;
			
		}
		
//		public static List<Risorsa> getRisorsePerCaratteristica(String tipo, int caratteristica) {
//			List<Risorsa> risorseTrovate = new ArrayList<>();
//			for (Risorsa indice: GestioneRisorse.StampaRisorse(tipo, caratteristica)) {
//				risorseTrovate.add(indice);
//			}
//			return risorseTrovate;
//		}
//		
//		public static List<Risorsa> getRisorseData(String tipo, LocalDateTime dataInizio, LocalDateTime dataFine) {
//			List<Risorsa> risorseTrovate = new ArrayList<>();
//			for (Risorsa i: GestioneRisorse.StampaRisorseTipo(tipo))
//				if (risorsaDisponibileData(i, dataInizio, dataFine))
//						risorseTrovate.add(i);
//			return risorseTrovate;
//		}
		
}

