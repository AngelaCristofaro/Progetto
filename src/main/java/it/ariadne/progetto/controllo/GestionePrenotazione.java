package it.ariadne.progetto.controllo;


import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import it.ariadne.progetto.dao.PrenotazioniDao;
import it.ariadne.progetto.model.Prenotazioni;
import it.ariadne.progetto.model.Risorsa;
import it.ariadne.progetto.model.Utente;

@Controller
public class GestionePrenotazione {

	
//	@Autowired
//	private PrenotazioniDao<Prenotazioni> p ;
//	
//	
//	@RequestMapping(value="/all-prenotazioni", method = RequestMethod.GET)
//	public ModelAndView paginaPrenotazioni() {
//		List<Prenotazioni> prenotazioni = (List<Prenotazioni>) p.findAll();
//		JsonArray jsArrayPre = new JsonArray();
//		for (Prenotazioni pre : prenotazioni) {
//			JsonObject element = new JsonObject();
//			element.addProperty("id", pre.getIdPrenotazione());
//			element.addProperty("utente",pre.getUtente().getUsername());
//			element.addProperty("risorse", pre.getRis().getTipo1());
//			element.addProperty("dataInizio", pre.getDataInizio().toString());
//			element.addProperty("dataFine", pre.getDataFine().toString());
//			jsArrayPre.add(element);
//		}
//		return new ModelAndView("site.prenotazioni","prenotazioni", jsArrayPre.toString());
//	   }
//	
////	@RequestMapping(value="/prenotazioni", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
////	@ResponseBody
////	public String StampaPrenotazioni() {
////		List<Prenotazioni> prenotazioni = (List<Prenotazioni>) p.findAll();
////		JsonArray jsArrayPre = new JsonArray();
////		for (Prenotazioni pre : prenotazioni) {
////			JsonObject element = new JsonObject();
////			element.addProperty("id", pre.getIdPrenotazione());
////			element.addProperty("utente",pre.getUtente().getUsername());
////			element.addProperty("risorse", pre.getRis().getTipo1());
////			element.addProperty("dataInizio", pre.getDataInizio().toString());
////			element.addProperty("dataFine", pre.getDataFine().toString());
////			jsArrayPre.add(element);
////		}
////return jsArrayPre.toString();
////	}
//	
////	@RequestMapping(value="/getpossibiliprenotazioni", method = RequestMethod.GET)
////	public String risorsePossibili(@RequestBody ContenitorePrenotazioni cp) {
////		cp.getRes();
////		cp.getEndingDate();
////		cp.getStartingDate();
////		return "site.saveprenotazioni";
////		
////	
////	}
//
//	@RequestMapping(value="/saveprenotazione", method = RequestMethod.POST, produces =MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public String insertPre(@RequestBody Prenotazioni prenotazione) {
//		if (controllaPrenotazione(prenotazione.getUtente(),prenotazione.getRis()) 
//			&& controlloDate(prenotazione.getDataInizio(),prenotazione.getDataFine())
//			&& risorsaDisponibile(prenotazione.getRis()) 
//			&&risorsaDisponibileData(prenotazione.getRis(),prenotazione.getDataInizio(),prenotazione.getDataFine())) {
//		Prenotazioni prenotazioni = new Prenotazioni (prenotazione.getUtente(), prenotazione.getRis(),prenotazione.getDataInizio(),prenotazione.getDataFine());
//		prenotazioni.setDataFine(prenotazione.getDataFine());
//		p.save(prenotazioni);
//		return "site.saveprenotazioni";
//			}
//		else {
//			System.out.println("La Prenotazione esiste già o ci sono errori con le date o la risorsa non è disponibile");
//			}	return null;
//		}
//		
//		public void deletePre(Prenotazioni prenotazioni) {
//			if (controllaPrenotazione(prenotazioni.getUtente(), prenotazioni.getRis())) {
//				p.delete(prenotazioni);}
//		}
//		
//		public  void updatePre(Prenotazioni prenotazioni) {
//			if (controllaPrenotazione(prenotazioni.getUtente(), prenotazioni.getRis())) {
//				p.save(prenotazioni);}
//			else {
//				System.out.println("La prenotazione non esiste");
//			}
//		}
//		
//		public boolean controllaPrenotazione(Utente utente, Risorsa ris) {
//			for (Prenotazioni pre : p.findAll()) {
//				if(pre.getUtente().getUsername()== utente.getUsername() && (pre.getR() == ris.getId())) 
//				{return false;} 
//			}
//			return true;    
//		}
//		
//		public boolean controlloDate(LocalDateTime dataInizio, LocalDateTime dataFine) {
//			if((dataInizio.isBefore(dataFine) || dataInizio.isEqual(dataFine))) {
//			return true;
//			}
//			System.out.println("Attenzione alle date!");
//			return false;
//			
//		}
//		
//		public boolean risorsaDisponibile(Risorsa r) {
//			for (Prenotazioni prenotazione : p.findAll()) {
//				if(prenotazione.getDataFine().isBefore(LocalDateTime.now())
//					|| (r.getId() != prenotazione.getR())) 
//						{
//					return true;}
//				else {
//					System.out.println("Non disponibile");
//				}
//			}
//			if(((List<Prenotazioni>) p.findAll()).isEmpty()) {
//				return true;
//			}
//			return false;	
//		}
//		
//		
//		public boolean risorsaDisponibileData(Risorsa r,LocalDateTime inizio, LocalDateTime fine) {
//			for (Prenotazioni prenotazione : p.findAll()) {
//				if((r.getId() == prenotazione.getR() 
//					&& fine.compareTo(prenotazione.getDataInizio()) <=0 
//					&& inizio.compareTo(prenotazione.getDataFine()) >=0)) 
//					{
//					return true;}
//				else {
//					System.out.println("Non disponibile");
//					return false;
//				}
//			}
//			
//			if(((List<Prenotazioni>) p.findAll()).isEmpty()) {
//				return true;
//			}
//			return false;
//			
//		}
		
//		public static <T> List<Prenotazioni> ElencoMiePrenotazioni (Utente utente) {
//			List<Prenotazioni> miePrenotazioni = new ArrayList<>();
//			int count = 0 ;
//			for(Prenotazioni pre : PrenotazioniDao.getListaPrenotazioni().values()) {
//				if(utente.getUsername().equals(pre.getUtente().getUsername())) {
//					miePrenotazioni.add(pre);
//					count= count +1;
//				}
//			}
//			if(count > 0) {
//				System.out.printf("Le prenotazioni di " + utente.getUsername() + " sono:" + miePrenotazioni);
//			}
//			else {
//				System.out.println("Non ci sono prenotazioni");
//			}
//			return miePrenotazioni;
//		}
//		
//		public static <T> List<Prenotazioni> ElencoMiePrenotazioniOra (Utente utente) {
//			List<Prenotazioni> miePrenotazioniOra = new ArrayList<>();
//			int count = 0 ;
//			for(Prenotazioni pre : PrenotazioniDao.getListaPrenotazioni().values()) {
//				if(utente.getUsername().equals(pre.getUtente().getUsername()) && pre.getDataFine().isAfter(LocalDateTime.now())) {
//					miePrenotazioniOra.add(pre);
//					count= count +1;
//				}
//			}
//			if(count > 0) {
//				System.out.printf("Le prenotazioni di " + utente.getUsername() + " sono:" + miePrenotazioniOra);
//			}
//			else {
//				System.out.print("Non ci sono prenotazioni");
//			}
//			return miePrenotazioniOra;
//		}
//		
//		
//		public static <T> List<Prenotazioni> StampaPrenotazioniPerData(LocalDateTime dataInizio) {
//			List<Prenotazioni> StampaPrenotazioniData = new ArrayList<>();
//			for(Prenotazioni pre : PrenotazioniDao.getListaPrenotazioni().values()) {
//				if(pre.getDataInizio().isAfter(dataInizio) || pre.getDataInizio().isEqual(dataInizio)) {
//				StampaPrenotazioniData.add(pre);
//				}
//			}
//			return StampaPrenotazioniData;
//		}
//		
//		public boolean controlloRitardo(Prenotazioni pre, LocalDateTime dataConsegna) {
//			if (pre.getDataFine().isBefore(dataConsegna) == true) {
//				return true;
//			} else {
//				List<Utente> ritardatari = new ArrayList<Utente>();
//					ritardatari.add(pre.getUtente());
//				System.out.println("Messaggio sollecito al cliente : " + pre.getUtente().getUsername());
//				System.out.println("Sei in ritardo di : " + ChronoUnit.DAYS.between(dataConsegna, pre.getDataFine()) +" giorni");
//				return false; 
//			}
//		}
//		
//		public void consegna(Prenotazioni pre, LocalDateTime dataConsegna) {
//			pre.setDataConsegna(dataConsegna);
//		}
//		
//		
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

