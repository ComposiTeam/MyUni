package br.com.caelum.vraptor.model.unb;

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

import br.com.caelum.vraptor.model.Discipline;

@Entity
public class Institute {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(unique = true)
	private String code;

	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "institutesDisciplines", joinColumns = @JoinColumn(name = "idInstitute"), inverseJoinColumns = @JoinColumn(name = "idDiscipline"))
	private List<Discipline> disciplines;

	@ManyToMany(mappedBy="institutes")
	private List<Campus> campus;
	
	public Institute() {
		disciplines = new ArrayList<Discipline>();
	}

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

	public void addDiscipline(Discipline discipline) {
		this.disciplines.add(discipline);
	}

	public List<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	public List<Campus> getCampus() {
		return campus;
	}

	public void setCampus(List<Campus> campus) {
		this.campus = campus;
	}
	
	

}
