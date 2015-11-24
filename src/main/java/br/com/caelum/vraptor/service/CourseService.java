package br.com.caelum.vraptor.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.dao.CourseDAO;
import br.com.caelum.vraptor.model.Course;
import br.com.caelum.vraptor.model.Discipline;
import br.com.caelum.vraptor.model.coursetime.Semester;

@RequestScoped
public class CourseService {

	private CourseDAO courseDAO;
	
	@Inject
	public CourseService(CourseDAO courseDAO){
		this.courseDAO = courseDAO;
	}
	
	public CourseService(){
		this(null);
	}
	
	public void create(Course course){
		this.courseDAO.create(course);
	}
	
	public Course findCourse(Semester semester, Discipline discipline){
		return this.courseDAO.findCourse(semester, discipline);
	}
}
