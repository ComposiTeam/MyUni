package br.com.caelum.vraptor.manager;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.dao.TranscriptOfRecordsDAO;
import br.com.caelum.vraptor.model.Course;
import br.com.caelum.vraptor.model.Discipline;
import br.com.caelum.vraptor.model.DisciplineResult;
import br.com.caelum.vraptor.model.Mention;
import br.com.caelum.vraptor.model.Semester;
import br.com.caelum.vraptor.model.Transcript;
import br.com.caelum.vraptor.service.CourseService;
import br.com.caelum.vraptor.service.DisciplineResultService;
import br.com.caelum.vraptor.service.DisciplineService;
import br.com.caelum.vraptor.service.MentionService;
import br.com.caelum.vraptor.service.SemesterService;
import br.com.caelum.vraptor.service.TranscriptService;
import br.com.compositeam.unb.storage.TranscriptStorage;

@RequestScoped
public class TranscriptExtractManager implements TranscriptStorage {
	
	private static final Logger logger = LoggerFactory.getLogger(TranscriptService.class);
	private DisciplineService disciplineService;
	private SemesterService semesterService;
	private CourseService courseService;
	private MentionService mentionService;
	private Transcript transcript;
	private DisciplineResultService disciplineResultService;
	
	public TranscriptExtractManager() {
		this(null,null,null,null,null);
	}
	
	@Inject
	public TranscriptExtractManager(DisciplineService disciplineService,
			SemesterService semesterService, CourseService courseService, MentionService mentionService,DisciplineResultService disciplineResultService) {
		this.disciplineService = disciplineService;
		this.semesterService = semesterService;
		this.courseService = courseService;
		this.mentionService = mentionService;
		this.disciplineResultService = disciplineResultService;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	@Override
	public void storage(Map<String, String> data) {
		if(transcript == null){
			throw new NullPointerException("Transcript cannot be null at transcript Manager");
		}
		for(String key: data.keySet()){
			Semester semester = getSemester(key);
			logger.info("It is going to take the text");
			String text = data.get(key);
			String[] dataPiace = text.split(",");
			logger.info("The size of the array: " + dataPiace.length);
			for(int i = 0; i < dataPiace.length; i++){
				if( i % 3 == 0){
					logger.info("Discipline process"); 
					Discipline dis;
					dis = getDiscipline(dataPiace[i], dataPiace[i+1]);
					logger.info("Finish the discipline process");
					logger.info("Course process");
					Course course = new Course();
					course.setDiscipline(dis);
					this.courseService.create(course);
					logger.info("Finished the course process");
					logger.info("Mention process");
					Mention mention = getMention(dataPiace[i+2]);
					logger.info("Finished Mention process");
					logger.info("Result process");
					DisciplineResult result = new DisciplineResult();
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
	
	private void resolveResult(Semester semester,Course course,Mention mention){
		boolean update = true;
		DisciplineResult result = this.disciplineResultService.find(semester,course,mention);
		if(result == null){
			result = new DisciplineResult();
			update = false;
		}
		result.setSemester(semester);
		result.setCourse(course);
		result.setMention(mention);
		result.setTranscript(transcript);
		if(update){
			this.disciplineResultService.update(result);
		}else{
			this.disciplineResultService.create(result);
		}
	}
	private String disciplineCode(String text){
		String code = text.split("-")[1];
		logger.info("The code of the discipline is " + code);
		return code;
	}
	
	private Discipline getDiscipline(String code, String name){
		String codeClean = disciplineCode(code); 
		Discipline dis = this.disciplineService.findByCode(codeClean);
		if(dis == null){
			dis = new Discipline();
			dis.setCode(codeClean);
			logger.info("Name of discipline: " + name);
			dis.setName(name);
			this.disciplineService.create(dis);
		}
		return dis;
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
	
	private Mention getMention(String abreviation){
		Mention mention = mentionService.findByAbreviation(abreviation);
		if(mention == null){
			logger.info("Mention should be not null");
			logger.info("It is possible that the bd has not been initialized correct");
			mention = new Mention();
			mention.setAbreviation(abreviation);
			mention.setDescription("Set in extract");
			mention.setWeight(2);
			mentionService.create(mention);
		}
		return mention;
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
