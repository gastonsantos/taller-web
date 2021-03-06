
package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Auto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String patente;

	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	private Garage garage;

	

	private String marca;
	private String modelo;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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


	



	@Override
	public String toString() {
		return "Auto [id=" + id + ", patente=" + patente + ", cliente=" + cliente + ", garage=" + garage + ", marca="
				+ marca + ", modelo=" + modelo + "]";
	}
}
