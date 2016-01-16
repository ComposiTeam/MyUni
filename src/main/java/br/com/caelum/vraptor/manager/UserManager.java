package br.com.caelum.vraptor.manager;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.model.Role;
import br.com.caelum.vraptor.model.RoleEnum;
import br.com.caelum.vraptor.model.User;

@SessionScoped
@Named("manager")
public class UserManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Logger logger = LoggerFactory.getLogger(UserManager.class);

	private User userLogged;

	public void login(User user) {
		setUserLogged(user);
	}

	public void logout() {
		setUserLogged(null);
	}

	public User getUserLogged() {
		if (userLogged == null) {
			throw new NullPointerException("Don't have user in session!");
		} else {
			return userLogged;
		}
	}

	public void setUserLogged(User userLogged) {
		this.userLogged = userLogged;
	}
	
	/**
	 * Exist any user logged
	 *  
	 * @return true if user logged is true
	 */
	public boolean isLogged() {
		boolean isLogged = false;
		if(userLogged != null){
			isLogged = true;
		}

		return isLogged;
	}
	
	/**
	 * Used into header.jsp
	 * 
	 * @return true if userLogged is Student
	 */
	public boolean isStudent() {
		boolean showMenuStudent = false;
		
		try {
			List<Role> roles = userLogged.getRoles();
			
			// Search role
			for(Role role : roles) {
				// verifies role
				if(role.equals(RoleEnum.STUDENT)) {
					showMenuStudent = true;
				}
			}
		} catch (NullPointerException nullPointerException) {
			logger.debug(nullPointerException.getMessage());
		}
		
		return showMenuStudent;
	}
	
	/**
	 * Used into header.jsp
	 * 
	 * @return true if userLogged is Professor
	 */
	public boolean isProfessor() {
		boolean showProfessorMenu = false;
		
		try {
			List<Role> roles = userLogged.getRoles();
			
			// Search role
			for(Role role : roles) {
				// verifies role
				if(role.equals(RoleEnum.PROFESSOR)) {
					showProfessorMenu = true;
				}
			}
		} catch (NullPointerException nullPointerException) {
			logger.debug(nullPointerException.getMessage());
		}
		
		return showProfessorMenu;
	}
	
}
