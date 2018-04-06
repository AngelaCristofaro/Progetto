package it.ariadne.progetto.controllo;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		public boolean controllopassword(String password) {
			if(password.length()>8) {
				return true;
			}
			else {
				return false;
			}
		} 
		

	   @RequestMapping(value="/gestisciutenti", method = RequestMethod.GET)
		   public String paginaUtente() {
			   return "site.utenti";
	}
	   
	   @RequestMapping(value="/gestisciRegistrazione", method = RequestMethod.GET)
	   public String paginaUtenteReg() {
		   return "site.registrazione";
}
	   @RequestMapping(value="/impostazioniUtente", method = RequestMethod.GET)
	   public String paginaImpUtente() {
		   return "site.impostazioni";
}
		   
	   @RequestMapping(value="/save-utente", method=RequestMethod.POST, produces =MediaType.APPLICATION_JSON_VALUE)
	   @ResponseBody
	   public ModelAndView saveUtente(@RequestBody Utente utente) {
		   if(controlloMail(utente.getUsername())&& controllopassword(utente.getPassword()) && controlloDati(utente)){
		   ud.insert(utente);
	 }
			return new ModelAndView("insert.html", "utente" , utente);
		}
	   
		@RequestMapping(value="/delete-utente", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		public  void  deleteUtente(@RequestParam int id) {
			ud.delete(id);
		}
	   
	   @PostMapping("/update-utente")
		public ModelAndView updateUtente(@ModelAttribute Utente utente) {
		   ud.insert(utente);
			return new ModelAndView ("deleteUpdate.html", "utente", utente);
		}
	   

		@GetMapping("/")
		public String home(HttpServletRequest request) {
			request.setAttribute("mode", "MODE_HOME");
			return "insert.html";
		}
		
		@RequestMapping(value="/utenti", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<Utente> findAllUtenti() {
			List<Utente> utenti = ud.findAll();
			return utenti;
		}
		
		
}
