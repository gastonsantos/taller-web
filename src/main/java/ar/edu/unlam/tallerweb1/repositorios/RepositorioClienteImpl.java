package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.DuenioCochera;
import ar.edu.unlam.tallerweb1.modelo.Garage;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// implelemtacion del repositorio de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("repositorioCliente")
public class RepositorioClienteImpl implements RepositorioCliente{

	// Como todo repositorio maneja acciones de persistencia, normalmente estará inyectado el session factory de hibernate
	// el mismo está difinido en el archivo hibernateContext.xml
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioClienteImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
    
    @Override
	public void registrarCliente(Cliente cliente) {
		
		final Session session = sessionFactory.getCurrentSession();
		sessionFactory.getCurrentSession().save(cliente);
		/*session.save(cliente);
		List<Cliente> clientesBD = (List<Cliente>) session.getSession().createCriteria(Cliente.class)
				.list();*/
	}

	@Override
	public Cliente consultarCliente(Cliente cliente) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
		// uniqueResult da error si se encuentran más de un resultado en la busqueda.
		final Session session = sessionFactory.getCurrentSession();
		return (Cliente) session.createCriteria(Cliente.class)
				.add(Restrictions.eq("email", cliente.getEmail()))
				.add(Restrictions.eq("password", cliente.getPassword()))
				.uniqueResult();
	}
	

	@Override
	public Cliente verificarCorreo(Cliente cliente) {
		
		final Session session = sessionFactory.getCurrentSession();
		return (Cliente) session.createCriteria(Cliente.class)
				.add(Restrictions.eq("email", cliente.getEmail()))
				.uniqueResult();
	}
	
	@Override
	public Cliente pagarReserva() {
		
		return null;
	}


	@Override
	public Cliente elegirUnLugarParaEstacionar() {
		return null;
	}
//metodos Auto
	@Override
	public void registrarAuto(Auto auto) {
		
		final Session session = sessionFactory.getCurrentSession();
		session.save(auto);
	}
	
	@Override
	public Boolean EliminarAuto(Auto auto) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(auto);
		return true;
	}
	
	@Override
	public Auto consultarAuto(Auto auto) {
		final Session session = sessionFactory.getCurrentSession();
		return (Auto) session.createCriteria(Auto.class)
				.add(Restrictions.eq("patente", auto.getPatente()))
				.uniqueResult();
	}
	
	@Override 
	  public List<Auto> consultarListaAutosRegistrados() {
		
		  final Session session = sessionFactory.getCurrentSession();
		  
		   List<Auto> listaAutos = session.createCriteria(Auto.class)
				  .list();
				return listaAutos;  
	  }
	
	
	@Override
	public Cliente consultarPorDni(Cliente cliente) {
		
		final Session session = sessionFactory.getCurrentSession();
		return (Cliente) session.createCriteria(Cliente.class)
				.add(Restrictions.eq("dni", cliente.getDni()))
				.uniqueResult();
	}

	@Override
	public void asignarAuto(Auto auto, Integer dni) {
		final Session session = sessionFactory.getCurrentSession();
		
		Integer dniBuscado = dni;
		List<Cliente> clientesBD =  (List<Cliente>) session.getSession().createCriteria(Cliente.class)
				.list();
		Auto autos =   (Auto) session.getSession().createCriteria(Auto.class)
				.add(Restrictions.eq("patente", auto.getPatente()))
				.uniqueResult();
		
	
		for(Cliente cliente : (List<Cliente>) session.getSession().createCriteria(Cliente.class)
				.list()) {
			if(cliente.getDni().equals(dniBuscado)) {
				
				//cliente.setAuto(auto);
				auto.setCliente(cliente);
				session.save(auto);
				System.out.println(auto);
				
			}
		}
	}

	@Override
	public Cliente elegirUnGaraje() {
		// TODO Auto-generated method stub
		return null;
	}



	

	

	

	

	


}