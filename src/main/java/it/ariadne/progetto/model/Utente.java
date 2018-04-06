package it.ariadne.progetto.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="utente")
public class Utente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false)
	private String username; 
	@Column (nullable = false)
	private String password;
	@OneToMany(mappedBy="utente")
	private List<Prenotazioni> prenotazioni;

	public Utente (String username,String password) {
		this.username = username;
		this.password = password;
	}
	public Utente() {
		// TODO Auto-generated constructor stub
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public boolean equals(Object o) {	
		Utente u = (Utente) o;
		return this.username == u.username;
	}

	}

