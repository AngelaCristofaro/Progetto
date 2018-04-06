package it.ariadne.progetto.model;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
public abstract class Risorsa implements Serializable { 
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@OneToMany(mappedBy="risorsa")
		private List<Prenotazioni> prenotazioni;
		@Column 
		private int caratteristica;
		
		@Transient
		@JsonInclude(Include.ALWAYS)
		private String tipo1;
		
		public String getTipo1() {
			return tipo1;
		}

		public void setTipo1(String tipo1) {
			this.tipo1 = tipo1;
		}

		@Id 
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "id", updatable = false, nullable = false)
		private int id;
		private static AtomicInteger i = new AtomicInteger();
		
		public Risorsa() {
			 tipo1 = this.getClass().getSimpleName();
		}
		
		public Risorsa(int caratteristica) {
			this.id = i.incrementAndGet(); 
			this.caratteristica= caratteristica;
				}
		
		public int getId() {
			return id; 
		}
		
		public void setId(int id) { 
			this.id = id;
		}
		
		public int getCaratteristica() {
			return caratteristica;
		}
		
		public void setCaratteristica(int caratteristica) {
			this.caratteristica = caratteristica;
		}
		
		@Override
		public boolean equals(Object o) {
			Risorsa r = (Risorsa) o;
			return this.id == r.id;
		}		
}

