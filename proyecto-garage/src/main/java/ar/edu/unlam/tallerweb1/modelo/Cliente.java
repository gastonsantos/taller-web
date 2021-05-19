package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class Cliente{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer dni;
	private String sexo;
	
	@ManyToOne
	private Usuario usuariosCliente;
	
	@OneToOne
	private Auto auto;
	
	
	
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuariosCliente() {
		return usuariosCliente;
	}
	public void setUsuariosCliente(Usuario usuariosCliente) {
		this.usuariosCliente = usuariosCliente;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dni=" + dni + ", sexo=" + sexo + ", usuariosCliente=" + usuariosCliente + "]";
	}
	
	
}
