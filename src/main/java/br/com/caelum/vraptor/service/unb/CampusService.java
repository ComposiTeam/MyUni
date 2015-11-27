package br.com.caelum.vraptor.service.unb;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import br.com.caelum.vraptor.dao.unb.CampusDAO;
import br.com.caelum.vraptor.model.unb.Campus;
import br.com.caelum.vraptor.service.AbstractService;
import br.com.compositeam.unb.storage.CampusStorage;

public class CampusService extends AbstractService<Campus> implements CampusStorage {

	@Inject
	public CampusService(CampusDAO campusDAO) {
		super(campusDAO);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveCampus(Map<String, String> data) {
		// TODO Auto-generated method stub
		for(String key: data.keySet()){
			Campus campus = findByCode(key);
			if(campus == null){
				campus = new Campus();
				campus.setCode(key);
				campus.setName(data.get(key));
				this.create(campus);
			}
		}
	}
	
	public List<Campus> list(){
		return this.dao.list();
	}
	
	public Campus findByCode(String code){
		CampusDAO d = (CampusDAO)this.dao;
		return d.findByCode(code);
	}

}
