package br.com.caelum.vraptor.service;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.dao.DisciplineDAO;
import br.com.caelum.vraptor.model.Discipline;
import br.com.compositeam.unb.storage.OfferStorage;

@RequestScoped
public class DisciplineService implements OfferStorage {
	
	private final static Logger logger = LoggerFactory.getLogger(DisciplineService.class);
	
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

	@Override
	public void save(Map<String, String> data) {
		for(String key : data.keySet()){
			Discipline discipline = this.findByCode(key);
			if(discipline == null){
				discipline = new Discipline();
				discipline.setCode(key);
				discipline.setName(data.get(key));
				this.disciplineDAO.create(discipline);
			}
		}
	}

	public Discipline findByCode(String disciplineCode) {
		return this.disciplineDAO.findByCode(disciplineCode);
	}
}
