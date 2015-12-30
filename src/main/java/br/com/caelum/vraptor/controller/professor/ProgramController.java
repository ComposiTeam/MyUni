package br.com.caelum.vraptor.controller.professor;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.Professors;
import br.com.caelum.vraptor.model.university.Program;
import br.com.caelum.vraptor.service.university.ProgramService;

@Controller
public class ProgramController {

	private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);
	private ProgramService programService;
	private Result result;

	@Inject
	public ProgramController(ProgramService programService, Result result){
		this.programService = programService;
		this.result = result;
	}
	
	public ProgramController(){
		this(null,null);
	}
	
	@Professors
	@Get
	public void save(){
		
	}
	
	@Professors
	@Post
	public void save(Program program){
		String mensage = "";
		try{
			this.programService.create(program);
			mensage = "It was saved succesfully";
		}catch(Exception ex){
			logger.debug(ex.getMessage());
			mensage = "It cannot be save";
		}
		result.include("mensage", mensage);
	}
	
	@Professors
	public void list(){
		List<Program> programs = this.programService.list();
		result.include("programs", programs);
	}
	
}
