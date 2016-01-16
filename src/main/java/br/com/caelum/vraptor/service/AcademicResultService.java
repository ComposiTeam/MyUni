package br.com.caelum.vraptor.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.dao.AcademicResultDAO;
import br.com.caelum.vraptor.model.AcademicResult;
import br.com.caelum.vraptor.model.Course;
import br.com.caelum.vraptor.model.Mention;
import br.com.caelum.vraptor.model.Transcript;
import br.com.caelum.vraptor.model.coursetime.Semester;

@RequestScoped
public class AcademicResultService {
	
	private AcademicResultDAO academicResultDAO;
	
	@Inject
	public AcademicResultService(AcademicResultDAO academicResultDAO){
		this.academicResultDAO = academicResultDAO;
	}
	
	public AcademicResultService(){
		this(null);
	}
	
	public void create(AcademicResult disciplineResult){
		this.academicResultDAO.create(disciplineResult);
	}
	
	public List<AcademicResult> list(Transcript transcript){
		return this.academicResultDAO.list(transcript);
	}

	public void update(AcademicResult result) {
		this.academicResultDAO.update(result);
	}

	public AcademicResult find(Semester semester, Course course,
			Mention mention) {
		return this.academicResultDAO.find(semester,course,mention);
	}

}	
