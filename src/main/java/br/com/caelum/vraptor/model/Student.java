package br.com.caelum.vraptor.model;

import javax.persistence.Entity;

@Entity
public class Student extends Person {
	
	private String mwId;
	
	private String mwPassword;

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

	
	
	

}
