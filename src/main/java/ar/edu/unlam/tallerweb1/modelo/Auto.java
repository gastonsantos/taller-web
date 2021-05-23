package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Auto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String patente;
	private String marca;
	private String modelo;
	
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Garage garage;
	
	
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
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo(){
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Garage getGarage() {
		return garage;
	}
	public void setGarage(Garage garage) {
		this.garage = garage;
	}
	
	
	
	
}