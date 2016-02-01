package br.com.caelum.vraptor.model;

import org.junit.Assert;
import org.junit.Test;


public class TimeTest {

	@Test
	public void testConstructor(){
		String test = "Sexta 08:00    09:50";
		Time time = Time.getTime(test);
		Assert.assertEquals(time.getDay(), "Sexta");
		Assert.assertEquals(time.getBegin(), "08:00");
		Assert.assertEquals("09:50",time.getEnd());
	}
	
	@Test
	public void testEquals(){
		Time time1 = new Time();
		time1.setBegin("8:00");
		time1.setEnd("10:00");
		time1.setDay("Segunda");
		Time time2 = new Time();
		time2.setBegin("8:00");
		time2.setEnd("10:00");
		time2.setDay("Segunda");
		Assert.assertTrue(time1.equals(time2));
	}
}
