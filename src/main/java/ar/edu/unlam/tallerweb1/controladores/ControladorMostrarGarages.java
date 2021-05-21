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
	public ModelAndView datosGarage( 
		@ModelAttribute ("garage") Garage garage1,
		@RequestParam(value="nombre", required= false)String nombre,
		@RequestParam(value="calle", required = false)String calle,
		@RequestParam(value="numero", required = false)Integer numero, 
		@RequestParam(value="localidad", required=false)String localidad,
		@RequestParam(value="precioHora", required=true)Double precioHora,
		@RequestParam(value="precioEstadia", required=true)Double precioEstadia,
		@RequestParam(value="precioMes", required=true)Double precioMes,
		@RequestParam(value="capacidad", required=true)Integer capacidad
	){
	ModelMap modelo = new ModelMap();
	modelo.put("nombre", nombre);
	modelo.put("calle", calle);
	modelo.put("numero", numero);
	modelo.put("localidad", localidad);
	modelo.put("precioHora", precioHora);
	modelo.put("precioEstadia", precioEstadia);
	modelo.put("precioMes", precioMes);
	modelo.put("capacidad", capacidad);
	servicioGarage.agregarGarage(garage1);
		return new ModelAndView("HomeGarages", modelo);
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
			
		
	return new ModelAndView("DatosGaragesPorPantalla", modelo);
	}
}
