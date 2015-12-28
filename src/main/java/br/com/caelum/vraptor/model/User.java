package br.com.caelum.vraptor.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@NotNull @Size(min=5, max=50)
	private String username;
	@NotNull @Size(min=5, max=50)
	private String password;
	
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "userRole", joinColumns = @JoinColumn(name = "idUser"), 
			inverseJoinColumns = @JoinColumn(name = "idRole"))
	private List<Role> roles = new ArrayList<Role>();
	
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role){
		this.roles.add(role);
	}
	
	

}
