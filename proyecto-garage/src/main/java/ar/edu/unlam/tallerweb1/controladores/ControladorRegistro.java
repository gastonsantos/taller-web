package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroImpl;

@Controller
public class ControladorRegistro {
	
	private ServicioRegistro servicioRegistro;
//	private ServicioLogin servicioLogin;
	
	@Autowired
	public ControladorRegistro(ServicioRegistro servicioRegistro){
		this.servicioRegistro = servicioRegistro;
	}
	
	
	@RequestMapping("/mostrarRegistro")
	public 	ModelAndView registro() {
		ModelMap modelo = new ModelMap(); //Agrupa todo para mandarlo a vista
		Usuario usuario = new Usuario(); //Se crea un usuario vacio para mandarlo vacio para que el formulario se vaya llenando
		modelo.put("usuario", usuario);
		return new ModelAndView("registro", modelo); //Se le envia a la vista registro el modelo con el objeto usuario
	}
	@RequestMapping(path="/procesarRegistro", method=RequestMethod.POST)
	public ModelAndView procesarRegistroUduario(
			@ModelAttribute("usuario") Usuario usuario,
			@RequestParam(value="repassword", required=false) String repass //Se pone la respassword porque no existe como atributo en Usuario
			) {
		//Validar que la password sea igual a la repassword
		ModelMap modelo = new ModelMap();
		if(usuario.getPassword().equals(repass) 
				&& usuario.getNombre().length() > 1 
				&& usuario.getApellido().length() > 1
				/*&& usuario.getEmail() != servicioLogin.verificarUsuario(usuario).getEmail()*/) {
			modelo.put("mensaje", "Usuario registrado correctamente " + usuario.getEmail());
				servicioRegistro.agregarUsuario(usuario);
		}else {
			modelo.put("mensaje", "Error. No coinciden las passwords");
		}
		return new ModelAndView("confirmacionRegistro", modelo);
			
	}
}
