package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractDAO<T> implements DAOInterface<T> {
	
	protected static final Logger logger = LoggerFactory.getLogger(AbstractDAO.class);
	
	@Inject 
	protected EntityManager manager;
	
	public void create(T entity){
		try{
			manager.persist(entity);
		}catch(Exception ex){
			logger.info("Cannot persist entity" + entity.getClass().getName() );
		}
	}
	
	public boolean update(T entity){
		try{
			manager.merge(entity);
			return true;
		}catch(Exception ex){
			logger.info("Cannot update entity" + entity.getClass().getName() );
		}
		return false;
	}
	
	public boolean destroy(T entity) {
		try {
			manager.remove(entity);
			return true;
		} catch (Exception exception) {
			logger.error("Cant remove an entity"  + entity.getClass().getName());
			return false;
		} 
	}
	
	public List<T> list(){
		T ob = null;
		logger.info("Class type: " + ob.getClass().getName());
		Class<T> c = null;
		try {
			c = (Class<T>) Class.forName(ob.getClass().getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CriteriaBuilder cr = this.manager.getCriteriaBuilder();
		
		CriteriaQuery<T> criteriaQuery = cr.createQuery(c);
		Root<T> root = criteriaQuery.from(c);
		criteriaQuery.select(root);
		TypedQuery<T> query = this.manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	
}
