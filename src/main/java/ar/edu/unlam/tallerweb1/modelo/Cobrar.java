package ar.edu.unlam.tallerweb1.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Cobrar {
	
	private Ticket ticket;
	private LocalDate fecha = LocalDate.now();
	private LocalTime horaSalida = LocalTime.now();
	
	
	public Double montoACobrar() {
		Double precioHora= 0.0;
		//Double precioEstadia = 0.0;
		
		//LocalDate fechaIngreso =ticket.getFecha();
		LocalTime horaIngreso = ticket.getHoraEntrada();
		//LocalDate fechaIngreso = ticket.getFecha();
		precioHora = ticket.getGarage1().getPrecioHora();
		//precioEstadia = ticket.getGarage1().getPrecioEstadia();
		//Integer fecha=  (int) ChronoUnit.DAYS.between(fechaIngreso, LocalDate.now());
		Integer hora = (int) ChronoUnit.HOURS.between(horaIngreso, LocalTime.now());
		
		Double costo = hora*precioHora;
		return costo;
	}
	
	
	
	
	
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}
	
	
	
	
	

}
