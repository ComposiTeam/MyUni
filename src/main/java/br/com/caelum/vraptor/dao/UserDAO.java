package br.com.caelum.vraptor.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.controller.AuthenticationController;
import br.com.caelum.vraptor.model.Student;
import br.com.caelum.vraptor.model.User;

@RequestScoped
public class UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
	@Inject 
	private EntityManager manager;
	
	
	public void add(User user){
		manager.persist(user);
	}
	
	public User find(String field, Object value){
		
		
		String sql = "SELECT user FROM User user";
	
		// Verifies if select have an criteria
		boolean isGenericSelect = field != null && value != null;
		
		if(isGenericSelect) {
			sql = sql + " WHERE user.".concat(field).concat("=:value");
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
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
		
	}
	
	public Student getStudent(User user){
		try {
			Query query = manager.createQuery("select student FROM Student student WHERE student.user =:value ");
			query.setParameter("value", user);
			return (Student)query.getSingleResult();
		} catch (NonUniqueResultException exception){
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
		
	}
	
}
