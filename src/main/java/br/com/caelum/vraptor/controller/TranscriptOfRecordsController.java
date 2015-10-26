package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.View;
import br.com.caelum.vraptor.model.TranscriptOfRecords;
import br.com.caelum.vraptor.service.TranscriptOfRecordsService;
import br.com.caelum.vraptor.validator.Validator;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class TranscriptOfRecordsController {

	private final Result result;
	private final Validator validator;
	private static final Logger logger = LoggerFactory.getLogger(TranscriptOfRecordsController.class);
	private final TranscriptOfRecordsService transcriptService;

	public TranscriptOfRecordsController(){
		this(null, null, null);
	}
	
	
	@Inject
	public TranscriptOfRecordsController(Result result, Validator validator, 
			TranscriptOfRecordsService transcriptService){
		this.result = result;
		this.transcriptService = transcriptService;
		this.validator = validator;
	}
	
	
	@Post
	@Path("/solicitateTranscriptRegistration")
	public void solicitateTranscriptRegistration(int periodOfAdmission, int yearOfAdmission){
		logger.debug("periodOfAdmission: " + periodOfAdmission + " yearOfAdmission:" +yearOfAdmission );
		result.redirectTo(this).registerTranscript(periodOfAdmission, yearOfAdmission);
	}


	@View
	@Path("/registerTranscript")
	private void registerTranscript(int periodOfAdmission, int yearOfAdmission) {
		
	}
	
	@Post	
	@Path("/registerTranscript")
	private void create( TranscriptOfRecords transcriptOfRecords){
		transcriptService.save(transcriptOfRecords);
		result.redirectTo(this).showTranscriptOfRecords();
		validator.onErrorForwardTo(IndexController.class).index();
	
	}


	private void showTranscriptOfRecords() {
		// TODO Auto-generated method stub
		
	}
	
}
