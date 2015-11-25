package br.com.caelum.vraptor.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.com.caelum.vraptor.model.unb.Campus;

public class University extends Institution {
	
	private String acronym;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "universityCampus", joinColumns = @JoinColumn(name = "idUniversity"), 
			inverseJoinColumns = @JoinColumn(name = "idCampus"))
	private List<Campus> campus;
	
	public University(){
		super();
		this.campus = new ArrayList<Campus>();
	}
	
	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	public void addCampus(Campus camp){
		this.campus.add(camp);
	}
	
	
}
