package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;

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
		Cliente cliente = new Cliente();//Se crea un usuario vacio para mandarlo vacio para que el formulario se vaya llenando
		modelo.put("cliente", cliente);
		return new ModelAndView("registro", modelo); //Se le envia a la vista registro el modelo con el objeto usuario
	}
	@RequestMapping(path="/procesarRegistro", method=RequestMethod.POST)
	public ModelAndView procesarRegistroUduario(
			@ModelAttribute("cliente") Cliente cliente,
			@RequestParam(value="repassword", required=false) String repass //Se pone la respassword porque no existe como atributo en Usuario
			) {
		//Validar que la password sea igual a la repassword
		ModelMap modelo = new ModelMap();
		if(cliente.getPassword().equals(repass) 
				&& cliente.getNombre().length() > 1 
				&& cliente.getApellido().length() > 1
				/*&& usuario.getEmail() != servicioLogin.verificarUsuario(usuario).getEmail()*/) {
			modelo.put("mensaje", "Usuario registrado correctamente " + cliente.getEmail());
				servicioRegistro.agregarCliente(cliente);
				
		}else {
			modelo.put("mensaje", "Error. No coinciden las passwords");
		}
		return new ModelAndView("confirmacionRegistro", modelo);
			
	}
}
