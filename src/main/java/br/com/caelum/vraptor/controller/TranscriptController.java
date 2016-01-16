package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.manager.TranscriptExtractManager;
import br.com.caelum.vraptor.manager.UserManager;
import br.com.caelum.vraptor.model.AcademicResult;
import br.com.caelum.vraptor.model.Student;
import br.com.caelum.vraptor.model.Transcript;
import br.com.caelum.vraptor.model.User;
import br.com.caelum.vraptor.service.AcademicResultService;
import br.com.caelum.vraptor.service.DisciplineService;
import br.com.caelum.vraptor.service.StudentService;
import br.com.caelum.vraptor.service.TranscriptService;
import br.com.caelum.vraptor.service.UserService;
import br.com.caelum.vraptor.validator.Validator;
import br.com.compositeam.unb.TranscriptPage;

@Controller
public class TranscriptController {
	
	private static final Logger logger = LoggerFactory.getLogger(DisciplineController.class);
	private final UserManager userManager;
	private final Result result;
	private Validator validator;
	private UserService userService;
	private StudentService studentService;
	private TranscriptService transcriptService;
	private DisciplineService disciplineService;
	private AcademicResultService academicResultService;
	private TranscriptExtractManager transcriptExtractManager;
	
	public TranscriptController(){
		this(null,null,null,null,null,null,null,null,null);
	}
	
	@Inject
	public TranscriptController(UserManager userManager,UserService userService, StudentService studentService, Result result,
			TranscriptService transcriptService, DisciplineService disciplineService, 
			AcademicResultService resultService,TranscriptExtractManager transcriptExtractManager, Validator validator) {
		super();
		this.userManager = userManager;
		this.result = result;
		this.validator = validator;
		this.userService = userService;
		this.studentService = studentService;
		this.transcriptService = transcriptService;
		this.disciplineService = disciplineService;
		this.academicResultService = resultService;
		this.transcriptExtractManager = transcriptExtractManager; 
	}
	
	@Get("transcript/mwtranscript")
	public void MWTranscript(){
		Transcript trans = null;
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
				trans = new Transcript();
				trans.setStudent(student);
				transcriptService.create(trans);
				logger.info("Id Transcript" + trans.getId());
			}
			transcriptExtractManager.setTranscript(trans);
			TranscriptPage page = new TranscriptPage(student.getMwId(), student.getMwPassword(),this.transcriptExtractManager);
			page.extractData();
			page.save();
			result.redirectTo(TranscriptController.class).show();
		}else{
			result.redirectTo(IndexController.class).index();
		}
	}
	
	@Path("transcript/show")
	public Transcript show(){
		Transcript trans = null;
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
				trans = new Transcript();
				trans.setStudent(student);
				transcriptService.create(trans);
				logger.info("Id Transcript" + trans.getId());
			}
		}else{
			result.redirectTo(IndexController.class).index();
		}
		logger.info("It is going to return a transcriptofrecords: " + trans.getId() );
		if(trans.getResults() == null || trans.getResults().size() == 0){
			logger.info("The list is null");
			List<AcademicResult> list = academicResultService.list(trans);
			trans.setResults(list);
			
		}
		return trans;
	}

}
