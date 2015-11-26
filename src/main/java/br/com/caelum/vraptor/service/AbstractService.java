package br.com.caelum.vraptor.service;

import br.com.caelum.vraptor.dao.AbstractDAO;

public abstract class AbstractService<T> {
	
	protected AbstractDAO dao;
	
	public AbstractService(AbstractDAO dao){
		this.dao = dao;
	}
	
	public void create(T entity){
		this.dao.create(entity);
	}
}
