package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Garage;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioGarage;
@Controller
public class ControladorMostrarGarages {

	private ServicioGarage servicioGarage;
	
	@Autowired
	public ControladorMostrarGarages(ServicioGarage servicioGarage){
		this.servicioGarage = servicioGarage;
	}
	
	
	@RequestMapping("/buscarGarage")
	public ModelAndView mostrarBuscarGaraga() {
		ModelMap modelo = new ModelMap();
		Garage garage= new Garage();
		modelo.put("garage", garage);
		return new ModelAndView("GaragesBD", modelo);
	}
	
	@RequestMapping(path="buscoElGarage", method = RequestMethod.POST)
	public ModelAndView Mostrardatos(
			@ModelAttribute("garage") Garage garage,
			@RequestParam(value="nombre", required=false) String nombre
			
			) {
		Garage garageBuscado =  servicioGarage.consultarGarage(garage);
			ModelMap modelo = new ModelMap();
			modelo.put("id", garageBuscado.getId());
			modelo.put("nombre",  garageBuscado.getNombre());
			modelo.put("localidad", garageBuscado.getLocalidad());
			modelo.put("precioHora", garageBuscado.getPrecioHora());
			modelo.put("precioEstadia", garageBuscado.getPrecioEstadia());
			modelo.put("precioMes",  garageBuscado.getPrecioMes());
			//modelo.put("idPlataforma", garageBuscado.getPlataforma().getId());
		
	return new ModelAndView("DatosGaragesPorPantalla", modelo);
	}
}
