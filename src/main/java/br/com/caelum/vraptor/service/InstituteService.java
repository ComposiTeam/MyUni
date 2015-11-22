package br.com.caelum.vraptor.service;

import javax.inject.Inject;

import br.com.caelum.vraptor.dao.InstituteDAO;
import br.com.caelum.vraptor.model.Institute;

public class InstituteService {
	
	private InstituteDAO instituteDAO;
	
	@Inject
	private InstituteService(InstituteDAO instituteDAO){
		this.instituteDAO = instituteDAO;
	}
	
	private InstituteService(){
		this(null);
	}
	
	private void create(Institute institute){
		this.instituteDAO.create(institute);
	}

}
