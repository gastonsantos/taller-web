package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import com.google.protobuf.TextFormat.ParseException;

import ar.edu.unlam.tallerweb1.modelo.Garage;

public interface ServicioCobrarTickets {
	Double PrecioDias(String fecha, String hasta) throws java.text.ParseException ;
	Integer CantidadHoras(String hora);
	Integer CantidadDiasEnGarage(String fechaIngreso, String fechaEgreso);
	
	
	
}
