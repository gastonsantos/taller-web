package ar.edu.unlam.tallerweb1.servicios;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Garage;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service
public class ServicioAgregarUsuarioImplementacion implements ServicioAgregarUsuario{
	private HashSet<Usuario> usuario;

	@Override
	public Boolean agregarUsuario(Usuario user1) {
		
		return usuario.add(user1);
	}
	
	@Override
	public Boolean eliminarUsuario(Usuario user1) {
		return usuario.remove(user1);
	}
	
	
	
	
	
	
	
	
}
