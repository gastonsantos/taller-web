package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;

public interface RepositorioAuto {

	public void registrarAuto(Auto auto);
	
	public Auto consultarAuto(Auto auto);
	
	
}
