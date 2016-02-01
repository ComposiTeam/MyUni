package br.com.caelum.vraptor.model;

import java.util.ArrayList;

public class Grade {
	
	
	ArrayList<Course> courses;
	
	
	public Grade(){
		courses = new ArrayList<Course>();
	}
	
	public Grade(ArrayList<Course> courses){
		this.courses = courses;
	}
	
	public ArrayList<Course> getGrade(ArrayList<Time> times){
		ArrayList<Course> possiblecourses = new ArrayList<Course>();
		for(Course c: courses){
			int num = 0;
			for(Time t: c.getTimes()){
				if(times.contains(t)){
					num++;
				}
			}
			if(num == c.getTimes().size()){
				possiblecourses.add(c);
			}
		}
		return possiblecourses;
	}
	
	

}
