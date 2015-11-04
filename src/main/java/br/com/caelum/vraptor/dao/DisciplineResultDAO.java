package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.model.DisciplineResult;
import br.com.caelum.vraptor.model.Mention;
import br.com.caelum.vraptor.model.Transcript;

public class DisciplineResultDAO extends AbstractDAO<DisciplineResult> {

	@Override
	public DisciplineResult getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisciplineResult searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<DisciplineResult> list(Transcript transcript){
		logger.info("It is going to be search the abreviation: " + transcript.getId());
		try {
			Query query = manager.createQuery("SELECT dr FROM DisciplineResult dr WHERE dr.transcript=:value ");
			query.setParameter("value", transcript);
			return (List<DisciplineResult>)query.getResultList();
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
	}

}
