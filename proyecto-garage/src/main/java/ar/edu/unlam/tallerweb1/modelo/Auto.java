package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Auto {

	@Id
	private String patente;
	
	@OneToOne
	private Cliente auto;
	
	@ManyToOne
	private Garage garage;
	
	

	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Cliente getAuto() {
		return auto;
	}

	public void setAuto(Cliente auto) {
		this.auto = auto;
	}
	
	
}
