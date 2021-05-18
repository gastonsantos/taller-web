package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;

@Service
public class ServicioCalculadoraImplementacion  implements ServicioCalculadora{
	
	@Override
	public Integer sumar(Integer operando1, Integer operando2) {
		return operando1+operando2;
	}

	@Override
	public Integer restar(Integer operando1, Integer operando2) {
		// TODO Auto-generated method stub
		return operando1-operando2;
	}

	@Override
	public Integer multiplicar(Integer operando1, Integer operando2) {
		
		return operando1*operando2;
	}

	@Override
	public Integer dividir(Integer operando1, Integer operando2) throws Exception {
		if(operando1==0) {
			throw new Exception ("No se puede dividir po cero");
		}else {
			return operando1/operando2;
		}
		
		
	}
	
	
}
