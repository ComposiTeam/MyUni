package br.com.caelum.vraptor.adapter;

import br.com.caelum.vraptor.model.Discipline;

public class DisciplineAdapter {

	private Discipline discipline;
	
	private int semester;
	
	private boolean approved;
	
	public DisciplineAdapter(Discipline discipline, int semester, boolean aproved){
		this.discipline = discipline;
		this.semester = semester;
		this.approved = aproved;
	}
	
	public DisciplineAdapter(Discipline discipline, int semester){
		this(discipline,semester,false);
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	public String getDisciplineName(){
		return this.discipline.getName();
	}
	
	public String getDisciplineCode(){
		return this.discipline.getCode();
	}
	
	public String getDisciplineCredits(){
		return String.valueOf(this.discipline.getNumberOfCredits());
	}
	
}
