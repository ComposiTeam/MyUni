package br.com.caelum.vraptor.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.dao.TranscriptOfRecordsDAO;
import br.com.caelum.vraptor.model.TranscriptOfRecords;

public class TranscriptOfRecordsService {

	private TranscriptOfRecordsDAO transcriptDAO;
	private static final Logger logger = LoggerFactory.getLogger(TranscriptOfRecordsService.class);
	
	public TranscriptOfRecordsService() {
		this(null);
	}
	
	@Inject
	public TranscriptOfRecordsService(TranscriptOfRecordsDAO transcriptDAO) {
		this.transcriptDAO = transcriptDAO;
	}

	public void save(TranscriptOfRecords transcriptOfRecords) {
		transcriptDAO.create(transcriptOfRecords);
		logger.info("The transcript of records was successfully saved");
	}
}
