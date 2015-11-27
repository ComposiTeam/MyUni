package br.com.caelum.vraptor.model.unb;

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
public class Institute {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(unique = true)
	private String code;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "insitutesDisciplines", joinColumns = @JoinColumn(name = "idInstitue"), 
			inverseJoinColumns = @JoinColumn(name = "idDiscipline"))
	private List<Discipline> disciplines;

	public Institute(){
		disciplines = new ArrayList<Discipline>();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addDiscipline(Discipline discipline){
		this.disciplines.add(discipline);
	}
	
	

}
