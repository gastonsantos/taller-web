package ar.edu.unlam.tallerweb1.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate fecha = LocalDate.now();
	private LocalTime horaEntrada = LocalTime.now();
	
	@OneToOne
	private Auto auto;
	
	@ManyToOne
	private Garage garage1;
	
	@ManyToOne
	private Alquiler alquiler;
	
	public Alquiler getAlquiler() {
		return alquiler;
	}
	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	public Garage getGarage1() {
		return garage1;
	}
	public void setGarage1(Garage garage1) {
		this.garage1 = garage1;
	}
}
