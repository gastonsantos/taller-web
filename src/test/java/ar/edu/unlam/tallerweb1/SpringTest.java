package ar.edu.unlam.tallerweb1;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// Se indica que los test que hereden de esta clase corran con el runner de junit para spring.
@RunWith(SpringJUnit4ClassRunner.class)
// Se indica
@ContextConfiguration(locations = {"/test-applicationContext.xml"})
// Clase base para los test que se pretende que se corran dentro del contexto de spring
public abstract class SpringTest {

    // Tiene inyectado el session factory para que los test que hereden de �ste tengan acceso al mismo
    @Inject
	protected SessionFactory sessionFactory; //se encarga de interactuar entre la aplicacion y la base de datos. Genera sesiones para interactuar. 

    // Metodo para obtener una sesion de base de datos
    protected Session session() {
        return this.sessionFactory.getCurrentSession(); //Devuelve un objeto de tipo Sesion
    }

}