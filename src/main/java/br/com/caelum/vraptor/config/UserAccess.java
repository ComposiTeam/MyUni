package br.com.caelum.vraptor.config;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.mail.util.ReadableMime;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.Students;
import br.com.caelum.vraptor.controller.CampusController;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.IndexController;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.manager.UserManager;
import br.com.caelum.vraptor.model.Role;

@Intercepts
public class UserAccess {
	
	private static final Logger logger = LoggerFactory.getLogger(UserAccess.class);
	
	private UserManager userManager;
	private Result result;
	private Annotation[] annotations;
	private boolean redirectToIndex = false;
	
	@Inject
	public UserAccess(UserManager userManager, Result result){
		this.userManager = userManager;
		this.result = result;
	}
	
	public UserAccess(){
		this(null,null);
	}
	
	@Accepts
	public boolean accepts(ControllerMethod method){
		logger.info(method.getMethod().getName());
		this.annotations = method.getAnnotations();
		logg();
		if(method.containsAnnotation(Students.class)){
			logger.info("The method contatins Students annotation");
			return true;
		}
		logger.info("This is not going to be intercepts");
		return false;
	}
	
	@AroundCall
	public void around(SimpleInterceptorStack stack){
		stack.next();
		if(redirectToIndex == true){
			result.redirectTo(IndexController.class).index();
		}
	}
	
	@BeforeCall
	public void before(){
		logger.info("Intercepts");
		logger.info("Is logged: " + userManager.isLogged());
		if(userManager.isLogged() == true){		
			List<Role> roles = userManager.getUserLogged().getRoles();
			boolean permission = false;
			for(Role role : roles){
				permission = has(annotations,role);
				if(permission == true){
					break;
				}
			}
			if(permission == false){
				redirectToIndex = true;
			}
		}else{
			redirectToIndex = true;
		}
	}
	
	private boolean has(Annotation[] annotations, Role role){
		boolean result = false;
		for(Annotation an : annotations){
			if(an.getClass().getName().contains(role.getName())){
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	private void logg(){
		logger.info("Annotations");
		for(Annotation an : annotations){
			logger.info(an.annotationType().getName());
		}
	}
	
}
