package br.com.caelum.vraptor.manager;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.model.Discipline;
import br.com.caelum.vraptor.model.unb.Institute;
import br.com.caelum.vraptor.service.DisciplineService;
import br.com.compositeam.unb.storage.OfferStorage;

public class DisciplineManager implements OfferStorage {
	private static final Logger logger = LoggerFactory.getLogger(DisciplineManager.class);
	private DisciplineService disciplineService;
	private Institute institute;
	
	
	
	@Inject
	public DisciplineManager(DisciplineService disciplineService){
		this.disciplineService = disciplineService;
	}
	
	@Override
	public void save(Map<String, String> data) {
		for(String key : data.keySet()){
			Discipline discipline = disciplineService.findByCode(key);
			if(discipline == null){
				discipline = new Discipline();
				discipline.setCode(key);
				discipline.setName(data.get(key));
			}
			institute.addDiscipline(discipline);
		}
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	
	
	
}
