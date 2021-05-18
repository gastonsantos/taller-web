package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import com.google.protobuf.TextFormat.ParseException;

public interface ServicioCobrarTickets {
	Integer CantidadDias(String fecha/*,String hora*/) throws java.text.ParseException ;
	Integer CantidadHoras(String hora);
	//
}
