package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

@Controller
public class GradPlannerController {
	private final Result result;
	
	public GradPlannerController()
	{
		this(null);
	}
	
	@Inject
	public GradPlannerController(Result result)
	{
		this.result = result;
	}

	

}
