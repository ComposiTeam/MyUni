package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.model.unb.Campus;
import br.com.caelum.vraptor.service.unb.CampusService;

@Controller
public class CampusController {
	
	private static final Logger logger = LoggerFactory.getLogger(CampusController.class);

	private CampusService campusService;
	private Result result;
	@Inject
	public CampusController(CampusService campusService, Result result){
		this.campusService = campusService;
		this.result = result;
	}
	
	public CampusController(){
		this(null,null);
	}
	
	public void create(Campus campus){
		if(campus != null){
			this.campusService.create(campus);
			logger.info("Campus ID:" + campus.getId());
		}
	}
	
	public void list(){
		result.include("campus", campusService.list());
	}
}
