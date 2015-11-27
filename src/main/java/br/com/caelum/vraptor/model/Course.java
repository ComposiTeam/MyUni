package br.com.caelum.vraptor.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import br.com.caelum.vraptor.model.coursetime.Semester;
@Entity
public class Course {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@ManyToOne(optional = false)
	private Discipline discipline;
	
	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "professorCourse", joinColumns = @JoinColumn(name = "idCourse"), 
			inverseJoinColumns = @JoinColumn(name = "idProfessor"))
	private List<Professor> professors;
	
	@ManyToOne(optional = false)
	private Semester semester;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "timesCourse", joinColumns = @JoinColumn(name = "idCourse"), 
			inverseJoinColumns = @JoinColumn(name = "idTime"))
	private List<Time> times;

	public Course(){
		this.times = new ArrayList<Time>();
		this.professors = new ArrayList<Professor>();
	}
	
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


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public void addTime(Time time){
		this.times.add(time);
	}
	
	public void addProfessor(Professor professor){
		this.professors.add(professor);
	}
	
	
}
