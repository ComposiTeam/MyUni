package br.com.caelum.vraptor.manager;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.vraptor.model.User;

@SessionScoped
@Named("manager")
public class UserManager implements Serializable {

	private static final long serialVersionUID = 1L;

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

	public boolean isLogged() {
		boolean isLogged = false;
		if(userLogged != null){
			isLogged = true;
		}

		return isLogged;
	}
}
