package br.com.caelum.vraptor.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.dao.SemesterDAO;
import br.com.caelum.vraptor.model.coursetime.Semester;

@RequestScoped
public class SemesterService {

private final static Logger logger = LoggerFactory.getLogger(DisciplineService.class);
	
	private final SemesterDAO semesterDAO;
	
	public SemesterService() {
		this(null);
	}
	
	@Inject
	public SemesterService(SemesterDAO semesterDAO) {
		this.semesterDAO = semesterDAO;
	}
	
	public void create(Semester semester){
		this.semesterDAO.create(semester);
	}
	
	public boolean exists(int semester, int year){
		return this.semesterDAO.exists(semester,year);
	}
	
	public Semester find(int semester, int year){
		return this.semesterDAO.find(semester, year);
	}

}
