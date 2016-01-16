package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.model.Discipline;

public class DisciplineDAO extends AbstractDAO<Discipline> {

	@Override
	public Discipline getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discipline searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Discipline> list() {
		logger.info("The method list is goint to be executed ");
		String sql = "SELECT ALL d FROM Discipline d" ;
		logger.info("The sql used is " + sql);
		Query query = manager.createQuery(sql);
		
		List<Discipline> list = query.getResultList();
		logger.info("The number of elements returned is " + list.size());
		
		return list;
	}

	public Discipline findByCode(String disciplineCode) {
		try {
			Query query = manager.createQuery("SELECT discipline FROM Discipline discipline WHERE discipline.code=:value ");
			query.setParameter("value", disciplineCode);
			return (Discipline)query.getSingleResult();
		} catch (NonUniqueResultException exception){
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
	}

	public List<Discipline> listByInstitute(Long id) {
		try {
			Query query = manager.createQuery("SELECT distinct d FROM Discipline d join d.institutes i WHERE i.id=:value");
			query.setParameter("value", id);
			List r = query.getResultList();
			logger.info("The result return: " + r.size());
			return query.getResultList();
		} catch (NonUniqueResultException exception){
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
	}

}
