package br.com.caelum.vraptor.dao;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.model.Professor;

public class ProfessorDAO extends AbstractDAO<Professor> {

	@Override
	public Professor getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

    public Professor findByName(String name){
        try {
			Query query = manager.createQuery("select person FROM Person person WHERE person.name =:value");
			query.setParameter("value", name);
			return (Professor)query.getSingleResult();
		} catch (NonUniqueResultException exception){
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
    }

}
