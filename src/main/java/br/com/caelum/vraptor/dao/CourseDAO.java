package br.com.caelum.vraptor.dao;


import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.model.Course;
import br.com.caelum.vraptor.model.Discipline;
import br.com.caelum.vraptor.model.coursetime.Semester;

public class CourseDAO extends AbstractDAO<Course> {


	@Override
	public Course getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Course findCourse(Semester semester, Discipline discipline) {
		try {
			Query query = manager.createQuery("SELECT course FROM Course course WHERE course.semester=:value and course.discipline=:value1");
			query.setParameter("value", semester);
			query.setParameter("value1", discipline);
			return (Course)query.getSingleResult();
		} catch (NonUniqueResultException exception){
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
	}
	
	

}
