package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Auto;
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
	
	public Boolean eliminarGarage(Long id) {
		return repoGarage.EliminarGarage(id);
	}
	
	public List<Garage> consultarGarage() {
		
		return repoGarage.consultarGarage();
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

	@Override
	public Boolean asignarAutoaGarage(Garage garage1, Auto auto1) {
		
		return repoGarage.asignarAutoaGarage(garage1, auto1);
	}

	@Override
	public Garage contultarUnGarage(Garage garage1) {
		
		return repoGarage.contultarUnGarage(garage1);
	}

	@Override
	public List<Auto> consultarAutosEnGarage(Garage garage1) {
		
		return repoGarage.consultarAutosEnGarage(garage1);
	}

	@Override
	public Boolean sacarAutoDegarage(Auto auto, Garage garage) {
		
		return repoGarage.sacarAutoDegarage(auto, garage);
	}
	
	
	
}
