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
}
