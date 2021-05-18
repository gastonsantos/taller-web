package ar.edu.unlam.tallerweb1.controladores;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioCobrarTickets;

@Controller
public class ControladorPagarGarage {

	private ServicioCobrarTickets servicioCobrarTicket;
	@Autowired
	public ControladorPagarGarage(ServicioCobrarTickets servicioCobrarTicket) {
		this.servicioCobrarTicket = servicioCobrarTicket; 
	}
	
	@RequestMapping("/MostrarPagar")
	public ModelAndView mostrarCalculadora(){
		
		return new ModelAndView("Pagar");
		
	}
	
	@RequestMapping("/realizarPago")
	public ModelAndView procesarPago(@RequestParam(value="fecha", required = true) String fecha,
			@RequestParam(value = "hora", required = true)/*@DateTimeFormat(pattern="HH:mm")*/String hora
			) throws ParseException {
		ModelMap modelo = new ModelMap();
		Integer resultadoDias;
		Integer resultadoHoras;
		modelo.put("fecha", fecha);
		modelo.put("hora", hora);
		resultadoDias = servicioCobrarTicket.CantidadDias(fecha);
		resultadoHoras = servicioCobrarTicket.CantidadHoras(hora);
		modelo.put("resultadoHoras", resultadoHoras);
		modelo.put("resultadoDias", resultadoDias);
		return new ModelAndView("pagarMonto", modelo);
	}

}

