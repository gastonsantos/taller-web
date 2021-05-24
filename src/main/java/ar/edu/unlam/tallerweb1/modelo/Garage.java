package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Garage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String calle;
	private Integer numero;
	private String localidad;
	private Double precioHora;
	private Double precioEstadia;
	private Double precioMes;
	private Integer capacidad;
	private Integer contador=0;
	/*
	@ManyToOne
	private Due�o due�o;
	*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Double getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(Double precioHora) {
		this.precioHora = precioHora;
	}

	public Double getPrecioEstadia() {
		return precioEstadia;
	}

	public void setPrecioEstadia(Double precioEstadia) {
		this.precioEstadia = precioEstadia;
	}

	public Double getPrecioMes() {
		return precioMes;
	}

	public void setPrecioMes(Double precioMes) {
		this.precioMes = precioMes;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/*
	public Due�o getDue�o() {
		return due�o;
	}

	public void setDue�o(Due�o due�o) {
		this.due�o = due�o;
	}
	
	
	
	*/

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador =contador;
	}
	
	
}
