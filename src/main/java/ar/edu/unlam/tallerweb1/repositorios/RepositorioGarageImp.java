package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Garage;

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
	

	

	  

}