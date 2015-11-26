package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.manager.OfferExtractManager;
import br.com.caelum.vraptor.model.unb.Campus;
import br.com.caelum.vraptor.model.unb.Institute;
import br.com.caelum.vraptor.service.DisciplineService;
import br.com.caelum.vraptor.service.unb.CampusService;
import br.com.compositeam.unb.CampusPage;
import br.com.compositeam.unb.OfferPage;

@Controller
public class UnbExtractDataController {
	private static final Logger logger = LoggerFactory.getLogger(UnbExtractDataController.class);

	private CampusService campusService;
	private OfferExtractManager manager;
	private DisciplineService disciplineService;
	private Result result;
	
	@Inject
	public UnbExtractDataController(CampusService campusService, 
			OfferExtractManager manager,DisciplineService disciplineService,
			Result result){
		this.campusService = campusService;
		this.manager = manager;
		this.disciplineService = disciplineService;
		this.result = result;
	}
	
	public UnbExtractDataController(){
		this(null,null,null,null);
	}
	
	
	public void listCampus(){
		result.include("campus", this.campusService.list());
	}
	
	public void extractCampus(){
		CampusPage page = new CampusPage(campusService);
		page.extractData();
		page.save();
	}
	
	public void extractInstitutes(){
		
	}
	
	public void extractDisciplines(Institute institute){
		OfferPage offerPage = new OfferPage(institute.getCode(),this.disciplineService);
		offerPage.extractData();
		offerPage.save();
	}
	
	public void extractOffer(){
		this.manager.getData();
	}
}
