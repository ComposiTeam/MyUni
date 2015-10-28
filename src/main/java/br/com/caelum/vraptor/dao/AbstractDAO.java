package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.controller.RegisterStudentController;

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
	
	public List<T> list() {
		logger.info("The method list is goint to be executed ");
		String sql = "SELECT ALL  FROM " + this.getClass().getName();
		logger.info("The sql used is " + sql);
		Query query = manager.createQuery(sql);
		
		List<T> list = query.getResultList();
		logger.info("The number of elements returned is " + list.size());
		
		return list;
	}
	
	
}
