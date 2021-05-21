package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Garage;

public interface ServicioGarage {
	Garage consultarGarage(Garage garage1);
	Boolean agregarGarage(Garage garage1);
	Boolean eliminarGarage(Garage garage1);
}
