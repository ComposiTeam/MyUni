package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.model.TranscriptOfRecords;

@RequestScoped
public class TranscriptOfRecordsDAO {

	private static Logger logger = LoggerFactory.getLogger(TranscriptOfRecordsDAO.class);
	
	@Inject
	private EntityManager manager;
	
	/*CDI only*/
	public TranscriptOfRecordsDAO()
	{
		this(null);
	}
	
	@Inject
	public TranscriptOfRecordsDAO(Logger logger)
	{
		TranscriptOfRecordsDAO.logger = logger;
	}
	
	
	public void create(TranscriptOfRecords entity) {
		logger.info("Creating the object Transcript of Records.");
		manager.persist(entity);
	}

	
	public boolean update(TranscriptOfRecords entity) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean destroy(TranscriptOfRecords entity) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public TranscriptOfRecords getEntityByField(String field, Object object) {
		logger.debug("field." + field + "=" +object );
		
		String sqlQuery = "SELECT transcriptOfRecords FROM "+ TranscriptOfRecords.class.getName() +" transcriptOfRecords"
				+ " WHERE transcriptOfRecords." + object + "=:value";
		
		logger.info("The created sql is: " + sqlQuery);
		
		try {
			Query query = manager.createQuery(sqlQuery);
			query.setParameter("object", object);
			return (TranscriptOfRecords) query.getSingleResult();
		} catch (NonUniqueResultException exception){
			throw new NonUniqueResultException();
		} catch (NoResultException exception) {
			return null;
		}
	
	}


	public TranscriptOfRecords searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	

	
	
}
