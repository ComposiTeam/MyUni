package br.com.caelum.vraptor.dao.unb;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.caelum.vraptor.dao.AbstractDAO;
import br.com.caelum.vraptor.model.unb.Campus;

public class CampusDAO extends AbstractDAO<Campus> {

	@Override
	public Campus getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Campus searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Campus findByCode(String code){
		try {
			Query query = manager.createQuery("SELECT campus FROM Campus campus WHERE campus.code=:value ");
			query.setParameter("value", code);
			return (Campus)query.getSingleResult();
		} catch (NonUniqueResultException exception){
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
	}
	
	public List<Campus> list(){
		CriteriaBuilder cr = this.manager.getCriteriaBuilder();
		CriteriaQuery<Campus> criteriaQuery = cr.createQuery(Campus.class);
		Root<Campus> root = criteriaQuery.from(Campus.class);
		criteriaQuery.select(root);
		TypedQuery<Campus> query = this.manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	

	
}
