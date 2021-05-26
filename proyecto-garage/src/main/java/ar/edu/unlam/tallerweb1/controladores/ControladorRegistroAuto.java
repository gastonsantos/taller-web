package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;

@Controller
public class ControladorRegistroAuto {

	private ServicioRegistro servicioRegistro;
	
	
	@Autowired
	public ControladorRegistroAuto(ServicioRegistro servicioRegistro){
		this.servicioRegistro = servicioRegistro;
	}
	
	
	@RequestMapping("/mostrarRegistroAuto/{id}")
	public 	ModelAndView registro(@PathVariable("id") Long id) {
		ModelMap modelo = new ModelMap(); //Agrupa todo para mandarlo a vista
		Auto auto = new Auto();//Se crea un usuario vacio para mandarlo vacio para que el formulario se vaya llenando
		List<Cliente> clienteBuscado = servicioRegistro.listaCliente();
		 for(Cliente cliente : clienteBuscado) {
			 if(cliente.getId().equals(id)) {
				modelo.addAttribute("cliente", servicioRegistro.consultarClientePorId(cliente));
				 modelo.put("auto", auto);
	
			 }
			 
		 }
		 return new ModelAndView("registroAuto", modelo); //Se le envia a la vista registro el modelo con el objeto usuario
	}
	@RequestMapping(path="/procesarRegistroAuto/{id}", method=RequestMethod.POST)
	public ModelAndView procesarRegistroAuto(
			@ModelAttribute("auto") Auto auto,
			@PathVariable("id") Long id){
		ModelMap modelo = new ModelMap();
		List<Cliente> clienteBuscado = servicioRegistro.listaCliente();		
		for(Cliente cliente : clienteBuscado) {
			 if(cliente.getId().equals(id)) {
				 modelo.addAttribute("cliente", servicioRegistro.consultarClientePorId(cliente));
				 auto.setCliente(cliente);
				 servicioRegistro.registrarAuto(auto);
				 modelo.put("auto", auto);
				 
			 }
		}
		
		return new ModelAndView("redirect:/home", modelo);
			
	}
	
	
}
