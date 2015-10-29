package br.com.caelum.vraptor.dao;

import java.util.List;

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

}
