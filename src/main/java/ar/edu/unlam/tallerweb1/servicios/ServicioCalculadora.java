package ar.edu.unlam.tallerweb1.servicios;

public interface ServicioCalculadora {

	
	Integer sumar(Integer operando1, Integer operando2);
	Integer restar(Integer operando1, Integer operando2);
	Integer multiplicar(Integer operando1, Integer operando2);
	Integer dividir(Integer operando1, Integer operando2) throws Exception;
}
