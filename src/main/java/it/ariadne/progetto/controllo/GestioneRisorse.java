package it.ariadne.progetto.controllo;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import it.ariadne.progetto.dao.RisorsaDao;
import it.ariadne.progetto.model.Risorsa;

@Controller
public class GestioneRisorse {

	@Autowired
	private RisorsaDao<Risorsa> rd ;
	Log log;
	
	   @RequestMapping(value="/save-risorsa", method=RequestMethod.POST, produces =MediaType.APPLICATION_JSON_VALUE)
	   @ResponseBody
	   public void saveRisorsa(@RequestBody String risorsa) {
		   Gson gson = new GsonBuilder()
		   			.registerTypeAdapter(Risorsa.class, new ControlloRisorsaGson())
		   			.create();
		   Risorsa risorsa1 = gson.fromJson(risorsa, Risorsa.class);
		   rd.insertR(risorsa1);
		
		}
	  
	   @RequestMapping(value="/gestiscirisorse", method = RequestMethod.GET)
	   public String paginaRisorsa() {
		   return "site.risorse";
	   }
	   
	   @RequestMapping(value="/gestiscirisorseUtente", method = RequestMethod.GET)
	   public String paginaRisorsaUtente() {
		   return "site.risorseUtente";
	   }
	   
	    @RequestMapping(value="/risorse", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
	    public List<Risorsa> findAllRisorse() {
			List<Risorsa> risorsa = rd.findAll();
			return risorsa;
		}
	    
	    @RequestMapping(value="/delete-risorsa", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	    public String deleteRisorsa(@RequestParam int id) {
			rd.deleteR(id);
			return "saveRisorsa";
		}
	   
		
//	public static <T> List<Risorsa> StampaRisorse(String tipo, int caratteristica) {
//		List<Risorsa> ris = new ArrayList<>();
//		for (Risorsa r : RisorsaDao.getListaRisorse().values()) {
//			if (r.getClass().getSimpleName().equals(tipo) && r.getCaratteristica() == caratteristica)
//			{ris.add(r);}
//		} 
//			return ris;
//		}
//	
//	public static <T> List<Risorsa> StampaRisorseTipo(String tipo) {
//		List<Risorsa> risoTipo = new ArrayList<>();
//		for (Risorsa r : RisorsaDao.getListaRisorse().values()) {
//			if (r.getClass().getSimpleName().equals(tipo))
//			{risoTipo.add(r);}
//		} 
//			return risoTipo;
//		}
}

