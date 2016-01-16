package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.Students;
import br.com.caelum.vraptor.manager.UserManager;
import br.com.caelum.vraptor.model.Student;
import br.com.caelum.vraptor.model.User;
import br.com.caelum.vraptor.model.university.Program;
import br.com.caelum.vraptor.service.StudentService;
import br.com.caelum.vraptor.service.UserService;
import br.com.caelum.vraptor.service.university.ProgramService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private Result result;
	private UserManager userManager;
	private UserService userService;
	private ProgramService programService;
	private StudentService studentService;
	
	@Inject
	public UserController(Result result, UserManager userManager, UserService userService,
			ProgramService programService,StudentService studentService){
		this.result = result;
		this.userManager = userManager;
		this.userService = userService;
		this.programService = programService;
		this.studentService = studentService;
	}
	
	public UserController() {
		this(null,null,null,null,null);
	}
	
	@Students
	@Get("trview")
	public void trView(){
		if(userManager.isLogged()){
			User user = userManager.getUserLogged();
			logger.info("User: " + user.getUsername());
			Student student = userService.getStudent(user);
			if(student == null){
				result.redirectTo(AuthenticationController.class).settings();
			}else{
				logger.info("Student:" + student.getName());
			}
			student.getProgram();
		}
	}
	
	@Students
	@Get("chProgram")
	public void chooseProgram(){
		User user = userManager.getUserLogged();
		logger.info("User: " + user.getUsername());
		Student student = userService.getStudent(user);
		if(student == null){
			result.redirectTo(AuthenticationController.class).settings();
		}
		List<Program> programs = programService.list();
		result.include("programs", programs);
	}
	
	@Students
	@Post("chProgram")
	public void chooseProgram(String idProgram){
		logger.info("Program id: " + idProgram);
		if(idProgram != null){
			Program program = programService.findById(idProgram);
			logger.info("Program " + program);
			if(program != null){
				User user = userManager.getUserLogged();
				logger.info("User: " + user.getUsername());
				Student student = userService.getStudent(user);
				logger.info("Student: " + student);
				student.setProgram(program);
				studentService.update(student);
				
			}
		}
	}
}
