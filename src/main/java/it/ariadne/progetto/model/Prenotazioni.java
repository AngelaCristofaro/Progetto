package it.ariadne.progetto.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="prenotazioni")
public class Prenotazioni implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPrenotazione;
	
	@Column(name="dataInizio")
	public LocalDateTime  dataInizio;
	
	@Column (name="dataFine")
	public LocalDateTime  dataFine;
	
	@ManyToOne
	private Utente utente;

	@ManyToOne
	private Risorsa risorsa;
	private LocalDateTime dataConsegna;
	
	public  LocalDateTime getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(LocalDateTime dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	private static AtomicInteger i=new AtomicInteger();
	public Prenotazioni(Utente utente, Risorsa r , LocalDateTime  dataInizio,LocalDateTime  dataFine) {
		this.idPrenotazione = i.incrementAndGet(); 
		//this.durata = ChronoUnit.HOURS.between(dataInizio, dataFine);
		this.utente = utente;
		this.risorsa=r;
		this.dataInizio = dataInizio;
		this.dataFine= dataFine;
	}
	
	public int getR() {
		return risorsa.getId();
	}
	
	public Risorsa getRis() {
		return risorsa;
	}

	public void setR(Risorsa r) {
		this.risorsa = r;
	}

	
	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	
	public Utente getUtente() {
		return this.utente;
	}

			
	public int getIdPrenotazione() {
		return idPrenotazione;
	}
	
	@Override
	public boolean equals(Object o) {
		Prenotazioni p = (Prenotazioni) o;
		return this.idPrenotazione == p.idPrenotazione;
	}


}