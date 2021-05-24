package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Garage;
import ar.edu.unlam.tallerweb1.modelo.Localidad;

public interface ServicioRegistro {

	
	public abstract void agregarCliente(Cliente cliente);
	
	public abstract void registrarAuto(Auto auto);
	
	public abstract void asignarAuto(Auto auto, Cliente cliente);
	
	public abstract void registrarGarage(Garage garage);
	
	public abstract void registrarLocalidad(Localidad localidad);
}
