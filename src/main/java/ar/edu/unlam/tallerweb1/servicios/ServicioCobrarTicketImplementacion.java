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

import ar.edu.unlam.tallerweb1.modelo.Garage;
import ar.edu.unlam.tallerweb1.modelo.Ticket;
@Service
public class ServicioCobrarTicketImplementacion implements ServicioCobrarTickets{
	Ticket ticket = new Ticket();
	Garage garage1 = new Garage();
	@Override
	
	public Integer CantidadDias(String fechaIngreso) throws java.text.ParseException  {
		//Date fechaCitas = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(fechaIngreso);
		//Time horaCita = (Time) new SimpleDateFormat("HH:mm").parse(horaIngreso);
		Integer dias = (int)ChronoUnit.DAYS.between((Temporal) LocalDate.parse(fechaIngreso), LocalDate.now());
		//Integer hora = (int) ChronoUnit.HOURS.between((Temporal) LocalTime.parse(horaIngreso), LocalTime.now());
		//garage1.setPrecioHora(15.0);
		
		
	
		return dias;
		
	}

@Override
	
	public Integer CantidadHoras( String horaIngreso)  {
		//Date fechaCitas = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(fechaIngreso);
		//Time horaCita = (Time) new SimpleDateFormat("HH:mm").parse(horaIngreso);
		//Integer dias = (int)ChronoUnit.DAYS.between((Temporal) LocalDate.parse(fechaIngreso), LocalDate.now());
		Integer hora = (int) ChronoUnit.HOURS.between((Temporal) LocalTime.parse(horaIngreso), LocalTime.now());
		//garage1.setPrecioHora(15.0);
		
		
	
		return hora;
		
	}
	


}
