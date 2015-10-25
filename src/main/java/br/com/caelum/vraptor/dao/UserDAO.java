package br.com.caelum.vraptor.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.model.User;

@RequestScoped
public class UserDAO {
	
	@Inject 
	private EntityManager manager;
	
	
	public void add(User user){
		manager.persist(user);
	}
	
	public User find(String field, String value){

		String sql = "SELECT user FROM User user";
	
		// Verifies if select have an criteria
		boolean isGenericSelect = field != null && value != null;
		
		if(isGenericSelect) {
			sql = sql + " WHERE user.".concat(field)+ " = " .concat(value);
		} else {
			// default sql string
		}
		
		try {
			Query query = manager.createQuery(sql);
			
			if(isGenericSelect) {
				query.setParameter("value", value);
			} else {
				// without param
			}
			
			return (User) query.getSingleResult();
		} catch (NonUniqueResultException exception){
			throw new NonUniqueResultException();
		} catch (NoResultException exception) {
			return null;
		}
		
	}
	
}
