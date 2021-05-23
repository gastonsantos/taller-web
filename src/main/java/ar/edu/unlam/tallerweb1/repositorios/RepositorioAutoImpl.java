package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Auto;

@Repository("repositorioAuto")
public class RepositorioAutoImpl implements RepositorioAuto {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioAutoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Auto consultarAuto(Auto auto) {

		final Session session = sessionFactory.getCurrentSession();
		return (Auto) session.createCriteria(Auto.class).add(Restrictions.eq("patente", auto.getPatente()))
				.uniqueResult();
	}

	@Override
	public Boolean agregarAutoACochera(Auto auto) {

		final Session session = sessionFactory.getCurrentSession();

		sessionFactory.getCurrentSession().save(auto);
		return true;
	}

	@Override
	public Boolean EliminarAutoDeCochera(Auto auto) {
		final Session session = sessionFactory.getCurrentSession();

		sessionFactory.getCurrentSession().delete(auto);

		return null;
	}

	@Override
	public Integer cantidadDeAutosEnCochera() {
		// TODO Auto-generated method stub
		return null;
	}

}
