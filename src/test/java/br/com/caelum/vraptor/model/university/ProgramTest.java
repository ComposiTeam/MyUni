package br.com.caelum.vraptor.model.university;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.vraptor.model.Discipline;

public class ProgramTest {

	
	
	
	
	@Test
	public void disciplineWithoutPrerequiste(){
		Discipline discipline1 = new Discipline();
		discipline1.setCode("10");
		discipline1.setName("Teste");
		discipline1.setNumberOfCredits(4);
		
		Discipline discipline2 = new Discipline();
		discipline2.setCode("11");
		discipline2.setName("Teste");
		discipline2.setNumberOfCredits(4);
		discipline2.addDiscipline(discipline1);
		
		Discipline discipline3 = new Discipline();
		discipline3.setCode("12");
		discipline3.setName("Teste");
		discipline3.setNumberOfCredits(4);
		
		Program program = new Program();
		program.setMaxCredits(100);
		program.setMaxCreditsSemester(30);
		program.setNumSemesters(2);
		program.addDiscipline(1, discipline3);
		program.addDiscipline(2, discipline2);
		try{
			program.beforeSave();
			Assert.fail();
		}catch(Exception ex){
			Assert.assertTrue("It is correct", true);
		}
	}
	
	
	@Test
	public void disciplineWithPrerequiste(){
		Discipline discipline1 = new Discipline();
		discipline1.setCode("10");
		discipline1.setName("Teste");
		discipline1.setNumberOfCredits(4);
		
		Discipline discipline2 = new Discipline();
		discipline2.setCode("11");
		discipline2.setName("Teste");
		discipline2.setNumberOfCredits(4);
		discipline2.addDiscipline(discipline1);
		
		Discipline discipline3 = new Discipline();
		discipline3.setCode("12");
		discipline3.setName("Teste");
		discipline3.setNumberOfCredits(4);
		
		Program program = new Program();
		program.setMaxCredits(100);
		program.setMaxCreditsSemester(30);
		program.setNumSemesters(2);
		program.addDiscipline(1, discipline3);
		program.addDiscipline(1, discipline1);
		program.addDiscipline(2, discipline2);
		try{
			program.beforeSave();
			Assert.assertTrue("It is correct", true);
		}catch(Exception ex){
			Assert.fail();
		}
	}
	
	@Test
	public void disciplineWithPrerequisteInFirstSemester(){
		Discipline discipline1 = new Discipline();
		discipline1.setCode("10");
		discipline1.setName("Teste");
		discipline1.setNumberOfCredits(4);
		
		Discipline discipline2 = new Discipline();
		discipline2.setCode("11");
		discipline2.setName("Teste");
		discipline2.setNumberOfCredits(4);
		discipline2.addDiscipline(discipline1);
		
		Discipline discipline3 = new Discipline();
		discipline3.setCode("12");
		discipline3.setName("Teste");
		discipline3.setNumberOfCredits(4);
		
		Program program = new Program();
		program.setMaxCredits(100);
		program.setMaxCreditsSemester(30);
		program.setNumSemesters(2);
		program.addDiscipline(2, discipline3);
		program.addDiscipline(2, discipline1);
		program.addDiscipline(1, discipline2);
		try{
			program.beforeSave();
			Assert.fail();
		}catch(Exception ex){
			Assert.assertTrue("It is correct", true);
		}
	}

}
