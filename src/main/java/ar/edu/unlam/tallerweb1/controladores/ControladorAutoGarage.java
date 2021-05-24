package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Garage;

import ar.edu.unlam.tallerweb1.servicios.ServicioGarage;

@Controller
public class ControladorAutoGarage {

	private ServicioGarage servicioGarage;

	@Autowired
	public ControladorAutoGarage(ServicioGarage servicioGarage) {

		this.servicioGarage = servicioGarage;
	}

	@RequestMapping("/listaAutoGarage")
	public String Lista(Model modelo){
		modelo.addAttribute("garages", servicioGarage.consultarGarage());
		return ("vistaAutoGarage");
	}



}