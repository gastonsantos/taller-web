package ar.edu.unlam.tallerweb1.controladores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioCalculadora;



@Controller
public class ControladorCalculadora {
	
	private ServicioCalculadora servicioCalculadora;

	@Autowired
	public ControladorCalculadora(ServicioCalculadora servicioCalculadora) {
		this.servicioCalculadora= servicioCalculadora;
	}
	
	@RequestMapping("/mostrarcalculadora")
	public ModelAndView mostrarCalculadora(){
		
		return new ModelAndView("calculadora");
		
	}
	
	
	@RequestMapping("/realizaroperacion")
	public ModelAndView procesarCalculo(@RequestParam(value="operando1", required = true) Integer operando1,
			@RequestParam(value = "operando2", required = true)Integer operando2,
			@RequestParam(value = "operacion", required = false)Integer operacion) {
		
		ModelMap modelo = new ModelMap();
		Integer resultado;
		modelo.put("operando1", operando1);
		modelo.put("operando2", operando2);
		switch(operacion) {
		case 1:
			resultado = servicioCalculadora.sumar(operando1, operando2);
			modelo.put("operacion", "suma");
			modelo.put("resultado", resultado);
			break;
		case 2: 
			resultado = servicioCalculadora.restar(operando1, operando2);
			modelo.put("operacion", "resta");
			modelo.put("resultado", resultado);
			break;
		case 3:
			resultado = servicioCalculadora.multiplicar(operando1, operando2);
			modelo.put("operacion", "multiplicacion");
			modelo.put("resultado", resultado);
			break;
		case 4:
			try {
				resultado = servicioCalculadora.dividir(operando1, operando2);
				modelo.put("operacion", "dividir");
				modelo.put("resultado", resultado);
			}catch(Exception e1) {
				modelo.put("resultado ", e1.getMessage());
			}
			
			break;
		default:
			
			break;
		}
		
		
		return new ModelAndView("calculadora", modelo);
		
	}
}
