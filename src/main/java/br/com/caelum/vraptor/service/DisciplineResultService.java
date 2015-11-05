package br.com.caelum.vraptor.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.dao.DisciplineResultDAO;
import br.com.caelum.vraptor.model.Course;
import br.com.caelum.vraptor.model.DisciplineResult;
import br.com.caelum.vraptor.model.Mention;
import br.com.caelum.vraptor.model.Semester;
import br.com.caelum.vraptor.model.Transcript;

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
	
	public List<DisciplineResult> list(Transcript transcript){
		return this.disciplineResultDAO.list(transcript);
	}

	public void update(DisciplineResult result) {
		this.disciplineResultDAO.update(result);
	}

	public DisciplineResult find(Semester semester, Course course,
			Mention mention) {
		return this.disciplineResultDAO.find(semester,course,mention);
	}

}
