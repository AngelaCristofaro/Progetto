package it.ariadne.test;


//import java.time.LocalDateTime;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import it.ariadne.progetto.controllo.GestionePrenotazione;
//import it.ariadne.progetto.controllo.GestioneRisorse;
//import it.ariadne.progetto.controllo.GestioneUtente;
//import it.ariadne.progetto.dao.PrenotazioniDao;
//import it.ariadne.progetto.dao.RisorsaDao;
//import it.ariadne.progetto.dao.UtenteDao;
//import it.ariadne.progetto.model.Prenotazioni;
//import it.ariadne.progetto.model.Risorsa;
//import it.ariadne.progetto.model.Utente;
//import it.ariadne.progetto.model.risorse.Laptop;
//import it.ariadne.progetto.model.risorse.Sala;
//
public class TestProgettoTB {
//	  Utente u1 = new Utente("ai@t","e09876543746"); 
//	  Utente u2 = new Utente("ai@sagrht","ìkajef567849230iewokds"); 
//	  Risorsa lap = new Laptop(65);
//	  Risorsa lap2 = new Laptop(9);
//	  Risorsa sala=new Sala(86);
//	  Prenotazioni pre = new Prenotazioni (u1,lap,LocalDateTime.of(90, 1, 16, 7, 45, 55),LocalDateTime.of(91,1,14,13,14,44));
//	  LocalDateTime consegna = LocalDateTime.of(93,2,1,3,42,11);
//	  GestioneUtente gu = new GestioneUtente();
//	  GestioneRisorse gr= new GestioneRisorse();
//	  GestionePrenotazione gp= new GestionePrenotazione();
//	  
//	  
//	  @Test 
//		public void risorsaEsistente() {
//			Assert.assertTrue("La risorsa Laptop non esiste", lap.getCaratteristica() != 0);
//			Assert.assertTrue("La risorsa Sala non esiste", sala.getCaratteristica() != 0);
//		} 
//		
//	   @Test 
//		public void aggiungiRisorsa() {
//			gr.aggiungiRisorsa(lap2);
//			gr.aggiungiRisorsa(lap);
//			for (Risorsa risorsa : RisorsaDao.treeMapRisorsa.values()) {
//				//System.out.println(risorsa);
//			}
//			Assert.assertTrue("Non ci sono risorse", RisorsaDao.getListaRisorse().values().size() > 0 );
//		}
//		
//		/*@Test
//		public void aggiungiUtente() {
//			gu.aggiungiUtente(u1.getMail(),u1.getPassword());
//			gu.aggiungiUtente(u2.getMail(),u2.getPassword());
//			for (Utente utente1 : UtenteDao.treeMapUtente.values()) {
//				//System.out.println(utente1);
//			}
//		    Assert.assertTrue("Utente non inserito", UtenteDao.getListaUtenti().size() > 0);
//	}*/
//
//		@Test 
//		public void aggiungiPrenotazione() {
//			//gp.risorsaDisponibile(lap);
//			pre.setDataConsegna(consegna);
//			//gp.insertPre(u1,lap,LocalDateTime.of(2000, 8, 9, 12, 34), LocalDateTime.of(3000, 8, 9, 12, 34));
//			gp.insertPre(u1,lap,LocalDateTime.of(2000, 8, 9, 12, 34), LocalDateTime.of(2001, 8, 9, 12, 34));
//			//gp.insertPre(u1,lap2,LocalDateTime.of(1000, 8, 9, 12, 34), LocalDateTime.of(1800, 8, 9, 12, 34));
//			for (Prenotazioni pre : PrenotazioniDao.treeMapPrenotazione.values()) {
//				//System.out.println(pre);
//			}
//			Assert.assertTrue("Prenotazione non inserita", PrenotazioniDao.getListaPrenotazioni().size() > 0 );
//	}
//		@Test
//		public void risorsaDisponibile() {
//			
//			Assert.assertTrue("Risorsa non disponibile, è in ritardo", gp.controlloRitardo(pre, LocalDateTime.of(8654,9,4,2,1,1,1)) == true);
//		}
//		
//		@Test
//		public void risorsaTipoCaratteristica() {
//			//System.out.println(gp.getRisorsePerCaratteristica("Laptop",65));
//			Assert.assertTrue("Risorsa non esistente", gp.getRisorsePerCaratteristica("Laptop", 65).size() > 0);
//		}
//		
//		@Test
//		public void risorsaTipo() {
//			//System.out.println(gp.getRisorseData("Laptop",LocalDateTime.of(8654,9,4,2,1,1,1),LocalDateTime.of(8654,9,4,2,1,1,1)));
//			Assert.assertTrue("Risorsa non esistente", gp.getRisorseData("Laptop",LocalDateTime.of(8654,9,4,2,1,1,1),LocalDateTime.of(8654,9,4,2,1,1,1)).size() > 0);
//		}
}