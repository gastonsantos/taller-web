package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Cliente;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Cliente consultarCliente(Cliente cliente);
	
	Cliente verificarCliente(Cliente cliente);
	
	Cliente consultarClientePorDni(Cliente cliente);
}
