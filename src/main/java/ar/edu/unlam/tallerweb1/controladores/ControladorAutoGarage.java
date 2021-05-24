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
	public String listaMia(Model modelo)  {
		
		modelo.addAttribute("garages", listaMia());

		return ("vistaAutoGarage");

	}

	private List<Garage> listaMia() {
		List<Garage> garages = new ArrayList<Garage>();

		for (int i = 1; i <= 10; i++) {
			Garage garage1 = new Garage();
			garage1.setCalle("Arieta");
			garage1.setCapacidad(5);
			garage1.setId(1L + i);
			garage1.setLocalidad("San Justo");
			garage1.setNombre("Pepe");
			garage1.setNumero(369);
			garage1.setPrecioEstadia(369.00);
			garage1.setPrecioHora(200.00);
			garage1.setPrecioMes(900.00);

			garages.add(garage1);
		}

		return garages;
	}

}