package br.com.caelum.vraptor.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.model.Student;
import br.com.caelum.vraptor.model.Transcript;

@RequestScoped
public class StudentDAO extends AbstractDAO<Student> {
	
	@Inject 
	private EntityManager manager;
	


	@Override
	public Student getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Student searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Transcript getTranscript(Student student){
		try {
			Query query = manager.createQuery("select transcript FROM Transcript transcript WHERE transcript.student =:value ");
			query.setParameter("value", student);
			return (Transcript)query.getSingleResult();
		} catch (NonUniqueResultException exception){
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
	}

}
