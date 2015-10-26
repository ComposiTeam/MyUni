package br.com.caelum.vraptor.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.model.Student;

@RequestScoped
public class StudentDAO {
	
	@Inject 
	private EntityManager manager;
	
	
	public void add(Student student){
		manager.persist(student);
	}

}
