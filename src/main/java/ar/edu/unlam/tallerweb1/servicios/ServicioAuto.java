package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Auto;

public interface ServicioAuto {
	Auto consultarAuto(Auto auto);

	Boolean EliminarAutoDeCochera(String patente);

	Boolean agregarAutoACochera(Auto auto);

	Integer cantidadDeAutosEnCochera();
}
