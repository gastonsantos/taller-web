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
			@RequestParam(value="hasta", required = true) String hasta,
			@RequestParam(value = "hora", required = true)String hora
			) throws ParseException {
		ModelMap modelo = new ModelMap();
		Double precioDias;
		Integer resultadoHoras;
		Integer resultadoCantidaDias;
		modelo.put("fecha", fecha);
		modelo.put("hora", hora);
		modelo.put("hasta",hasta);
		precioDias = servicioCobrarTicket.PrecioDias(fecha, hasta);
		resultadoHoras = servicioCobrarTicket.CantidadHoras(hora);
		resultadoCantidaDias = servicioCobrarTicket.CantidadDiasEnGarage(fecha,hasta);
		
		modelo.put("resultadoHoras", resultadoHoras);
		modelo.put("resultadoDias", precioDias);
		modelo.put("resuladoCantidadDias", resultadoCantidaDias);
		return new ModelAndView("pagarMonto", modelo);
	}

}

