package ar.edu.unlam.tallerweb1.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Garage;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioGarage;
@Service("ServicioGarage")
@Transactional
public class ServicioGarageImplementacion implements ServicioGarage {

	private RepositorioGarage repoGarage;
	
	@Autowired
	public ServicioGarageImplementacion(RepositorioGarage repoGarage) {
		this.repoGarage = repoGarage;
	}
		
	public Boolean agregarGarage(Garage garage1) {
		return repoGarage.agregarGarage(garage1);
	}
	
	public Boolean eliminarGarage(Garage garage1) {
		return repoGarage.EliminarGarage(garage1);
	}
	
	public Garage consultarGarage(Garage garage1) {
		
		return repoGarage.consultarGarage(garage1);
	}
	
	
	public Boolean modificarGarage(Garage garage1) {
		return null;
	}
	
	public Garage buscarPorLocalidad(Garage garage1) {
		return null;
	}
	public Garage buscarPorMenorPrecio(Garage garage1) {
		return null;
	}
	
	
	
}
