package br.com.caelum.vraptor.dao.university;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.caelum.vraptor.dao.AbstractDAO;
import br.com.caelum.vraptor.model.university.Program;

public class ProgramDAO extends AbstractDAO<Program> {

	@Override
	public Program getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Program searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Program> list() {
		CriteriaBuilder cr = this.manager.getCriteriaBuilder();
		CriteriaQuery<Program> criteriaQuery = cr.createQuery(Program.class);
		Root<Program> root = criteriaQuery.from(Program.class);
		criteriaQuery.select(root);
		TypedQuery<Program> query = this.manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	

}
