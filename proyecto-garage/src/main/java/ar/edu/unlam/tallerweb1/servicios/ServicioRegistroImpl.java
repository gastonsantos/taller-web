package ar.edu.unlam.tallerweb1.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Garage;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAuto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCliente;

@Service("servicioRegistro")
@Transactional
public class ServicioRegistroImpl implements ServicioRegistro{

	private RepositorioCliente servicioRegistro;

	@Autowired
	public ServicioRegistroImpl(RepositorioCliente servicioRegistro){
		this.servicioRegistro = servicioRegistro;
	}
	
	@Override
	public void agregarCliente(Cliente cliente) {
		
	 servicioRegistro.registrarCliente(cliente);
	 
	}


	@Override
	public void registrarAuto(Auto auto) {
		servicioRegistro.registrarAuto(auto);
		
	}

	@Override
	public void asignarAuto(Auto auto, Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarGarage(Garage garage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarLocalidad(Localidad localidad) {
		// TODO Auto-generated method stub
		
	}



	
	
}