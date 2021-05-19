package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Plataforma;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioAgregarUsuario {
	
	Boolean agregarUsuario(Usuario user1);

	Boolean eliminarUsuario(Usuario user1);

}
