package ar.edu.unlam.tallerweb1.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service("servicioRegistro")
@Transactional
public class ServicioRegistroImpl implements ServicioRegistro{

	private RepositorioUsuario servicioRegistro;

	@Autowired
	public ServicioRegistroImpl(RepositorioUsuario servicioRegistro){
		this.servicioRegistro = servicioRegistro;
	}
	
	@Override
	public void agregarUsuario(Usuario usuario) {
		
	 servicioRegistro.registrarUsuario(usuario);
	}

	@Override
	public Usuario pagarReserva() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario elegirUnGaraje() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario elegirUnLugarParaEstacionar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}