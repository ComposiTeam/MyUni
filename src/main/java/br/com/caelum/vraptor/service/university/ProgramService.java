package br.com.caelum.vraptor.service.university;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.dao.university.ProgramDAO;
import br.com.caelum.vraptor.model.university.Program;
import br.com.caelum.vraptor.service.AbstractService;

public class ProgramService extends AbstractService<Program> {

	@Inject
	public ProgramService(ProgramDAO programDAO) {
		super(programDAO);
		// TODO Auto-generated constructor stub
	}

	public List<Program> list() {
		ProgramDAO programDAO = (ProgramDAO)this.dao;
		return programDAO.list();
	}

}
