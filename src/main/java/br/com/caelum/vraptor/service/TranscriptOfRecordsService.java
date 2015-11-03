package br.com.caelum.vraptor.service;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.dao.AbstractDAO;
import br.com.caelum.vraptor.dao.TranscriptOfRecordsDAO;
import br.com.caelum.vraptor.model.Course;
import br.com.caelum.vraptor.model.Discipline;
import br.com.caelum.vraptor.model.DisciplineResult;
import br.com.caelum.vraptor.model.Mention;
import br.com.caelum.vraptor.model.Semester;
import br.com.caelum.vraptor.model.Transcript;
import br.com.compositeam.unb.storage.TranscriptStorage;

public class TranscriptOfRecordsService extends AbstractDAO<Transcript> implements TranscriptStorage {

	private TranscriptOfRecordsDAO transcriptDAO;
	private static final Logger logger = LoggerFactory.getLogger(TranscriptOfRecordsService.class);
	private DisciplineService disciplineService;
	private SemesterService semesterService;
	private CourseService courseService;
	private MentionService mentionService;
	private Transcript transcript;
	private DisciplineResultService disciplineResultService;
	
	public TranscriptOfRecordsService() {
		this(null,null,null,null,null,null);
	}
	
	@Inject
	public TranscriptOfRecordsService(TranscriptOfRecordsDAO transcriptDAO, DisciplineService disciplineService,
			SemesterService semesterService, CourseService courseService, MentionService mentionService,DisciplineResultService disciplineResultService) {
		this.transcriptDAO = transcriptDAO;
		this.disciplineService = disciplineService;
		this.semesterService = semesterService;
		this.courseService = courseService;
		this.mentionService = mentionService;
		this.disciplineResultService = disciplineResultService;
	}

	@Override
	public Transcript getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	@Override
	public Transcript searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storage(Map<String, String> data) {
		for(String key: data.keySet()){
			Semester semester = getSemester(key);
			logger.info("It is going to take the text");
			String text = data.get(key);
			String[] d = text.split(",");
			logger.info("The size of the array: " + d.length);
			for(int i = 0; i < d.length; i++){
				Discipline dis;
				if( i % 3 == 0){
					DisciplineResult result = new DisciplineResult();
					logger.info("Discipline process");
					dis = this.disciplineService.findByCode(disciplineCode(d[i]));
					if(dis == null){
						dis = new Discipline();
						dis.setCode(disciplineCode(d[i]));
						logger.info("Name of discipline: " + d[i+1]);
						dis.setName(d[i+1]);
						this.disciplineService.create(dis);
					}
					logger.info("Finish the discipline process");
					logger.info("Course process");
					Course course = new Course();
					course.setDiscipline(dis);
					this.courseService.create(course);
					logger.info("Finished the course process");
					logger.info("Mention process");
					Mention mention = mentionService.findByAbreviation(d[i+2]);
					logger.info("Finished Mention process");
					logger.info("Result process");
					result.setSemester(semester);
					result.setCourse(course);
					result.setMention(mention);
					result.setTranscript(transcript);
					this.disciplineResultService.create(result);
					logger.info("Finished result process");
				}
				
			}
		}
		
	}
	
	private String disciplineCode(String text){
		String code = text.split("-")[1];
		logger.info("The code of the discipline is " + code);
		return code;
	}
	
	
	
	private Semester getSemester(String semester){
		int ster = Integer.parseInt(semester.substring(5));
		logger.info("The semester is " + ster);
		int year = Integer.parseInt(semester.substring(0,4));
		logger.info("The year is " + year);
		Semester s = this.semesterService.find(ster, year);
		logger.info("Result of query for searching a semester: " + s);
		if(s == null){
			s = new Semester();
			s.setSemester(ster);
			s.setYear(year);
			this.semesterService.create(s);
		}
		return s;
	}
	
	public void test(){
		Mention m = mentionService.findByAbreviation("MM");
		logger.info("Mention");
		logger.info("ID: " + m.getId() + " Description " + m.getDescription());
		Discipline d = disciplineService.findByCode("test");
		logger.info("Discipline");
		logger.info("Id " + d.getCode() + " Name" + d.getName());
		logger.info("Semester");
		Semester s = getSemester("2011/2");
		if(s!= null){
			logger.info("Semester " + s.getSemester() + " Year " + s.getYear() );
		}else{
			logger.info("Semester still null");
		}
	}
}
