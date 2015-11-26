package br.com.caelum.vraptor.service.unb;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.model.unb.Campus;
import br.com.caelum.vraptor.util.test.MockResult;

public class CampusServiceTest {

	private MockResult mock;
	private CampusService mockCampusService;
	
	@Before
	public void setUp(){
		mock = new MockResult();
		mockCampusService = EasyMock.createNiceMock(CampusService.class);
	}
	
	@Test
	public void create() {
		Campus campus = new Campus();
		campus.setName("Test");
		mockCampusService.create(campus);
		System.out.println(campus.getId());
//		Assert.assertNotNull(campus.getId());
	}

}
