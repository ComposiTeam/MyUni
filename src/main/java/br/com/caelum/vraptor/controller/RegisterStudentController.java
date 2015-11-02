package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.StudentDAO;
import br.com.caelum.vraptor.manager.UserManager;
import br.com.caelum.vraptor.model.Student;
import br.com.caelum.vraptor.model.User;

@Controller
public class RegisterStudentController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterStudentController.class);
	
	private final Result result;
	private final StudentDAO studentDAO;
	private final UserManager userSession;
	
	public RegisterStudentController()
	{
		this(null, null,null);
	}
	
	
	
	@Inject
	public RegisterStudentController(Result result, StudentDAO studentDAO,
			UserManager userSession) {
		this.result = result;
		this.studentDAO = studentDAO;
		this.userSession = userSession;
	}




	@Post
	@Path("/registerstudent")
	public void registerstudent(Student student){
		logger.info("It is going to save a student");
		User user = userSession.getUserLogged();
		if(student != null && user != null){
			logger.info("The student will be persisted: " + student.getName() + " " + student.getMwId());
			student.setUser(user);
			studentDAO.create(student);
			result.redirectTo(AuthenticationController.class).welcome();
		}else{
			logger.info("Trying to add a student or user null");
			logger.info("Student status:" + student);
			logger.info("User status" + user );
			result.redirectTo(AuthenticationController.class).settings();
		}
	}
	
	
}
