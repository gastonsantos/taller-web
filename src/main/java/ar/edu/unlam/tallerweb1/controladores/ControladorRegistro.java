package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Controller
public class ControladorRegistro {

	@RequestMapping("/registro")
	public ModelAndView registro() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		
		return new ModelAndView("registro", modelo);
	}
	
	@RequestMapping(path="/procesarRegistro", method=RequestMethod.POST)
	public ModelAndView procesarRegistroUsuario(
			
			@ModelAttribute("usuario")Usuario usuario, 
			@RequestParam(value="repassword", required=false)String repass
			) {
		//validar password con repassword
		ModelMap modelo = new ModelMap();
		if(usuario.getPassword().equals(repass)) {
			//Guardo den la base de datos
				modelo.put("mensaje", "usuario registrado correctamente "+usuario.getEmail());
		}else {
			modelo.put("mensaje", "error no coincide las pass");
		}
		
				
		return new ModelAndView("confirmacionRegistro", modelo);
		
	}
	
	
	
	
	
}
