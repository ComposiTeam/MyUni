package br.com.caelum.vraptor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Semester {
	
	public static final int FIRST_SEMESTER = 1;
	
	public static final int SECOND_SEMESTER = 2;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	private int year;
	
	private int semester;

	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		if(semester == FIRST_SEMESTER || semester == SECOND_SEMESTER){
			this.semester = semester;
		}else{
			throw new NullPointerException("Semester is wrong. It should just be 1 or 2");
		} 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
