package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioCalculadora;

@Controller
public class ControladorCalculadora {
	
	private ServicioCalculadora servicioCalculadora;
	
	@Autowired
	public ControladorCalculadora(ServicioCalculadora servicioCalculadora) {
			
		this.servicioCalculadora = servicioCalculadora;
	}
	
	@RequestMapping("/mostrarCalculadora")
	public ModelAndView mostrarCalculadora() {
		return new ModelAndView("Calculadora");
	}
		
	@RequestMapping("/realizaroperacion")
	public ModelAndView procesarCalculo(@RequestParam(value = "operando1", required = true) Double operando1,
			@RequestParam(value = "operando2", required = true) Double operando2,
			@RequestParam(value = "operacion", required = false) Integer operacion) {
		
	Double resultado;
	ModelMap modelo = new ModelMap();
	modelo.put("operando1", operando1);
	modelo.put("operando2", operando2);
	
	switch (operacion) {
	case 1:
	resultado=servicioCalculadora.sumar(operando1,operando2);
	modelo.put("operacion", "Suma");
	modelo.put("resulatado",resultado);
	break;
	case 2:
	modelo.put("operacion", "resta");
	resultado=servicioCalculadora.restar(operando1,operando2);
	modelo.put("resulatado",resultado);
	break;

	 case 3:
	resultado=servicioCalculadora.multiplicar(operando1,operando2);
	modelo.put("operacion", "multplicacion");
	modelo.put("resulatado",resultado);
	break;
	// Hacer caso de dividir 
	 default:
	 case 4:
		 	//try
			resultado=servicioCalculadora.multiplicar(operando1,operando2);
			modelo.put("operacion", "multplicacion");
			modelo.put("resulatado",resultado);
			// catch
			break;
		 
	}
		return new ModelAndView("Calculadora", modelo);
	}
}
