package br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.controller.RegisterStudentController;

public abstract class AbstractDAO<T> implements DAOInterface<T> {
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractDAO.class);
	@Inject 
	private EntityManager manager;
	
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
	
	
}
