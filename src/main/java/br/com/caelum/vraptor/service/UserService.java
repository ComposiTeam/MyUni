package br.com.caelum.vraptor.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.dao.UserDAO;
import br.com.caelum.vraptor.model.Student;
import br.com.caelum.vraptor.model.User;

@RequestScoped
public class UserService {
	
	private final static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	private UserDAO userDAO;
	
	public UserService()
	{
		this(null);
	}
	
	@Inject
	public UserService(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	public void create(User user){
		userDAO.add(user);
	}
	
	public User getUser(String login){
		return userDAO.find("username", "default");
	}
	
	public boolean existsField(String field, String value){
		try{
				if(userDAO.find(field,value) != null){
					return false;
				}
				else
				{
					return true;
				}
		}catch (NonUniqueResultException exception) {
			return false;
			
		}
	}
	
	public void update(User user){
		userDAO.add(user);
	}
	
	public boolean existsUser(String login){
		boolean userExistence;
		if(userDAO.find("login", login) !=null ){
			userExistence = true;
		}
		else{
			userExistence = false;
		}
		
		return userExistence;
	}

	
	public User authenticate(String login, String password){

		
		User user = userDAO.find("username", login);
	
		
		if(user != null)
		{
			boolean correctPassword = user.getPassword().equals(password);
			if(correctPassword){
				return user;
			}
			else
			{
				return null;
			}
		}
		else {
			return null;
		}
	
		
	}
	
	public Student getStudent(User user){
		return this.userDAO.getStudent(user);
	}
}
