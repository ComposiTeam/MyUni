package br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import br.com.caelum.vraptor.model.TranscriptOfRecords;


public class TranscriptOfRecordsDAO implements DAOInterface<TranscriptOfRecords>{

	private static final Logger logger = LoggerFactory.getLogger(TranscriptOfRecordsDAO.class);
	
	@Inject
	private EntityManager manager;
	
	@Override
	public void create(TranscriptOfRecords entity) {
		logger.info("Creating the object Transcript of Records.");
		manager.persist(entity);
	}

	@Override
	public boolean update(TranscriptOfRecords entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean destroy(TranscriptOfRecords entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
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

	@Override
	public TranscriptOfRecords searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
