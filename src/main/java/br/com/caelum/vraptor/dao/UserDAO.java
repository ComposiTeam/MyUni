package br.com.caelum.vraptor.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.model.User;

@RequestScoped
public class UserDAO {
	
	@Inject 
	private EntityManager manager;
	
	
	public void add(User user){
		manager.persist(user);
	}
	
	public User get(String name){
		return null;
	}
}
