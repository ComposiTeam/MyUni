package br.com.caelum.vraptor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DisciplineResult {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private Mention mention;
	private int year;
	private int semester;	
	
	public DisciplineResult(Mention mention, int year, int semester) {
		this.mention = mention;
		this.year = year;
		this.semester = semester;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Mention getMention() {
		return mention;
	}
	
	public void setMention(Mention mention) {
		this.mention = mention;
	}
	
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
		this.semester = semester;
	}
	
}
