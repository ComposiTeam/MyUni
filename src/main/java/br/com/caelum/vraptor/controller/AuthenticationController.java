package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.Students;
import br.com.caelum.vraptor.dao.UserDAO;
import br.com.caelum.vraptor.manager.UserManager;
import br.com.caelum.vraptor.model.Student;
import br.com.caelum.vraptor.model.User;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class AuthenticationController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	private static final String LOGIN_ERROR = "login-error";
	private final UserDAO userDAO;
	private final UserManager userManager;
	private final Result result;
	private Validator validator;
	
	public AuthenticationController() {
		this(null,null,null,null);
	}
	
	@Inject
	public AuthenticationController(Result result, UserDAO userDAO , 
			UserManager userManager ,Validator validator){
		this.result= result;
		this.userDAO = userDAO;
		this.userManager = userManager;
		this.validator = validator;
	}

	
	@Post
	@Path("/login")
	public void login(@NotNull User user) {
	
		String informedUsername = user.getUsername();
		String informedPassword = user.getPassword();
				
		User userAuthenticated = userDAO.find("username", informedUsername);
		
		if(userAuthenticated != null) {
			if(userAuthenticated.getPassword().equals(informedPassword)){
				userManager.login(userAuthenticated);
				logger.info("Login success!");
				result.redirectTo(this).welcome();
			} else {
				validator.add(new SimpleMessage(LOGIN_ERROR, "Senha ou login não conferem!"));
				validator.onErrorUsePageOf(IndexController.class).index();
			}
		} else {
			validator.add(new SimpleMessage(LOGIN_ERROR, "Usuário não existe"));
			validator.onErrorUsePageOf(IndexController.class).index();
		}
	}
	
	@Get("/logout")
	public void logout(){
		userManager.logout();
		result.redirectTo(IndexController.class).index();
	}
	
	@Students
	@Path("/settings")
	public void settings(){
		User user = userManager.getUserLogged();
		Student student = userDAO.getStudent(user);
		
		result.include("student", student);
		
	}
	
	@Path("/welcome")
	public void welcome()
	{
		
	}
	
	@Path("/loginError")
	public void loginError()
	{
		
	}

}
