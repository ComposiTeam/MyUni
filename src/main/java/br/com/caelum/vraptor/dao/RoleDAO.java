package br.com.caelum.vraptor.dao;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.model.Role;
import br.com.caelum.vraptor.model.Transcript;

public class RoleDAO extends AbstractDAO<Role> {

	@Override
	public Role getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Role findByName(String role){
		try {
			Query query = manager.createQuery("select role FROM Role role WHERE role.name =:value ");
			query.setParameter("value", role);
			return (Role)query.getSingleResult();
		} catch (NonUniqueResultException exception){
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
	}

}
