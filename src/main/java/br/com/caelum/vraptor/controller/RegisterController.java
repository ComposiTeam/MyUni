package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UserDAO;
import br.com.caelum.vraptor.model.Role;
import br.com.caelum.vraptor.model.User;
import br.com.caelum.vraptor.service.RoleService;

@Controller
public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	private final Result result;
	private final UserDAO userDAO;
	private final RoleService roleService;
	
	//Empty constructor CDI Only
	public RegisterController()
	{
		this(null, null,null);
	}
	
	@Inject
	public RegisterController(Result result, UserDAO userDAO, RoleService roleService)
	{
		this.result= result;
		this.userDAO = userDAO;
		this.roleService = roleService;
	}
	
	@Get
	@Path("/register")
	public void register()
	{
		
	}
	@Post
	@Path("/register")
	public void register(User user,String optradio){
		try {
			logger.info("Option radio is " + optradio);
			
			Role role = roleService.findByName(optradio);
			
			if(role == null) {
				throw new IllegalArgumentException("Invalid role!");
			}
			
			user.addRole(role);
			userDAO.add(user);
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		
		result.redirectTo(IndexController.class).index();
	}
	
}

