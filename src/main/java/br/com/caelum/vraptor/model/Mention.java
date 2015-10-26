package br.com.caelum.vraptor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mention {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="addressID")
	private long id;
	private String description;
	private String abreviation;
	private int weight;
	
	
	public Mention(String description, String abreviation, int weight) {		
		this.description = description;
		this.abreviation = abreviation;
		this.weight = weight;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAbreviation() {
		return abreviation;
	}
	
	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	
}
