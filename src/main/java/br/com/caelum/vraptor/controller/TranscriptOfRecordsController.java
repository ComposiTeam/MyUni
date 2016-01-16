package br.com.caelum.vraptor.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.View;
import br.com.caelum.vraptor.model.Transcript;
import br.com.caelum.vraptor.service.TranscriptService;
import br.com.caelum.vraptor.validator.Validator;


@Controller
public class TranscriptOfRecordsController {

	private final Result result;
	private final Validator validator;
	private static final Logger logger = LoggerFactory.getLogger(TranscriptOfRecordsController.class);
	private final TranscriptService transcriptService;

	public TranscriptOfRecordsController(){
		this(null, null, null);
	}
	
	
	@Inject
	public TranscriptOfRecordsController(Result result, Validator validator, 
			TranscriptService transcriptService){
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
	private void create( Transcript transcriptOfRecords){
		transcriptService.create(transcriptOfRecords);
		result.redirectTo(this).showTranscriptOfRecords();
		validator.onErrorForwardTo(IndexController.class).index();
	
	}


	private void showTranscriptOfRecords() {
		// TODO Auto-generated method stub
		
	}
	
}
