package br.com.caelum.vraptor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Semester {
	
	public static final int FIRST_SEMESTER = 1;
	
	public static final int SECOND_SEMESTER = 1;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	private int ano;
	
	private int semester;

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		if(semester == FIRST_SEMESTER || semester == SECOND_SEMESTER){
			this.semester = semester;
		}else{
			throw new NullPointerException("Semester is wrong");
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
