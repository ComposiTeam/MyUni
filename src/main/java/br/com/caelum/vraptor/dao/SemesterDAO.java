package br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.model.Student;
import br.com.caelum.vraptor.model.Transcript;
import br.com.caelum.vraptor.model.coursetime.Semester;

public class SemesterDAO extends AbstractDAO<Semester> {

	@Override
	public Semester getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Semester searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists(int semester, int year) {
		try {
			Query query = manager.createQuery("SELECT s FROM Semester s WHERE s.year=:value AND s.part=:val ");
			query.setParameter("value", year);
			query.setParameter("val", semester);
			if(query.getResultList().size() == 1){
				return true;
			}else{
				logger.info("Size of results: " + query.getResultList().size());
				return false;
			}
		}  catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return false;
		}
	}
	
	public Semester find(int semester, int year){
		try {
			Query query = manager.createQuery("select semester FROM Semester semester WHERE semester.year=:value and semester.part=:val ");
			query.setParameter("value", year);
			query.setParameter("val", semester);
			return (Semester)query.getSingleResult();
		} catch (NonUniqueResultException exception){
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
	}

	

}
