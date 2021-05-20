package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario consultarUsuario (Usuario usuario);
	
	Usuario verificarCorreo(Usuario usuario);
	
	void registrarUsuario(Usuario usuario);
	
	// El usuario podra pagar la reserva solo si eligio un garaje, lugar de estacionamiento y plan de alquiler.
	Usuario pagarReserva();
	
	// Se mostrara en un mapa todos los garajes que esten registrados en el sistema y el usuario  podra elegir uno de ellos.
	// Al seleccionarlo se desplegara una ventana donde se detalla el garaje como su nombre y planes de alquiler(por hora, semana o mes).
	Usuario elegirUnGaraje();
	
	// Se mostrara un mapa del estacionamiento donde se visualizara los lugares ocupados y libres.
	// A su vez se mostrara el horario en el que sera desocupado el lugar.
	Usuario elegirUnLugarParaEstacionar();
}
