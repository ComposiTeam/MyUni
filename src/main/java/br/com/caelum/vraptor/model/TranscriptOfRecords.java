package br.com.caelum.vraptor.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class TranscriptOfRecords {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "transResults", joinColumns = @JoinColumn(name = "idTranscriptOfRecords"), 
			inverseJoinColumns = @JoinColumn(name = "idDisciplineResults"))
	private List<DisciplineResult> disciplineResults;
	
	@NotNull
	@Size(min = 4, max = 4)//Possible values: 2008 to 2015
	private int yearOfAdmission;
	
	@NotNull
	@Size(min = 1, max = 2) //Possible values: 1 to 16
	private int numberOfCompletedSemesters;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<DisciplineResult> getDisciplineResults() {
		return disciplineResults;
	}

	public void setDisciplineResults(List<DisciplineResult> disciplineResults) {
		this.disciplineResults = disciplineResults;
	}

	public int getYearOfAdmission() {
		return yearOfAdmission;
	}

	public void setYearOfAdmission(int yearOfAdmission) {
		this.yearOfAdmission = yearOfAdmission;
	}

	public int getNumberOfCompletedSemesters() {
		return numberOfCompletedSemesters;
	}

	public void setNumberOfCompletedSemesters(int numberOfCompletedSemesters) {
		this.numberOfCompletedSemesters = numberOfCompletedSemesters;
	}
	
}
