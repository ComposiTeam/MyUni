package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.manager.OfferExtractManager;
import br.com.caelum.vraptor.manager.TranscriptExtractManager;
import br.com.caelum.vraptor.manager.UserManager;
import br.com.caelum.vraptor.model.Discipline;
import br.com.caelum.vraptor.service.DisciplineService;
import br.com.caelum.vraptor.validator.Validator;
import br.com.compositeam.unb.OfferPage;

@Controller
public class DisciplineController {

	private static final Logger logger = LoggerFactory.getLogger(DisciplineController.class);
	private final UserManager userManager;
	private final DisciplineService disciplineService;
	private final Result result;
	private Validator validator;
	private OfferExtractManager offer;
	
	public DisciplineController(){
		this(null,null,null,null,null);
	}
	
	@Inject
	public DisciplineController(UserManager userManager, DisciplineService disciplineDAO, Result result,
			OfferExtractManager offer,Validator validator) {
		super();
		this.userManager = userManager;
		this.result = result;
		this.disciplineService = disciplineDAO;
		this.validator = validator;
		this.offer = offer;
	}
	
	@Get("/discipline")
	public void add(){
		
	}
	
	@Post("/discipline")
	public void add(Discipline discipline){
		String page = "add";
		if(discipline != null){
			try{
				disciplineService.create(discipline);
			}catch(Exception ex){
				logger.info("Something was going wrong.");
				logger.debug(ex.getMessage());
				result.include("messagem", "Um erro ocorreu enquanto tentava se salvar o objeto");
				result.include("discipline", discipline);
				page = "add";
			}
			page = "index";
		}else{ 
			logger.info("Trying to insert a null discipline.");
		}
		if(page == "add"){
			
		}else{
			result.redirectTo(IndexController.class).index();
		}
	}
	
	public List<Discipline> list(){
		logger.info("It is going to return all disciplines");
		List<Discipline> list = disciplineService.list();
		logger.info("The list has " + list.size() + " elements");
		return disciplineService.list();
	}
	
	public void addAll(){
		OfferPage offerPage = new OfferPage("650",this.disciplineService);
		offerPage.extractData();
		offerPage.save();
	}
	
	public void offer(){
		offer.getData();
		
		
	}
	
	
}
