package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.View;
import br.com.caelum.vraptor.manager.UserManager;
import br.com.caelum.vraptor.model.User;
import br.com.caelum.vraptor.service.UserService;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class AuthenticationController {
	
	private static final String LOGIN_ERROR = null;
	private final Result result;
	private final UserService userService;
	private final UserManager userManager;
	private final Validator validator;
	
	public AuthenticationController()
	{
		this(null,null,null,null);
	}
	
	@Inject
	public AuthenticationController(Result result, UserService userService ,UserManager userManager, Validator validator)
	{
		this.result= result;
		this.userService = userService;
		this.userManager = userManager;
		this.validator = validator;
	}

	
	@Get
	@Path("/login")
	public void login(User user){
		
		
		String informedUsername = user.getUsername();
		String informedPassword = user.getPassword();
		
		User userAuth = userService.authenticate(informedUsername,
				informedPassword);
		
		if(userAuth!=null){
			
			userManager.login(userAuth);
			result.redirectTo(AuthenticationController.class).gradPlanner();
		}
		else
		{
			validator.add(new SimpleMessage(LOGIN_ERROR, "Senha ou login não conferem!"));
			validator.onErrorUsePageOf(IndexController.class).index();
		}
	
	}
	
	@Get("/logout")
	public void logout(){
		userManager.logout();
		result.redirectTo(IndexController.class).index();
	}
	
	@View
	public void gradPlanner()
	{
		
	}

}
