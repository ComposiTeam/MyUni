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
public class SemesterProgram {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	private int number;
	
	private int numberCredits;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "semesterDiscipline", joinColumns = @JoinColumn(name = "idSemester"), 
			inverseJoinColumns = @JoinColumn(name = "idDiscipline"))
	private List<Discipline> disciplines = new ArrayList<Discipline>();
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}
	
	public int numberCredits(){
		return this.numberCredits;
	}



	public void addDiscipline(Discipline discipline){
		if(discipline != null){
			this.disciplines.add(discipline);
			this.numberCredits += discipline.getNumberOfCredits();
		}
	}



	public int getNumberCredits() {
		return numberCredits;
	}



	public List<Discipline> getDisciplines() {
		return disciplines;
	}
	
	
}
