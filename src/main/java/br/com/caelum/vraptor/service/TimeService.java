package br.com.caelum.vraptor.service;

import javax.inject.Inject;

import br.com.caelum.vraptor.dao.TimeDAO;
import br.com.caelum.vraptor.model.Time;

public class TimeService {
	
	private TimeDAO timeDAO;
	
	public TimeService()
	{
		this(null);
	}
	
	@Inject
	public TimeService(TimeDAO timeDAO){
		this.timeDAO = timeDAO;
	}
	
	public void create(Time time){
		this.timeDAO.create(time);
	}

}
