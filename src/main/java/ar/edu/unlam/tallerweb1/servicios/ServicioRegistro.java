package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;

public interface ServicioRegistro {

	
	public abstract void agregarCliente(Cliente cliente);
	
	public abstract Cliente pagarReserva();
	
	public abstract Cliente elegirUnGaraje();
	
	public abstract Cliente elegirUnLugarParaEstacionar(); 
	
	public abstract void registrarAuto(Auto auto);
	
	public abstract void asignarAuto(Auto auto, Integer dni);
	
	public abstract void eliminarAuto(Auto auto);
	
	public abstract Auto consultarAuto(Auto auto);
	
	public abstract List<Auto> consultarListaAutosRegistrados();
}