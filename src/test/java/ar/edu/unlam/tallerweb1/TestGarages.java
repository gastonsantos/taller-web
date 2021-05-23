package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.modelo.Garage;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioGarageImp;
import ar.edu.unlam.tallerweb1.servicios.ServicioGarageImplementacion;



public class TestGarages extends SpringTest{
	@Test
    @Transactional 
    @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }
	
	@Test
	@Transactional
	@Rollback
	public void testQueAgregoGarageAbd() {
		Garage g1 = new Garage();
		Garage g2 = new Garage();
		RepositorioGarageImp repo1 = new RepositorioGarageImp(sessionFactory);
		ServicioGarageImplementacion serv1 = new ServicioGarageImplementacion(repo1);	
		g1.setCalle("Echeverria");
		g1.setCapacidad(40);
		g1.setLocalidad("San Justo");
		g1.setNombre("Las Palmas");
		g1.setNumero(2450);
		g1.setPrecioHora(100.0);
		g1.setPrecioEstadia(400.0);
		g1.setPrecioMes(4000.0);
		g2.setCalle("Echeverria");
		g2.setCapacidad(40);
		g2.setLocalidad("San Justo");
		g2.setNombre("Las Palmas");
		g2.setNumero(2450);
		g2.setPrecioHora(100.0);
		g2.setPrecioEstadia(400.0);
		g2.setPrecioMes(4000.0);
		
		
		//Agrego el garage
		serv1.agregarGarage(g1);
		serv1.agregarGarage(g2);
		List<Garage> GarageBd= (List<Garage>) session().getSession().createCriteria(Garage.class)
				.list();
		assertEquals(GarageBd.size(),2);
		
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueEliminoGarageAbd() {
		Garage g1 = new Garage();
		Garage g2 = new Garage();
		RepositorioGarageImp repo1 = new RepositorioGarageImp(sessionFactory);
		ServicioGarageImplementacion serv1 = new ServicioGarageImplementacion(repo1);	
		g1.setCalle("Echeverria");
		g1.setCapacidad(40);
		g1.setLocalidad("San Justo");
		g1.setNombre("Las Palmas");
		g1.setNumero(2450);
		g1.setPrecioHora(100.0);
		g1.setPrecioEstadia(400.0);
		g1.setPrecioMes(4000.0);
		g2.setCalle("Echeverria");
		g2.setCapacidad(40);
		g2.setLocalidad("San Justo");
		g2.setNombre("Las Palmas");
		g2.setNumero(2450);
		g2.setPrecioHora(100.0);
		g2.setPrecioEstadia(400.0);
		g2.setPrecioMes(4000.0);
		//Agrego el garage
		serv1.agregarGarage(g1);
		serv1.agregarGarage(g2);
		//Elimino
		serv1.eliminarGarage(g1.getId());
		List<Garage> GarageBd= (List<Garage>) session().getSession().createCriteria(Garage.class)
				.list();
		assertEquals(GarageBd.size(),1);

	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueMuestroListaGarageDeBd() {
		Garage g1 = new Garage();
		Garage g2 = new Garage();
		RepositorioGarageImp repo1 = new RepositorioGarageImp(sessionFactory);
		ServicioGarageImplementacion serv1 = new ServicioGarageImplementacion(repo1);	
		g1.setCalle("Echeverria");
		g1.setCapacidad(40);
		g1.setLocalidad("San Justo");
		g1.setNombre("Las Palmas");
		g1.setNumero(2450);
		g1.setPrecioHora(100.0);
		g1.setPrecioEstadia(400.0);
		g1.setPrecioMes(4000.0);
		g2.setCalle("Echeverria");
		g2.setCapacidad(40);
		g2.setLocalidad("San Justo");
		g2.setNombre("Las Palmas");
		g2.setNumero(2450);
		g2.setPrecioHora(100.0);
		g2.setPrecioEstadia(400.0);
		g2.setPrecioMes(4000.0);
		//Agrego el garage
		serv1.agregarGarage(g1);
		serv1.agregarGarage(g2);
		
		//List<Garage> GarageBd= serv1.consultarGarage();
		assertEquals(serv1.consultarGarage().size(),2);

	}
	
	
	@Test
	@Transactional
	@Rollback
	public void testQueEncuentreGaragePorPrecioHora() {
		
		Garage g1 = new Garage();
		Garage g2 = new Garage();
		RepositorioGarageImp repo1 = new RepositorioGarageImp(sessionFactory);
		ServicioGarageImplementacion serv1 = new ServicioGarageImplementacion(repo1);	
		g1.setCalle("Echeverria");
		g1.setCapacidad(80);
		g1.setLocalidad("Banfield");
		g1.setNombre("Los Pinos");
		g1.setNumero(2360);
		g1.setPrecioHora(200.0);
		g1.setPrecioEstadia(800.0);
		g1.setPrecioMes(8000.0);
		
		g2.setCalle("Echeverria");
		g2.setCapacidad(40);
		g2.setLocalidad("San Justo");
		g2.setNombre("Las Palmas");
		g2.setNumero(2450);
		g2.setPrecioHora(100.0);
		g2.setPrecioEstadia(400.0);
		g2.setPrecioMes(4000.0);
		//Agrego el garage
		serv1.agregarGarage(g1);
		serv1.agregarGarage(g2);

		List <Garage> garageEncontrado = (List<Garage>) serv1.buscarPorPrecioHora(20.00, 150.00);
		
		assertEquals(garageEncontrado.size(), 1);
		assertEquals(0, garageEncontrado.indexOf(g2));
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueEncuentreGaragePorPrecioMes() {
		Garage g1 = new Garage();
		Garage g2 = new Garage();
		RepositorioGarageImp repo1 = new RepositorioGarageImp(sessionFactory);
		ServicioGarageImplementacion serv1 = new ServicioGarageImplementacion(repo1);	
		g1.setCalle("Echeverria");
		g1.setCapacidad(80);
		g1.setLocalidad("Banfield");
		g1.setNombre("Los Pinos");
		g1.setNumero(2360);
		g1.setPrecioHora(200.0);
		g1.setPrecioEstadia(800.0);
		g1.setPrecioMes(8000.0);
		
		g2.setCalle("Echeverria");
		g2.setCapacidad(40);
		g2.setLocalidad("San Justo");
		g2.setNombre("Las Palmas");
		g2.setNumero(2450);
		g2.setPrecioHora(100.0);
		g2.setPrecioEstadia(400.0);
		g2.setPrecioMes(4000.0);
		//Agrego el garage
		serv1.agregarGarage(g1);
		serv1.agregarGarage(g2);

		List <Garage> garageEncontrado = (List<Garage>) serv1.buscarPorPrecioMes(5000.00, 9000.00);
		
		assertEquals(garageEncontrado.size(), 1);
		assertEquals(0, garageEncontrado.indexOf(g1));
		
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueEncuentreGaragePorPrecioEstadia() {
		Garage g1 = new Garage();
		Garage g2 = new Garage();
		RepositorioGarageImp repo1 = new RepositorioGarageImp(sessionFactory);
		ServicioGarageImplementacion serv1 = new ServicioGarageImplementacion(repo1);	
		g1.setCalle("Echeverria");
		g1.setCapacidad(80);
		g1.setLocalidad("Banfield");
		g1.setNombre("Los Pinos");
		g1.setNumero(2360);
		g1.setPrecioHora(200.0);
		g1.setPrecioEstadia(800.0);
		g1.setPrecioMes(8000.0);
		
		g2.setCalle("Echeverria");
		g2.setCapacidad(40);
		g2.setLocalidad("San Justo");
		g2.setNombre("Las Palmas");
		g2.setNumero(2450);
		g2.setPrecioHora(100.0);
		g2.setPrecioEstadia(400.0);
		g2.setPrecioMes(4000.0);

		serv1.agregarGarage(g1);
		serv1.agregarGarage(g2);

		List <Garage> garageEncontrado = (List<Garage>) serv1.buscarPorPrecioEstadia(200.00, 400.00);
		
		assertEquals(garageEncontrado.size(), 1);
		assertEquals(0, garageEncontrado.indexOf(g2));
		
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueEncuentreGaragePorLocalidad() {
		Garage g1 = new Garage();
		Garage g2 = new Garage();
		RepositorioGarageImp repo1 = new RepositorioGarageImp(sessionFactory);
		ServicioGarageImplementacion serv1 = new ServicioGarageImplementacion(repo1);	
		g1.setCalle("Echeverria");
		g1.setCapacidad(80);
		g1.setLocalidad("Banfield");
		g1.setNombre("Los Pinos");
		g1.setNumero(2360);
		g1.setPrecioHora(200.0);
		g1.setPrecioEstadia(800.0);
		g1.setPrecioMes(8000.0);
		
		g2.setCalle("Echeverria");
		g2.setCapacidad(40);
		g2.setLocalidad("San Justo");
		g2.setNombre("Las Palmas");
		g2.setNumero(2450);
		g2.setPrecioHora(100.0);
		g2.setPrecioEstadia(400.0);
		g2.setPrecioMes(4000.0);

		serv1.agregarGarage(g1);
		serv1.agregarGarage(g2);

		List <Garage> garageEncontrado = (List<Garage>) serv1.buscarPorLocalidad(g2);
		
		assertEquals(garageEncontrado.size(), 1);
		assertEquals(0, garageEncontrado.indexOf(g2));
		
	}
	
	
	
	
}
