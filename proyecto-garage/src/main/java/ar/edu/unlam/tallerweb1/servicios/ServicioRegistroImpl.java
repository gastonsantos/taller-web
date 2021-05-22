package ar.edu.unlam.tallerweb1.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
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
	public Cliente pagarReserva() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente elegirUnGaraje() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente elegirUnLugarParaEstacionar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarAuto(Auto auto) {
		
		servicioRegistro.registrarAuto(auto);
	}

	
	
}
