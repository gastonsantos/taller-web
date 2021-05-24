package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Garage;
import ar.edu.unlam.tallerweb1.servicios.ServicioGarageImplementacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroImpl;

@Repository("repositorioGarage")
public class RepositorioGarageImp implements RepositorioGarage {
	
	private SessionFactory sessionFactory;
	
	  @Autowired
	  public RepositorioGarageImp(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
	 
	@Override 
	  public List<Garage> consultarGarage() {
		
		  final Session session = sessionFactory.getCurrentSession();
		  
		   List<Garage> listaGarage = session.createCriteria(Garage.class)
				  //.add(Restrictions.eq("nombre", garage1.getNombre()))
				  .list();
				return listaGarage;  
	  }
	
	
	
		@Override
		public Garage  contultarUnGarage(Garage garage1) {
			final Session session = sessionFactory.getCurrentSession();
			return (Garage) session.createCriteria(Garage.class)
					.add(Restrictions.eq("id",garage1.getId()))
					.uniqueResult();
	
			
		}
	@Override 
	public Boolean agregarGarage(Garage garage1) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		sessionFactory.getCurrentSession().save(garage1);
		return true;
	}

	@Override
	public Boolean EliminarGarage(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		Garage garage1 = (Garage) session.createCriteria(Garage.class)
				.add(Restrictions.eq("id",id))
				.uniqueResult();
		sessionFactory.getCurrentSession().delete(garage1);
		return true;
	}

	@Override
	public Boolean asignarAutoaGarage(Garage garage1, Auto auto1) {
		RepositorioClienteImpl repo2 = new RepositorioClienteImpl(sessionFactory);
		ServicioRegistroImpl serv2 = new ServicioRegistroImpl(repo2);
		
		final Session session = sessionFactory.getCurrentSession();
		
		Boolean agrego= false;
		Garage g2= contultarUnGarage( garage1);
		Auto a2 = serv2.consultarAuto(auto1) ;
		if(g2!=null && a2 !=null && g2.getCapacidad()>g2.getContador()) {
			a2.setGarage(g2);
			g2.setContador(g2.getContador()+1);
			agrego = true;	
		}else {
			agrego= false;
			
		}
		return agrego;

	}
	
	
	
	@Override
	public List<Auto> consultarAutosEnGarage(Garage garage1){
		final Session session = sessionFactory.getCurrentSession();
		List<Auto> lista= session.createCriteria(Auto.class)
							.createAlias("garage", "garage")
							.list();
		return lista;
	}
	@Override
	public Boolean BuscarAutoEnGarage(Auto auto1, Garage garage1) {
		RepositorioClienteImpl repo2 = new RepositorioClienteImpl(sessionFactory);
		ServicioRegistroImpl serv2 = new ServicioRegistroImpl(repo2);
		
		Garage g2= contultarUnGarage( garage1);
		Auto a2 = serv2.consultarAuto(auto1) ;
		
		
		return true;
	}

	@Override
	public Boolean sacarAutoDegarage(Auto auto, Garage garage) {
		//List<Auto> lista = consultarAutosEnGarage(garage);
		
		RepositorioClienteImpl repo2 = new RepositorioClienteImpl(sessionFactory);
		ServicioRegistroImpl serv2 = new ServicioRegistroImpl(repo2);
		
		final Session session = sessionFactory.getCurrentSession();
		Boolean salio= false;
		Garage g2= contultarUnGarage( garage);
		Auto a2 = serv2.consultarAuto(auto) ;
		if(g2!=null && a2 !=null) {
			a2.setGarage(null);
			g2.setContador(g2.getContador()-1);
			salio = true;	
		}else {
			salio= false;
			
		}
		return salio;

	}
		
		
	/*	String pat = auto.getPatente();
		Boolean borro= false;
		for (Auto e: consultarAutosEnGarage(garage)) {
			if(e.getPatente().equals(pat)) {
				consultarAutosEnGarage(garage).remove(e);
				borro= true;
				break;
			}else {
			borro= false;
		}
		
		}
	  return borro;
	}
	*/
}

