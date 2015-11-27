package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.manager.DisciplineManager;
import br.com.caelum.vraptor.manager.InstituteManager;
import br.com.caelum.vraptor.manager.OfferExtractManager;
import br.com.caelum.vraptor.model.unb.Campus;
import br.com.caelum.vraptor.model.unb.Institute;
import br.com.caelum.vraptor.service.DisciplineService;
import br.com.caelum.vraptor.service.unb.CampusService;
import br.com.caelum.vraptor.service.unb.InstituteService;
import br.com.compositeam.unb.CampusPage;
import br.com.compositeam.unb.DepartamentPage;
import br.com.compositeam.unb.OfferPage;

@Controller
public class UnbExtractDataController {
	private static final Logger logger = LoggerFactory.getLogger(UnbExtractDataController.class);

	private CampusService campusService;
	private OfferExtractManager manager;
	private DisciplineService disciplineService;
	private InstituteService instituteService;
	private InstituteManager managerInstitute;
	private DisciplineManager managerDiscipline;
	private Result result;
	
	@Inject
	public UnbExtractDataController(CampusService campusService, 
			OfferExtractManager manager,DisciplineService disciplineService,
			InstituteService instituteService, InstituteManager managerInstitute,
			DisciplineManager managerDiscipline,Result result){
		this.campusService = campusService;
		this.manager = manager;
		this.disciplineService = disciplineService;
		this.result = result;
		this.managerInstitute = managerInstitute;
		this.instituteService = instituteService;
		this.managerDiscipline = managerDiscipline;
	}
	
	public UnbExtractDataController(){
		this(null,null,null,null,null,null,null);
	}
	
	
	public void listCampus(){
		result.include("campus", this.campusService.list());
	}
	
	public void listInstitutes(){
		result.include("institues", this.instituteService.list());
	}
	
	public void extractCampus(){
		CampusPage page = new CampusPage(campusService);
		page.extractData();
		page.save();
	}
	
	public void extractInstitutes(){
		List<Campus> campus = this.campusService.list();
		for(Campus camp: campus){
			managerInstitute.setCampus(camp);
			DepartamentPage departament = new DepartamentPage(camp.getCode(),managerInstitute);
			departament.getData();
			departament.save();
			campusService.update(camp);
		}
	}
	
	public void listDisciplines(){
		result.redirectTo(DisciplineController.class).list();
	}
	public void extractDisciplines(){
		List<Institute> institutes = instituteService.list();
		for(Institute institute : institutes){
			managerDiscipline.setInstitute(institute);
			OfferPage offerPage = new OfferPage(institute.getCode(),managerDiscipline);
			offerPage.extractData();
			offerPage.save();
			instituteService.update(institute);
		}
	}
	
	public void extractOffer(){
		this.manager.getData();
	}
}
