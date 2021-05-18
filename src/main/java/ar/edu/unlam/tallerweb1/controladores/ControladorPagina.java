package ar.edu.unlam.tallerweb1.controladores;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPagina {

	@RequestMapping("/mostrarPrueba")
	public ModelAndView mostrarPrueba(){
		
		return new ModelAndView("Prueba");
		
	}
		
	
	
}
