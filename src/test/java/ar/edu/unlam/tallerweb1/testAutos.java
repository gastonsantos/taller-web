package ar.edu.unlam.tallerweb1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioClienteImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioLoginImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroImpl;

public class testAutos extends SpringTest{

	@Inject
	private SessionFactory sessionFactory;
	
	@Test
    @Transactional 
    @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }
	
	@Test
	@Transactional
	@Rollback
	public void queSePuedaRegistrarUnAuto() {
		
		RepositorioClienteImpl repo = new RepositorioClienteImpl(sessionFactory);
		ServicioRegistroImpl reg = new ServicioRegistroImpl(repo);
		ServicioLoginImpl log = new ServicioLoginImpl(repo);
		
		Cliente usuario1 = new Cliente();
		Cliente usuario2 = new Cliente();
		usuario1.setNombre("pepe");
		usuario1.setApellido("rodriguez");
		usuario1.setEmail("pepito@hotmail.com");
		usuario1.setPassword("123");
		usuario1.setDni(1234564);
		
		usuario2.setNombre("jorge");
		usuario2.setApellido("asd");
		usuario2.setEmail("jorge@hotmail.com");
		usuario2.setPassword("321");
		usuario2.setDni(42671687);
		
		Auto auto1 = new Auto();
		Auto auto2 = new Auto();
		
		auto1.setPatente("asd123");
		
		auto2.setPatente("wtf321");
		usuario1.setAuto(auto1);
		usuario1.setAuto(auto2);
		
		reg.agregarCliente(usuario2);
		reg.registrarAuto(auto1);
		reg.agregarCliente(usuario1);
		reg.registrarAuto(auto2);
		
		List<Auto> autosBD =  (List<Auto>) session().getSession().createCriteria(Auto.class)
				.list();

		assertEquals(autosBD.size(), 2); 
		
		System.out.println(autosBD);
		
	}
	
	@Test
	@Transactional
	@Rollback
	public void queSePuedaAsignarUnAutoAUnClienteDeLaBD() {
		
		RepositorioClienteImpl repo = new RepositorioClienteImpl(sessionFactory);
		ServicioRegistroImpl reg = new ServicioRegistroImpl(repo);
		ServicioLoginImpl log = new ServicioLoginImpl(repo);
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		
		cliente1.setDni(123456);
		cliente2.setDni(654321);
		cliente3.setDni(789456);
		
		reg.agregarCliente(cliente1);
		reg.agregarCliente(cliente2);
		reg.agregarCliente(cliente3);
		
		Auto auto = new Auto();
		
		auto.setPatente("asd123");
		
		reg.registrarAuto(auto);
		
		Integer dniBuscado = 789456;
		
		// Se guardan los clientes en la base de datos en forma de lista
		List<Cliente> clientesBD =  (List<Cliente>) session().getSession().createCriteria(Cliente.class)
				.list();
		
		//Recorre la liste y busca mediant el dni el cliente al cual asignarle el auto
		for(Cliente cliente : clientesBD) {
			if(cliente.getDni().equals(dniBuscado)) {
				//auto.setCliente(cliente);
				cliente.setAuto(auto);
				System.out.println(auto);
			}
		}
		
	}
    
}