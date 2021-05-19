package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Garage;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Controller
public class ControladorGarage {
	@RequestMapping("/formularioAgregarGarage")
	public ModelAndView mostrarFormularioGaraga() {
		ModelMap modelo = new ModelMap();
		Garage garage1 = new Garage();
		modelo.put("garage", garage1);
		return new ModelAndView("agregarGarage", modelo);
	}
	
	
	@RequestMapping(path="confirmarAgregarGarage", method = RequestMethod.POST))
	public ModelAndView datosGarage() {
		@ModelAttribute ("garage") Garage garage1,
		@RequestParam(value="nombre", required= false)String nombre, 
	}
		)
		
	}
	
	
	
	
	
	
}
