package br.com.caelum.vraptor.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Transcript {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idTranscript")
	private long id;
	
	@OneToOne(optional = false)
	private Student student;
	
	@OneToMany(mappedBy="transcript")
	private List<AcademicResult> results;
	
//	@NotNull
//	@Size(min = 4, max = 4)//Possible values: 2008 to 2015
	private int yearOfAdmission;
	
//	@NotNull
//	@Size(min = 1, max = 2) //Possible values: 1 to 16
	private int numberOfCompletedSemesters;
	
	public Transcript(){
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<AcademicResult> getResults() {
		return results;
	}

	public void setResults(List<AcademicResult> resulsts) {
		this.results = resulsts;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public List<Discipline> getDisciplines(){
		List<Discipline> disciplines = new ArrayList<Discipline>();
		for(AcademicResult ar : this.results){
			disciplines.add(ar.getDiscipline());
		}
		return disciplines;
	}
	
	public List<Discipline> getDisciplinesApproved(){
		List<Discipline> disciplines = new ArrayList<Discipline>();
		for(AcademicResult ar : this.results){
			if(ar.approved() == true){
				disciplines.add(ar.getDiscipline());
			}
		}
		return disciplines;
	}
	
	
	
}
