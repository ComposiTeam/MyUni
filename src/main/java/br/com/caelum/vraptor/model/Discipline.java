package br.com.caelum.vraptor.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "disciplinePrerequisite", joinColumns = @JoinColumn(name = "idDiscipline"), 
			inverseJoinColumns = @JoinColumn(name = "idRequisite"))
	public List<Discipline> requisites = new ArrayList<Discipline>();

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
	
	public void addDiscipline(Discipline discipline){
		if(discipline != null){
			this.requisites.add(discipline);
		}
	}
}
