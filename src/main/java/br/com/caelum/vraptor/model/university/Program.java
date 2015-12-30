package br.com.caelum.vraptor.model.university;

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
public class Program {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "programDiscipline", joinColumns = @JoinColumn(name = "idProgram"), 
			inverseJoinColumns = @JoinColumn(name = "idDiscipline"))
	private List<Discipline> disciplines = new ArrayList<Discipline>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addDiscipline(Discipline discipline){
		this.disciplines.add(discipline);
	}
	
	
}
