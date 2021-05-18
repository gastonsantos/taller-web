package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import org.springframework.stereotype.Service;

import com.google.protobuf.TextFormat.ParseException;


import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Garage;
import ar.edu.unlam.tallerweb1.modelo.Ticket;
@Service
public class ServicioCobrarTicketImplementacion implements ServicioCobrarTickets {
	Ticket ticket = new Ticket();
	Garage garage1 = new Garage();
	@Override
	
	public Double PrecioDias(String fechaIngreso, String fechaEgreso) throws java.text.ParseException  {
		
		Integer dias = (int)ChronoUnit.DAYS.between((Temporal) LocalDate.parse(fechaIngreso), LocalDate.parse(fechaEgreso));
		garage1.setPrecioEstadia(400.0);
		
		return garage1.getPrecioEstadia() * dias;
		
	}

    @Override
	
	public Integer CantidadHoras( String horaIngreso)  {
		
		Integer hora = (int) ChronoUnit.HOURS.between((Temporal) LocalTime.parse(horaIngreso), LocalTime.now());
		

		return hora;
		
	}
    

	@Override
	
  	public Integer CantidadDiasEnGarage( String fechaIngreso, String fechaEgreso)  {
  		
  		Integer dias = (int) ChronoUnit.DAYS.between((Temporal) LocalDate.parse(fechaIngreso), LocalDate.parse(fechaEgreso));
  		

  		return dias;
  		
  	}
	
	



}
