package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioRegistro {

	public abstract void agregarUsuario(Usuario usuario);
	
	public abstract Usuario pagarReserva();
	
	public abstract Usuario elegirUnGaraje();
	
	public abstract Usuario elegirUnLugarParaEstacionar(); 
}
