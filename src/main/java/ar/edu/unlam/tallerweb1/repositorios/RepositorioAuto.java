package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Auto;

public interface RepositorioAuto {
	Auto consultarAuto(Auto auto);

	Boolean EliminarAutoDeCochera(Auto auto);

	Boolean agregarAutoACochera(Auto auto);

	Integer cantidadDeAutosEnCochera();
}
