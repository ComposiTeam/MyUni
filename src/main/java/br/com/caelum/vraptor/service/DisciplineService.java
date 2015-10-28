package br.com.caelum.vraptor.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.dao.DisciplineDAO;
import br.com.caelum.vraptor.model.Discipline;



@RequestScoped
public class DisciplineService {
	private final static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	private final DisciplineDAO disciplineDAO;
	
	public DisciplineService() {
		this(null);
	}
	
	@Inject
	public DisciplineService(DisciplineDAO disciplineDAO) {
		this.disciplineDAO = disciplineDAO;
	}
	
	public void create(Discipline discipline){
		logger.info("Discipline is going to be saved.");
		this.disciplineDAO.create(discipline);
		logger.info("Discipline was saved.");
	}
	
	public List<Discipline> list(){
		return disciplineDAO.list();
	}
}
