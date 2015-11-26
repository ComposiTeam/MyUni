package br.com.caelum.vraptor.service.unb;

import javax.inject.Inject;

import br.com.caelum.vraptor.dao.unb.CampusDAO;
import br.com.caelum.vraptor.model.unb.Campus;
import br.com.caelum.vraptor.service.AbstractService;

public class CampusService extends AbstractService<Campus> {

	@Inject
	public CampusService(CampusDAO campusDAO) {
		super(campusDAO);
		// TODO Auto-generated constructor stub
	}

}
