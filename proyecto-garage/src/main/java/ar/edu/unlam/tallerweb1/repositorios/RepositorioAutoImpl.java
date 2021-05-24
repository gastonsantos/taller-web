package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.servicios.ServicioLoginImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroImpl;

@Repository("repositorioAuto")
public class RepositorioAutoImpl implements RepositorioAuto{
	
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioAutoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	
	
	@Override
	public Auto consultarAuto(Auto auto) {
		
		final Session session = sessionFactory.getCurrentSession();
		return (Auto) session.createCriteria(Auto.class)
				.add(Restrictions.eq("patente", auto.getPatente()))
				.uniqueResult();
	}





	@Override
	public void registrarAuto(Auto auto) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Boolean asignarAutoACliente(Auto auto, Cliente cliente) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		RepositorioClienteImpl repo = new RepositorioClienteImpl(sessionFactory);
		ServicioLoginImpl serv = new ServicioLoginImpl(repo);
		
		Boolean agregado = false;
		
		Auto autoBuscado = consultarAuto(auto);
		Cliente clienteBuscado = serv.consultarClientePorDni(cliente);
		
		if(autoBuscado != null && clienteBuscado != null) {
			agregado = true;
		}else {
			agregado = false;
		}
			return agregado;
	}

	
}
