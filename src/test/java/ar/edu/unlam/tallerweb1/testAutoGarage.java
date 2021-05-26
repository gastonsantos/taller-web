
package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Garage;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioClienteImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioGarageImp;
import ar.edu.unlam.tallerweb1.servicios.ServicioGarageImplementacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroImpl;

public class testAutoGarage extends SpringTest {

	@Test
    @Transactional 
    @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }
	@Test
    @Transactional 
    @Rollback
	public void testQueUnAutoIngresanAUnGarage() {
		RepositorioGarageImp repo1 = new RepositorioGarageImp(sessionFactory);
		RepositorioClienteImpl repo2 = new RepositorioClienteImpl(sessionFactory);
		ServicioGarageImplementacion serv1 = new ServicioGarageImplementacion(repo1);
		ServicioRegistroImpl serv2 = new ServicioRegistroImpl(repo2);
		
		Garage garage1 = new Garage();
		garage1.setCapacidad(4);
		garage1.setPrecioHora(10.0);
		garage1.setNombre("Garage");
		serv1.agregarGarage(garage1);
		Auto auto1 = new Auto();
		auto1.setPatente("123ASD");
		Auto auto2 = new Auto();
		Auto auto3 = new Auto();
		auto2.setPatente("124BHG");
		auto3.setPatente("asd555");
		serv2.registrarAuto(auto1);
		serv2.registrarAuto(auto2);
		serv2.registrarAuto(auto3);
		assertTrue(serv1.asignarAutoaGarage(garage1, auto1));
		assertTrue(serv1.asignarAutoaGarage(garage1, auto2));
		assertTrue(serv1.asignarAutoaGarage(garage1, auto3));
		Integer ve=3;
		Integer vo = garage1.getContador();
		assertEquals(ve,vo);	
	}
	
	@Test
    @Transactional 
    @Rollback
	public void testQueCuentoAutosEnUnGarage() {
		RepositorioGarageImp repo1 = new RepositorioGarageImp(sessionFactory);
		RepositorioClienteImpl repo2 = new RepositorioClienteImpl(sessionFactory);
		ServicioGarageImplementacion serv1 = new ServicioGarageImplementacion(repo1);
		ServicioRegistroImpl serv2 = new ServicioRegistroImpl(repo2);
		
		Garage garage1 = new Garage();
		garage1.setCapacidad(4);
		garage1.setPrecioHora(10.0);
		garage1.setNombre("Garage");
		serv1.agregarGarage(garage1);
		Auto auto1 = new Auto();
		auto1.setPatente("123ASD");
		Auto auto2 = new Auto();
		Auto auto3 = new Auto();
		auto2.setPatente("124BHG");
		auto3.setPatente("asd555");
		serv2.registrarAuto(auto1);
		serv2.registrarAuto(auto2);
		serv2.registrarAuto(auto3);
		assertTrue(serv1.asignarAutoaGarage(garage1, auto1));
		assertTrue(serv1.asignarAutoaGarage(garage1, auto2));
		assertTrue(serv1.asignarAutoaGarage(garage1, auto3));
		Integer cont = serv1.consultarAutosEnGarage(garage1).size();
		Integer ve=3;
		//Integer vo = garage1.getContador();
		assertEquals(ve,cont);	
	}
	@Test
    @Transactional 
    @Rollback
	public void testQueSeVaAutoDeUnGarage() {
		RepositorioGarageImp repo1 = new RepositorioGarageImp(sessionFactory);
		RepositorioClienteImpl repo2 = new RepositorioClienteImpl(sessionFactory);
		ServicioGarageImplementacion serv1 = new ServicioGarageImplementacion(repo1);
		ServicioRegistroImpl serv2 = new ServicioRegistroImpl(repo2);
		
		Garage garage1 = new Garage();
		garage1.setCapacidad(4);
		garage1.setPrecioHora(10.0);
		garage1.setNombre("Garage");
		serv1.agregarGarage(garage1);
		Auto auto1 = new Auto();
		auto1.setPatente("123ASD");
		Auto auto2 = new Auto();
		Auto auto3 = new Auto();
		auto2.setPatente("124BHG");
		auto3.setPatente("asd555");
		serv2.registrarAuto(auto1);
		serv2.registrarAuto(auto2);
		serv2.registrarAuto(auto3);
		assertTrue(serv1.asignarAutoaGarage(garage1, auto1));
		assertTrue(serv1.asignarAutoaGarage(garage1, auto2));
		assertTrue(serv1.asignarAutoaGarage(garage1, auto3));
		assertTrue(serv1.sacarAutoDegarage( auto3,  garage1));
		Integer vo=serv1.consultarAutosEnGarage(garage1).size();
		
		Integer ve=2;
		//Integer vo = garage1.getContador();
		assertEquals(ve,vo);	
	}
	
	@Test
    @Transactional 
    @Rollback
	public void testQueNoPuedeIngresarAutoAGaragePorQueEstaLLeno() {
		RepositorioGarageImp repo1 = new RepositorioGarageImp(sessionFactory);
		RepositorioClienteImpl repo2 = new RepositorioClienteImpl(sessionFactory);
		ServicioGarageImplementacion serv1 = new ServicioGarageImplementacion(repo1);
		ServicioRegistroImpl serv2 = new ServicioRegistroImpl(repo2);
		
		Garage garage1 = new Garage();
		garage1.setCapacidad(2);
		garage1.setPrecioHora(10.0);
		garage1.setNombre("Garage");
		serv1.agregarGarage(garage1);
		Auto auto1 = new Auto();
		auto1.setPatente("123ASD");
		Auto auto2 = new Auto();
		Auto auto3 = new Auto();
		auto2.setPatente("124BHG");
		auto3.setPatente("asd555");
		serv2.registrarAuto(auto1);
		serv2.registrarAuto(auto2);
		serv2.registrarAuto(auto3);
		assertTrue(serv1.asignarAutoaGarage(garage1, auto1));
		assertTrue(serv1.asignarAutoaGarage(garage1, auto2));
		assertFalse(serv1.asignarAutoaGarage(garage1, auto3));
		Integer cont = serv1.consultarAutosEnGarage(garage1).size();
		Integer ve=2;
		//Integer vo = garage1.getContador();
		assertEquals(ve,cont);	
	}
	

}
