package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashSet;

public class Buscar {
	private HashSet<Garage> garages;
	
	public HashSet<Garage> listadoDeGarage(String ubicacion){
		
		HashSet<Garage> listadoDeGarages = new HashSet<Garage>();
		for(Garage e : garages) {
			if(ubicacion == e.getLocalidad()) {
				listadoDeGarages.add(e);
			}
		}
		return listadoDeGarages;
		
	}
	
	public HashSet<Garage> listadoDeGaragePorPrecioMasBarato(Integer valorHora){
		
		HashSet<Garage> listadoDeGarages = new HashSet<Garage>();
		for(Garage e : garages) {
			if(valorHora <= e.getPrecioHora()) {
				listadoDeGarages.add(e);
			}
		}
		return listadoDeGarages;
		
	}
	public HashSet<Garage> listadoDeGaragePorMesMasBarato(Integer valorMes){
		
		HashSet<Garage> listadoDeGarages = new HashSet<Garage>();
		for(Garage e : garages) {
			if(valorMes <= e.getPrecioMes()) {
				listadoDeGarages.add(e);
			}
		}
		return listadoDeGarages;
		
	}
public HashSet<Garage> listadoDeGarageConLugar(){
		
		HashSet<Garage> listadoDeGarages = new HashSet<Garage>();
		for(Garage e : garages) {
			if(e.getCapacidad()> garages.size()) {
				listadoDeGarages.add(e);
			}
		}
		return listadoDeGarages;
		
	}
	
	
	

	
	

}
