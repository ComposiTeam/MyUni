package br.com.caelum.vraptor.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.dao.ProfessorDAO;
import br.com.caelum.vraptor.model.Professor;


@RequestScoped
public class ProfessorService {

	private ProfessorDAO professorDAO;
	
	@Inject
	public ProfessorService(ProfessorDAO professorDAO){
		this.professorDAO = professorDAO;
	}
	
	public ProfessorService(){
		this(null);
	}
	
	public void create(Professor professor){
		this.professorDAO.create(professor);
	}
	
	public Professor findByName(String name){
		return this.professorDAO.findByName(name);
	}
}
