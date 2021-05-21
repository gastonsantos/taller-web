package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Garage;

public interface RepositorioGarage {

	Garage consultarGarage(Garage garage1);
	Boolean EliminarGarage(Garage garage1);
	Boolean agregarGarage(Garage garage1);
	
}
