package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Garage;

public interface ServicioGarage {
	List<Garage> consultarGarage();
	Boolean agregarGarage(Garage garage1);
	Boolean eliminarGarage(Long id);
	Boolean asignarAutoaGarage(Garage garage1, Auto auto1);
	Garage contultarUnGarage(Garage garage1);
	List<Auto> consultarAutosEnGarage(Garage garage1);
	Boolean sacarAutoDegarage(Auto auto, Garage garage);
}
