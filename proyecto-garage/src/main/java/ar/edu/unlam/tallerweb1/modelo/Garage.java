package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Garage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private Integer capacidad;
	private Double precioHora;
	private Double precioSemana;
	private Double precioMes;
	private String horario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public Double getPrecioHora() {
		return precioHora;
	}
	public void setPrecioHora(Double precioHora) {
		this.precioHora = precioHora;
	}
	public Double getPrecioSemana() {
		return precioSemana;
	}
	public void setPrecioSemana(Double precioSemana) {
		this.precioSemana = precioSemana;
	}
	public Double getPrecioMes() {
		return precioMes;
	}
	public void setPrecioMes(Double precioMes) {
		this.precioMes = precioMes;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
}
