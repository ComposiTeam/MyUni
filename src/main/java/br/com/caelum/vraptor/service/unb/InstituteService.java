package br.com.caelum.vraptor.service.unb;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.dao.unb.InstituteDAO;
import br.com.caelum.vraptor.model.unb.Campus;
import br.com.caelum.vraptor.model.unb.Institute;

public class InstituteService {
	
	private InstituteDAO instituteDAO;
	
	@Inject
	private InstituteService(InstituteDAO instituteDAO){
		this.instituteDAO = instituteDAO;
	}
	
	private InstituteService(){
		this(null);
	}
	
	public void create(Institute institute){
		this.instituteDAO.create(institute);
	}

	public void update(Institute institute){
		this.instituteDAO.update(institute);
	}

	public Institute findByCode(String code) {
		return this.instituteDAO.findByCode(code);
	}
	
	public List<Institute> list(){
		return this.instituteDAO.list();
	}
	
	public List<Institute> findByCampus(Campus campus){
		return this.instituteDAO.findByCampus(campus);
	}

}
