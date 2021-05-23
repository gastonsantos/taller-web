package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Garage;

public interface ServicioGarage {
	List<Garage> consultarGarage();
	Boolean agregarGarage(Garage garage1);
	Boolean eliminarGarage(Long id);
}
