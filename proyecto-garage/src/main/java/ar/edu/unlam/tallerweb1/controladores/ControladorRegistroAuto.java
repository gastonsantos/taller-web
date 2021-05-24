package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

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

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;

@Controller
public class ControladorRegistroAuto {

	private ServicioRegistro servicioRegistro;
	
	
	@Autowired
	public ControladorRegistroAuto(ServicioRegistro servicioRegistro){
		this.servicioRegistro = servicioRegistro;
	}
	
	
	@RequestMapping("/mostrarRegistroAuto")
	public 	ModelAndView registro() {
		ModelMap modelo = new ModelMap(); //Agrupa todo para mandarlo a vista
		Auto auto = new Auto();//Se crea un usuario vacio para mandarlo vacio para que el formulario se vaya llenando
		modelo.put("auto", auto);
		return new ModelAndView("registroAuto", modelo); //Se le envia a la vista registro el modelo con el objeto usuario
	}
	@RequestMapping(path="/procesarRegistroAuto", method=RequestMethod.POST)
	public ModelAndView procesarRegistroAuto(
			@ModelAttribute("auto") Auto auto)	
			{
				ModelMap modelo = new ModelMap();
				 if(auto.getPatente() != null){
				modelo.put("mensaje", "Auto registrado correctamente ");
				servicioRegistro.registrarAuto(auto);
				
				
				
		}else {
			modelo.put("mensaje", "Error");
		}
		return new ModelAndView("redirect:/home", modelo);
			
	}
	
	
}
