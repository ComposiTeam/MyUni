package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.model.unb.Campus;
import br.com.caelum.vraptor.service.unb.CampusService;

@Controller
public class CampusController {
	
	private static final Logger logger = LoggerFactory.getLogger(CampusController.class);

	private CampusService campusService;
	
	@Inject
	public CampusController(CampusService campusService){
		this.campusService = campusService;
	}
	
	public CampusController(){
		this(null);
	}
	
	public void create(Campus campus){
		if(campus != null){
			this.campusService.create(campus);
			logger.info("Campus ID:" + campus.getId());
		}
	}
}
