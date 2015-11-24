package br.com.caelum.vraptor.model.coursetime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class CourseTime {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	protected int year;
	
	protected int part;
	
	public CourseTime(){
		
	}
	
	public CourseTime(int year){
		setYear(year);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}
