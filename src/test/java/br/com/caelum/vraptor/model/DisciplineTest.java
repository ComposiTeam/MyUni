package br.com.caelum.vraptor.model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DisciplineTest {

	public void setUp(){
		
	}
	
	@Test
	public void disciplineasyourprerequisite(){
		Discipline discipline1 = new Discipline();
		discipline1.setCode("10");
		discipline1.setName("Teste");
		Discipline discipline2 = new Discipline();
		discipline2.setCode("10");
		discipline2.setName("Teste");
		discipline1.addDiscipline(discipline2);
		Assert.assertEquals("A discipline cannot be your prerequisite",0, discipline1.numberPrerequisites());
	}
	
	@Test
	public void addprerequisite(){
		Discipline discipline1 = new Discipline();
		discipline1.setCode("10");
		discipline1.setName("Teste");
		Discipline discipline2 = new Discipline();
		discipline2.setCode("11");
		discipline2.setName("Teste");
		discipline1.addDiscipline(discipline2);
		Assert.assertEquals("A discipline cannot be your prerequisite",1, discipline1.numberPrerequisites());
	}
	
	@Test
	public void prerequisitecanbenull(){
		Discipline discipline1 = new Discipline();
		discipline1.setCode("10");
		discipline1.setName("Teste");
		discipline1.addDiscipline(null);
		Assert.assertEquals("A prerequisite should not be null",0, discipline1.numberPrerequisites());
	}
	

}
