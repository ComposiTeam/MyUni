package br.com.caelum.vraptor.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.dao.StudentDAO;
import br.com.caelum.vraptor.model.Student;
import br.com.caelum.vraptor.model.TranscriptOfRecords;

@RequestScoped
public class StudentService {
	
	private final static Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	private StudentDAO studentDAO;
	
	public StudentService()
	{
		this(null);
	}
	
	@Inject
	public StudentService(StudentDAO studentDAO){
		this.studentDAO = studentDAO;
	}
	
	public TranscriptOfRecords getTranscript(Student student){
		return this.studentDAO.getTranscript(student);
	}

	
}
