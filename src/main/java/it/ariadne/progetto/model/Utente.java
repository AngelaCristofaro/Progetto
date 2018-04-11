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
public class Utente implements Serializable{
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
	
    public boolean equals(Object o) {
        if (o == null)
            return false;

        if (this == o)
            return true;

        if (!(o instanceof Utente))
            return false;
        Utente that = (Utente)o;

        if (this.getUsername().equals(that.getUsername()))
            return true;
        return false;
    }

	public int hashCode() {
        return username.hashCode();
    }
	
	public String toString() {
	    return("SamplePrincipal:  " + username);
	}
	
}