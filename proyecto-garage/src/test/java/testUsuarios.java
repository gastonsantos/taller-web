import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.controladores.ControladorRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioLoginImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroImpl;


public class testUsuarios extends SpringTest{
	RepositorioUsuarioImpl repositorio;
	ServicioLoginImpl servicioLogin = new ServicioLoginImpl(repositorio);
	ControladorLogin cont = new ControladorLogin(servicioLogin);
	
	@Test
    @Transactional 
    @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }
	
	@Test
	@Transactional
	@Rollback
	public void queSePuedaConsultarUnUsuarioALaBD(){
		
		Usuario usuario1 = new Usuario();
		usuario1.setNombre("pepe");
		usuario1.setApellido("rodriguez");
		usuario1.setEmail("pepito@hotmail.com");
		usuario1.setPassword("123");
		
		servicioLogin.consultarUsuario(usuario1);
		
		/*session().save(usuario1);
		
		Usuario usuariosBD = session().get(Usuario.class, (1L));
		assertEquals(usuariosBD.getApellido(), "rodriguez"); */
		
		
		
		
	}
	

}
