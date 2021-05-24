package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/homeGarages")
	public ModelAndView homeGarages() {
		ModelMap modelo = new ModelMap();
		return new ModelAndView("HomeGarages", modelo);
	}
	
	@RequestMapping("/formularioAgregarGarage")
	public ModelAndView mostrarFormularioGaraga() {
		ModelMap modelo = new ModelMap();
		Garage garage1 = new Garage();
		modelo.put("garage", garage1);
		return new ModelAndView("agregarGarage", modelo);
	}
	
	
	
	@RequestMapping(path="confirmarAgregarGarage", method = RequestMethod.POST)
	public String agregarGarage(
	@ModelAttribute ("garage") Garage garage1){
	servicioGarage.agregarGarage(garage1);
	return "redirect:/lista";
		
	}
	
	@RequestMapping("/buscarGarage")
	public ModelAndView mostrarBuscarGaraga() {
		ModelMap modelo = new ModelMap();
		Garage garage= new Garage();
		modelo.put("garage", garage);
		return new ModelAndView("GaragesBD", modelo);
	}
	
	@RequestMapping("/lista")
	public String Lista(Model modelo){
		modelo.addAttribute("garages", servicioGarage.consultarGarage());
		return ("DatosGaragesPorPantalla");
	}
	
	@RequestMapping("/lista/eliminar/{id}")
	public String eliminarGarage(@PathVariable("id")Long id, Model model) {
		
		servicioGarage.eliminarGarage(id);
		return "redirect:/lista";
	}
	
	/*
	@RequestMapping(path="buscoElGarage", method = RequestMethod.POST)
	public ModelAndView Mostrardatos(
	 	
			@ModelAttribute("garage") Garage garage,
			@RequestParam(value="nombre", required=false) String nombre
			
			) {
		List<Garage> garageBuscado = servicioGarage.consultarGarage(garage);
			ModelMap modelo = new ModelMap();
			/*modelo.put("id", ((Garage) garageBuscado).getId());
			modelo.put("nombre",  ((Garage) garageBuscado).getNombre());
			modelo.put("localidad", ((Garage) garageBuscado).getLocalidad());
			modelo.put("precioHora", ((Garage) garageBuscado).getPrecioHora());
			modelo.put("precioEstadia", ((Garage) garageBuscado).getPrecioEstadia());
			modelo.put("precioMes",  ((Garage) garageBuscado).getPrecioMes());
			*/
			/*for(Garage e : garageBuscado) {
				modelo.put("id", e.getId());
				modelo.put("nombre", e.getNombre());
				modelo.put("localidad", e.getLocalidad());
				modelo.put("precioHora", e.getPrecioHora());
				modelo.put("precioEstadia", e.getPrecioEstadia());
				modelo.put("precioMes", e.getPrecioMes());
			}
			
		
	return new ModelAndView("DatosGaragesPorPantalla", modelo);
	}
   */
}
