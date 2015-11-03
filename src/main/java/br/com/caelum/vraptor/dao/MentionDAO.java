package br.com.caelum.vraptor.dao;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.model.Discipline;
import br.com.caelum.vraptor.model.Mention;

public class MentionDAO extends AbstractDAO<Mention> {

	@Override
	public Mention getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mention searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Mention findByAbreviation(String abreviation) {
		logger.info("It is going to be search the abreviation: " + abreviation);
		try {
			Query query = manager.createQuery("SELECT mention FROM Mention mention WHERE mention.abreviation=:value ");
			query.setParameter("value", abreviation);
			return (Mention)query.getSingleResult();
		} catch (NonUniqueResultException exception){
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
	}
	

}
