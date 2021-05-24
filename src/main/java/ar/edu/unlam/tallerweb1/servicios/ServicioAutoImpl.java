package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAuto;

public class ServicioAutoImpl {

	private RepositorioAuto repoAuto;

	@Autowired
	public ServicioAutoImpl(RepositorioAuto repoAuto) {

		this.repoAuto = repoAuto;
	}

	public Boolean agregarAutoACochera(Auto auto) {
		return repoAuto.agregarAutoACochera(auto);
	}

	public Boolean eliminarAutoDeCochera(Auto auto) {
		return repoAuto.EliminarAutoDeCochera(auto);
	}

	public Auto consultarAuto(Auto auto) {

		return repoAuto.consultarAuto(auto);
	}
}
