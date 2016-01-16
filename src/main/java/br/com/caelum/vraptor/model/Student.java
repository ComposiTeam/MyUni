package br.com.caelum.vraptor.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.caelum.vraptor.model.university.Program;

@Entity
public class Student extends Person {
	
	private String mwId;
	
	private String mwPassword;
	
	@OneToOne
	private Program program;

	public String getMwId() {
		return mwId;
	}

	public void setMwId(String mwId) {
		this.mwId = mwId;
	}

	public String getMwPassword() {
		return mwPassword;
	}

	public void setMwPassword(String mwPassword) {
		this.mwPassword = mwPassword;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	
	
	

}
