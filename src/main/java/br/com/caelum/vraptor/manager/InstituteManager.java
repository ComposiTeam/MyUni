package br.com.caelum.vraptor.manager;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.model.unb.Campus;
import br.com.caelum.vraptor.model.unb.Institute;
import br.com.caelum.vraptor.service.unb.InstituteService;
import br.com.compositeam.unb.storage.DepartamentStorage;

public class InstituteManager implements DepartamentStorage {
	
	private static final Logger logger = LoggerFactory.getLogger(InstituteManager.class);
	private InstituteService instituteService;
	private Campus campus;
	
	
	
	@Inject
	public InstituteManager(InstituteService instituteService){
		this.instituteService = instituteService;
	}
	
	

	public Campus getCampus() {
		return campus;
	}



	public void setCampus(Campus campus) {
		this.campus = campus;
	}



	@Override
	public void saveDepartament(Map<String, String> data) {
		for(String key: data.keySet()){
			Institute institute = instituteService.findByCode(key);
			if(institute == null){
				String line = data.get(key);
				String[] pieces = line.split(",");
				institute = new Institute();
				institute.setCode(key);
				institute.setName(pieces[1]);
				this.campus.addInstitue(institute);
			}
		}
		
	}
}
