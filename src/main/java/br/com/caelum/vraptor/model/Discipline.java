package br.com.caelum.vraptor.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.caelum.vraptor.model.unb.Institute;

@Entity
public class Discipline {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(unique = true)
	private String code;
	
	private String name;
	
	private int NumberOfCredits;
	
	@ManyToMany(mappedBy = "disciplines")
	private List<Institute> institutes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfCredits() {
		return NumberOfCredits;
	}

	public void setNumberOfCredits(int numberOfCredits) {
		NumberOfCredits = numberOfCredits;
	}

	public List<Institute> getInstitutes() {
		return institutes;
	}

	public void setInstitutes(List<Institute> institutes) {
		this.institutes = institutes;
	}
	
	
}
