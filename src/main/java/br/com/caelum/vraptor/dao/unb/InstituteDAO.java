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
import br.com.caelum.vraptor.model.unb.Institute;

public class InstituteDAO extends AbstractDAO<Institute> {

	@Override
	public Institute getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Institute searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Institute findByCode(String code) {
		try {
			Query query = manager.createQuery("SELECT institute FROM Institute institute WHERE institute.code=:value ");
			query.setParameter("value", code);
			return (Institute)query.getSingleResult();
		} catch (NonUniqueResultException exception){
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
	}
	
	public List<Institute> findByCampus(Campus campus) {
		try {
			Query query = manager.createQuery("SELECT distinct i FROM Institute i join i.campus c WHERE c.id=:value");
			query.setParameter("value", campus.getId());
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
	
	public List<Institute> list(){
		CriteriaBuilder cr = this.manager.getCriteriaBuilder();
		CriteriaQuery<Institute> criteriaQuery = cr.createQuery(Institute.class);
		Root<Institute> root = criteriaQuery.from(Institute.class);
		criteriaQuery.select(root);
		TypedQuery<Institute> query = this.manager.createQuery(criteriaQuery);
		return query.getResultList();
	}

}
