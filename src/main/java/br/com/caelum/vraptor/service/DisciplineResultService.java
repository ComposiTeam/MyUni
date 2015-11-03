package br.com.caelum.vraptor.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.dao.DisciplineResultDAO;
import br.com.caelum.vraptor.model.DisciplineResult;

@RequestScoped
public class DisciplineResultService {
	
	private DisciplineResultDAO disciplineResultDAO;
	
	@Inject
	public DisciplineResultService(DisciplineResultDAO disciplineResultDAO){
		this.disciplineResultDAO = disciplineResultDAO;
	}
	
	public DisciplineResultService(){
		this(null);
	}
	
	public void create(DisciplineResult disciplineResult){
		this.disciplineResultDAO.create(disciplineResult);
	}

}
