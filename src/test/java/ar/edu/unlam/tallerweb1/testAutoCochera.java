package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;


public class testAutoCochera extends SpringTest{
 
	
	@Test
    @Transactional 
    @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }
	
	
	public void testQueUnAutoAsignaCochera() {
		
		
		
		
		
		
		
	}
}
