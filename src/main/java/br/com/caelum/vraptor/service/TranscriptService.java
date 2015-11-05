package br.com.caelum.vraptor.service;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.dao.AbstractDAO;
import br.com.caelum.vraptor.dao.TranscriptOfRecordsDAO;
import br.com.caelum.vraptor.model.Transcript;

public class TranscriptService extends AbstractDAO<Transcript>  {

	private TranscriptOfRecordsDAO transcriptDAO;
	private static final Logger logger = LoggerFactory.getLogger(TranscriptService.class);
	
	public TranscriptService() {
		this(null);
	}
	
	@Inject
	public TranscriptService(TranscriptOfRecordsDAO transcriptDAO) {
		logger.info("Class is going to be created");
		this.transcriptDAO = transcriptDAO;
	}

	@Override
	public Transcript getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void create(Transcript transcript){
		this.transcriptDAO.create(transcript);
	}
	
	@Override
	public Transcript searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
