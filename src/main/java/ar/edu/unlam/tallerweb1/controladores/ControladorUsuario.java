package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioImpl;

@Controller

public class ControladorUsuario {

	
	@Autowired
	private RepositorioUsuarioImpl uc;
	

	
	@RequestMapping("/formularioGarage")
	public ModelAndView mostrarFormularioGaraga() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("CrearUsuarioGarage", modelo);
	}
	
	
	
	@RequestMapping(path="ConfirmarRegistro", method = RequestMethod.POST)
	public ModelAndView datos(
			@ModelAttribute("usuairo") Usuario usuario,
			@RequestParam(value="nombre", required=false) String name,
			@RequestParam(value="apellido", required=false) String surname,
			@RequestParam(value="rol", required=false) String rol,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="password", required=false) String pass,
			@RequestParam(value="repassword", required=false) String repass
			) {
			ModelMap modelo = new ModelMap();
			modelo.put("nombre", name);
			modelo.put("apellido", surname);
			modelo.put("rol", rol);
			modelo.put("email", email);
			modelo.put("password", pass);
			
			
			if(usuario.getPassword().equals(repass)) {
				//Lo guardaria en la base de datos
				uc.guardarUsuario(usuario);
				modelo.put("mensaje", "Usuario Agregado");
				
				
			}else {
				modelo.put("mensaje", "Password no son iguales");
				
			}
		
			return new ModelAndView("ConfirmarRegistroUsuarioGarage", modelo);
		}
	
	
	
	
	
	
	
	
		
		
	}
	
	
	
	
	
	
	
