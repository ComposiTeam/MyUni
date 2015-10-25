package br.com.caelum.vraptor.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	private String username;
	private String password;
	private String email;
	private boolean agreeded;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id =  id;
	}
	public boolean isAgreeded() {
		return agreeded;
	}
	public void setAgreeded(boolean agreeded) {
		this.agreeded = agreeded;
	}
	
	

}