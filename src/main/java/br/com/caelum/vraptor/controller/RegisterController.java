package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UserDAO;
import br.com.caelum.vraptor.model.User;

@Controller
public class RegisterController {
	
	private final Result result;
	private final UserDAO userDAO;
	
	//Empty constructor CDI Only
	public RegisterController()
	{
		this(null, null);
	}
	
	@Inject
	public RegisterController(Result result, UserDAO userDAO)
	{
		this.result= result;
		this.userDAO = userDAO;
	}
	
	@Get
	@Path("/register")
	public void register()
	{
		
	}
	@Post
	@Path("/register")
	public void register(User user){
		userDAO.add(user);
		result.redirectTo(IndexController.class).index();
	}
	
}

