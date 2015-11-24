package br.com.caelum.vraptor.model.coursetime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Semester extends CourseTime {
	
	public static final int FIRST_SEMESTER = 1;
	
	public static final int SECOND_SEMESTER = 2;	

	public int getSemester() {
		return this.part;
	}

	public void setSemester(int semester) {
		if(semester == FIRST_SEMESTER || semester == SECOND_SEMESTER){
			this.part = semester;
		}else{
			throw new NullPointerException("Semester is wrong. It should just be 1 or 2");
		} 
	}
	
}
