package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.manager.UserManager;
import br.com.caelum.vraptor.model.Student;
import br.com.caelum.vraptor.model.TranscriptOfRecords;
import br.com.caelum.vraptor.model.User;
import br.com.caelum.vraptor.service.DisciplineService;
import br.com.caelum.vraptor.service.StudentService;
import br.com.caelum.vraptor.service.TranscriptOfRecordsService;
import br.com.caelum.vraptor.service.UserService;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class TranscriptController {
	
	private static final Logger logger = LoggerFactory.getLogger(DisciplineController.class);
	private final UserManager userManager;
	private final Result result;
	private Validator validator;
	private UserService userService;
	private StudentService studentService;
	private TranscriptOfRecordsService transcriptService;
	private DisciplineService disciplineService;
	
	public TranscriptController(){
		this(null,null,null,null,null,null,null);
	}
	
	@Inject
	public TranscriptController(UserManager userManager,UserService userService, StudentService studentService, Result result,
			TranscriptOfRecordsService transcriptService, DisciplineService disciplineService, Validator validator) {
		super();
		this.userManager = userManager;
		this.result = result;
		this.validator = validator;
		this.userService = userService;
		this.studentService = studentService;
		this.transcriptService = transcriptService;
		this.disciplineService = disciplineService;
	}
	
	@Get("transcript/mwtranscript")
	public void getMWTranscript(){
		TranscriptOfRecords trans = null;
		if(userManager.isLogged()){
			User user = userManager.getUserLogged();
			logger.info("User: " + user.getUsername());
			Student student = userService.getStudent(user);
			if(student == null){
				result.redirectTo(AuthenticationController.class).settings();
			}else{
				logger.info("Student:" + student.getName());
			}
			trans = studentService.getTranscript(student);
			if(trans == null){
				trans = new TranscriptOfRecords();
				trans.setStudent(student);
				transcriptService.create(trans);
				logger.info("Id Transcript" + trans.getId());
			}
		}else{
			result.redirectTo(IndexController.class).index();
		}
	}
	
	@Get("transcript/show")
	public TranscriptOfRecords show(){
		TranscriptOfRecords trans = null;
		if(userManager.isLogged()){
			User user = userManager.getUserLogged();
			logger.info("User: " + user.getUsername());
			Student student = userService.getStudent(user);
			if(student == null){
				result.redirectTo(AuthenticationController.class).settings();
			}else{
				logger.info("Student:" + student.getName());
			}
			
		}else{
			result.redirectTo(IndexController.class).index();
		}
		return trans;
	}

}
