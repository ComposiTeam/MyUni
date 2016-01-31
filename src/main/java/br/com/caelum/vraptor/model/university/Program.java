package br.com.caelum.vraptor.model.university;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.adapter.DisciplineAdapter;
import br.com.caelum.vraptor.controller.AuthenticationController;
import br.com.caelum.vraptor.model.Discipline;


@Entity
public class Program {
	
	private static final Logger logger = LoggerFactory.getLogger(Program.class);
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	private String name;
	
	private int maxCreditsSemester;
	
	private int maxCredits;
	
	private int numSemesters;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "programSemester", joinColumns = @JoinColumn(name = "idProgram"), 
			inverseJoinColumns = @JoinColumn(name = "idSemesterProgram"))
	private Map<Integer,SemesterProgram> semesters = new HashMap<Integer, SemesterProgram>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) { 
		this.id = id;
	}
	
	

	public int getMaxCreditsSemester() {
		return maxCreditsSemester;
	}

	public void setMaxCreditsSemester(int maxCreditsSemester) {
		this.maxCreditsSemester = maxCreditsSemester;
	}

	public int getMaxCredits() {
		return maxCredits;
	}

	public void setMaxCredits(int maxCredits) {
		this.maxCredits = maxCredits;
	}

	public int getNumSemesters() {
		return numSemesters;
	}

	public void setNumSemesters(int numSemesters) {
		this.numSemesters = numSemesters;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public Map<Integer, SemesterProgram> getSemesters() {
		return semesters;
	}

	public void addDiscipline(int semester, Discipline discipline ){
		if(semester <= this.getNumSemesters() && semester > 0 ){
			if(semesters.containsKey(semester)){
				SemesterProgram sp = semesters.get(semester);
				sp.addDiscipline(discipline);
			}else{
				SemesterProgram sp = new SemesterProgram();
				sp.setNumber(semester);
				sp.addDiscipline(discipline);
				semesters.put(semester, sp);
			}
		}
	}
	
	public void beforeSave() throws Exception{
		Set<Integer> keys = new TreeSet<Integer>(semesters.keySet());
		logger.info("Number of keys: " + keys.size());
		for(Integer key: keys){
			logger.info("The key: " + key);
			SemesterProgram sp = semesters.get(key);
			List<Discipline> disciplines = sp.getDisciplines();
			logger.info("Disciplines in semester: " + disciplines.size());
			for(Discipline d : disciplines){
				logger.info("Prerequisites " + d.numberPrerequisites());
				if(d.numberPrerequisites() == 0){
					continue;
				}else{
					if(key == 1){
						logger.info("Exception throws because a discipline has prerequisites in the first semester");
						throw new Exception("Cannot have disciplines with prerequisites in the first semestere");
					}else{
						boolean has = checkPreRequisites(key, d.getRequisites());
						logger.info("Has beforesave: " + has);
						if(has == false){
							throw new Exception("The program does not have the prerequiste for the discipline" + d.getCode() + " " + d.getName());
						}
					}
				}
			}
		}
	}
	
	private boolean checkPreRequisites(int semester, List<Discipline> requisites){
		boolean has =  false;
		for(Discipline d : requisites){
			for(int i = semester - 1; i > 0; i--){
				if(hasPrerequite(i, d) == true ){
					has = true;
					break;
				}
			}
		}
		
		return has;
	}
	
	private boolean hasPrerequite(int semester,Discipline discipline){
		boolean has = false;
		SemesterProgram sp = semesters.get(semester);
		List<Discipline> disciplines = sp.getDisciplines();
		for(Discipline d : disciplines){
			logger.info("Disciplines code: " + d.getCode());
			if(d.getCode().equals(discipline.getCode())){
				has = true;
				break;
			}
		}
		logger.info("Has: " + has);
		return has;
	}
	
	public List<DisciplineAdapter> getDisciplines(){
		Set<Integer> keys = new TreeSet<Integer>(semesters.keySet());
		logger.info("Number of keys: " + keys.size());
		List<DisciplineAdapter> disciplines = new ArrayList<DisciplineAdapter>();
		for(Integer key: keys){
			SemesterProgram sp = semesters.get(key);
			List<Discipline> dis = sp.getDisciplines();
			for(Discipline d : dis){
				DisciplineAdapter da = new DisciplineAdapter(d, key);
				disciplines.add(da);
			}
		}
		return disciplines;
	}
	
	
	
	
}
