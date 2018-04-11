package it.ariadne.progetto.controllo;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import it.ariadne.progetto.dao.UtenteDao;
import it.ariadne.progetto.model.Utente;

@Controller
public class GestioneUtente {
	
	@Autowired
	private UtenteDao<Utente> ud;

	public boolean controlloDati(Utente utente) {
		if(ud.findByUsername(utente.getUsername()) == null) 
			{return true;} 
			
			return false;  
		}
	
	public boolean controlloMail(String mail) {
		if(mail.indexOf('@')>-1) {
			return true;
			}
		else {
			return false;
			}
		}
		
	public boolean controllopassword(String cs) {
		if(cs.length()>8) {
			return true;
			}
		else {
			return false;
			}
		} 
		
	  @RequestMapping(value="/gestione_utenti", method = RequestMethod.GET)
	  public String paginaUtente() {
			return "site.utenti";
}
	   @RequestMapping(value="/", method = RequestMethod.GET)
	   public String home() {
		   return "site.homepage";
}
	   
	   @RequestMapping(value="/gestisci_registrazione", method = RequestMethod.GET)
	   public String paginaUtenteReg() {
		   return "site.registrazione";
}
	   
	   @RequestMapping(value="/impostazioni_utente", method = RequestMethod.GET)
	   public String paginaImpUtente(@RequestParam(value="nome") String nome,HttpServletRequest request) {  
		   Utente us = ud.findByUsername(nome);
		   request.setAttribute("us", us);
		   return "site.impostazioni";
}
	   @RequestMapping(value="/login_utente", method = RequestMethod.GET)
	   public ModelAndView paginaLogin( @RequestParam(value = "error", required = false) String error,
				@RequestParam(value = "logout", required = false) String logout){
		  
			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Utente o password non validi!");
			}
	 
			if (logout != null) {
				model.addObject("msg", "Logout eseguito con successo");
			}
			model.setViewName("site.login");
	 
		   return model;
}
		   
	   @RequestMapping(value="/save-utente", method=RequestMethod.POST, produces =MediaType.APPLICATION_JSON_VALUE)
	   @ResponseBody
	   public void saveUtente(@RequestBody Utente utente) {
		   if(controlloMail(utente.getUsername())&& controllopassword(utente.getPassword()) && controlloDati(utente)){
		   ud.save(utente);
		   }
}
	   
		@RequestMapping(value="/delete-utente", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		public  void  deleteUtente(@RequestParam int id) {
			ud.delete(id);
		}
	   
		@RequestMapping(value="/update-utente", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public String updateUtente(@RequestBody Utente utente) {
		   ud.save(utente);
			return "/";
		}
	   
		@RequestMapping(value="/utenti", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<Utente> findAllUtenti() {
			List<Utente> utenti = (List<Utente>) ud.findAll();
			return utenti;
		}
}
