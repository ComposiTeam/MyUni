package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.model.unb.Campus;
import br.com.caelum.vraptor.model.unb.Institute;
import br.com.caelum.vraptor.service.unb.InstituteService;

@Controller
public class InstituteController {
	private static final Logger logger = LoggerFactory.getLogger(InstituteController.class);

	private InstituteService instituteService;
	private Result result;
	@Inject
	public InstituteController(InstituteService instituteService, Result result){
		this.instituteService = instituteService;
		this.result = result;
	}
	
	public InstituteController(){
		this(null,null);
	}
	
	@Path("institutes/{campus.id}")
	public void listByCampus(Campus campus){
		if(campus != null){
			logger.info("Campus is not null");
			logger.info("The size of institutes: " + campus.getInstitutes().size());
			List<Institute> institutes = instituteService.findByCampus(campus);
			logger.info("The situation of institutes: " + institutes); 
			result.include("institutes", institutes);
		}else{
			logger.info("Something went wrong");
			result.include("error","Campus is null");
		}
		
	}
	
	public void list(){
		result.include("institutes", instituteService.list());
	}
}
