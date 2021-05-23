package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Garage;

public interface RepositorioGarage {

	List<Garage> consultarGarage();
	Boolean EliminarGarage(Long id);
	Boolean agregarGarage(Garage garage1);
	
}
