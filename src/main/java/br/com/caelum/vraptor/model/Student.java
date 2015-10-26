package br.com.caelum.vraptor.model;

import javax.persistence.Entity;

@Entity
public class Student extends Person {
	
	private String mwId;
	
	private String mwPassord;

	public String getMwId() {
		return mwId;
	}

	public void setMwId(String mwId) {
		this.mwId = mwId;
	}

	public String getMwPassord() {
		return mwPassord;
	}

	public void setMwPassord(String mwPassord) {
		this.mwPassord = mwPassord;
	}
	
	

}
