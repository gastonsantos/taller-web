package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.mysql.cj.xdevapi.SessionFactory;

import ar.edu.unlam.tallerweb1.controladores.ControladorPagarGarage;
import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Cobrar;
import ar.edu.unlam.tallerweb1.modelo.Cochera;
import ar.edu.unlam.tallerweb1.modelo.Garage;

import ar.edu.unlam.tallerweb1.modelo.Ticket;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCobrarTicketImplementacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioCobrarTickets;


	
	public class testUsuarios extends SpringTest{
		
		@Test
	    @Transactional 
	    @Rollback
	    public void pruebaConexion(){
	        assertThat(session().isConnected()).isTrue();
	    }
		@Test
		@Transactional
		@Rollback
		public void testQueAgregaAutoAparticular() {
			Cliente particular1 = new Cliente();
			particular1.setApellido("Santos");
			particular1.setNombre("Gaston");
			particular1.setEmail("gaston@gmail.com");
			particular1.setDni("33022121");
			particular1.setRol("normal");
			particular1.setPassword("12345");
			session().save(particular1);
			Auto auto1 = new Auto();
			auto1.setCliente1(particular1);
			auto1.setMarca("Ford");
			auto1.setModelo("Falcon");
			auto1.setPatente("JER752");
			session().save(auto1);
			
			Auto autobd = session().get(Auto.class, 1L);
			
			assertEquals(autobd.getCliente1().getNombre(),"Gaston" );			
		}
		@Test
		@Transactional
		@Rollback
		public void testQueEntranDosAutosAlGarage() {
			Cliente particular1 = new Cliente();
			particular1.setApellido("Santos");
			particular1.setNombre("Gaston");
			particular1.setEmail("gaston@gmail.com");
			particular1.setDni("33022121");
			particular1.setRol("normal");
			particular1.setPassword("12345");
			session().save(particular1);
			Auto auto1 = new Auto();
			Auto auto2 = new Auto();
			auto1.setCliente1(particular1);
			auto1.setMarca("Ford");
			auto1.setModelo("Falcon");
			auto1.setPatente("JER752");
			auto2.setMarca("Ford");
			auto2.setModelo("Uno");
			auto2.setPatente("JAl52");
			session().save(auto1);
			session().save(auto2);
			Garage garage1 = new Garage();
			//Long idA1 = (Long)session().save(auto1);
			//Long idA2 = (Long)session().save(auto2);
			session().save(garage1);
			
			Auto autoGarage = session().get(Auto.class, 1L);
			List<Auto>autosGarage= session().getSession().createCriteria(Auto.class)
					/*.createCriteria(Auto.class)
					.add(Restrictions.gt("Marca","Ford"))*/
					.list();
			assertEquals(2,autosGarage.size());
					
			
			
		}
		
		@Test
		@Transactional
		@Rollback
		public void testQueAutoEntraEnCochera() {
			Cliente particular1 = new Cliente();
			particular1.setApellido("Santos");
			particular1.setNombre("Gaston");
			particular1.setEmail("gaston@gmail.com");
			particular1.setDni("33022121");
			particular1.setRol("normal");
			particular1.setPassword("12345");
			session().save(particular1);
			
			Auto auto1 = new Auto();
			auto1.setMarca("Ford");
			auto1.setModelo("Falcon");
			auto1.setPatente("JER752");
			session().save(auto1);
			
			Garage garage1 = new Garage();
			//Long idA1 = (Long)session().save(auto1);
			//Long idA2 = (Long)session().save(auto2);
			session().save(garage1);
			
			Cochera cochera1 = new Cochera();
			cochera1.setNumero(1);
			session().save(cochera1);
			
			cochera1.setAuto(auto1);
			
			
			
			Auto autoGarage = session().get(Auto.class, 1L);
			List<Auto>autosGarage= session().getSession().createCriteria(Auto.class)
					/*.createCriteria(Auto.class)
					.add(Restrictions.gt("Marca","Ford"))*/
					.list();
			assertEquals(2,autosGarage.size());
					
			
			
		}
		
		
		@Test
		@Transactional
		@Rollback
		public void testeQueDaLaFechaDeticket() {
			Garage g1 = new Garage();
			g1.setPrecioHora(15.0);
			g1.setPrecioEstadia(400.0);
			
			Ticket t1 = new Ticket();
			t1.setHoraEntrada(LocalTime.of(17, 20, 20));
			
			t1.setGarage1(g1);
			
			Cobrar c = new Cobrar();
			Double vo = c.montoACobrar();
			Double ve = 30.0;
			assertEquals(ve,vo);
			Integer hora = (int) ChronoUnit.HOURS.between(t1.getHoraEntrada(), LocalTime.now());
			System.out.println(hora);
			System.out.println(t1.getFecha());
			System.out.println(t1.getHoraEntrada());
			
			
		}
		
		
		
		@Test
		@Transactional
		@Rollback
		public void testeQueHaceCosas() throws ParseException {
			
			ServicioCobrarTicketImplementacion impl = new ServicioCobrarTicketImplementacion();
			//ServicioCobrarTickets serv = new ServicioCobrarTickets();
			ControladorPagarGarage  cont1 = new ControladorPagarGarage(impl);
			 String date = "2021-05-18";
			 String date2 = "2021-05-22";
			 String time = "10:15:30";
			cont1.procesarPago(date, date2, time);
			Double vo=impl.PrecioDias(date, date2);
			Double ve = 1600.0;
			assertEquals(vo,ve);
			

		}
		
	}
	


