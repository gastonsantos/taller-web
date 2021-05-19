package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;

@Service("servicioCalculadora")
public class ServicioCalculadoraImp implements ServicioCalculadora{
	
	private Double resultado;
	@Override
	public Double sumar(Double operando1, Double operando2) {
		resultado = operando1 + operando2;
		return resultado;
	}

	@Override
	public Double restar(Double operando1, Double operando2) {
		resultado = operando1 - operando2;
		return resultado;
	}

	@Override
	public Double multiplicar(Double operando1, Double operando2) {
		resultado = operando1 * operando2;
		return resultado;
	}

	@Override
	public Double dividir(Double operando1, Double operando2) {
		resultado = operando1 / operando2;
		return resultado;
	}
	
	// override de dividir
	// public double di
	//	en el primer if hacer un throw new exception ("no se puede divir por 0")

}
