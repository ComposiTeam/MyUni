package br.com.caelum.vraptor.model;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class GradeTest {

	@Test
	public void test() {
		// couse1
		Time time1 = new Time();
		time1.setBegin("8:00");
		time1.setEnd("10:00");
		time1.setDay("Segunda");
		Time time2 = new Time();
		time2.setBegin("8:00");
		time2.setEnd("10:00");
		time2.setDay("Quarta");
		Time time3 = new Time();
		time3.setBegin("8:00");
		time3.setEnd("10:00");
		time3.setDay("Sexta");
		Discipline discipline1 = new Discipline();
		discipline1.setCode("10");
		discipline1.setName("Teste");
		Course c1 = new Course();
		c1.setDiscipline(discipline1);
		c1.setDescription("A");
		ArrayList<Time> timec1 = new ArrayList<Time>();
		timec1.add(time1);
		timec1.add(time3);
		timec1.add(time2);
		c1.setTimes(timec1);

		// course2
		Time time4 = new Time();
		time4.setBegin("10:00");
		time4.setEnd("12:00");
		time4.setDay("Segunda");
		Time time5 = new Time();
		time5.setBegin("10:00");
		time5.setEnd("12:00");
		time5.setDay("Quarta");
		Time time6 = new Time();
		time6.setBegin("10:00");
		time6.setEnd("12:00");
		time6.setDay("Sexta");
		Discipline discipline2 = new Discipline();
		discipline2.setCode("11");
		discipline2.setName("Teste");
		Course c2 = new Course();
		c2.setDiscipline(discipline2);
		c2.setDescription("B");
		ArrayList<Time> timec2 = new ArrayList<Time>();
		timec2.add(time4);
		timec2.add(time5);
		timec2.add(time6);
		c2.setTimes(timec2);

		// course3
		Time time7 = new Time();
		time7.setBegin("10:00");
		time7.setEnd("12:00");
		time7.setDay("Terca");
		Time time8 = new Time();
		time8.setBegin("10:00");
		time8.setEnd("12:00");
		time8.setDay("Terca");
		Discipline discipline3 = new Discipline();
		discipline3.setCode("11");
		discipline3.setName("Teste");
		Course c3 = new Course();
		c3.setDiscipline(discipline3);
		c3.setDescription("B");
		ArrayList<Time> timec3 = new ArrayList<Time>();
		timec3.add(time7);
		timec3.add(time8);
		c3.setTimes(timec3);

		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);

		Grade grade = new Grade(courses);
		ArrayList<Course> c = grade.getGrade(timec3);
		Assert.assertEquals(1, c.size());
	}

}
