package br.com.caelum.vraptor.model;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.vraptor.model.coursetime.Year;

public class YearTest {

	
	@Test
	public void testYear() {
		Year year = new Year();
		year.setYear(1998);
		Assert.assertEquals(1998, year.getYear());
	}

}
