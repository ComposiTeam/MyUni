package br.com.caelum.vraptor.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
@Entity
public class Course {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@OneToOne(optional = false)
	private Discipline discipline;
	
	private String discription;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "professorCourse", joinColumns = @JoinColumn(name = "idCourse"), 
			inverseJoinColumns = @JoinColumn(name = "idProfessor"))
	private List<Professor> professors;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	
	
	
}
