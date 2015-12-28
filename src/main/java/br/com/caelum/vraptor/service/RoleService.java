package br.com.caelum.vraptor.service;

import javax.inject.Inject;

import br.com.caelum.vraptor.dao.AbstractDAO;
import br.com.caelum.vraptor.dao.RoleDAO;
import br.com.caelum.vraptor.model.Role;

public class RoleService extends AbstractService<Role> {

	@Inject
	public RoleService(RoleDAO roleDAO) {
		super(roleDAO);
		// TODO Auto-generated constructor stub
	}
	
	public Role findByName(String role){
		RoleDAO r = (RoleDAO) this.dao;
		return r.findByName(role);
	}

}
