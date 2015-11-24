package br.com.caelum.vraptor.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.model.Course;
import br.com.caelum.vraptor.model.Discipline;
import br.com.caelum.vraptor.model.Institute;
import br.com.caelum.vraptor.model.Professor;
import br.com.caelum.vraptor.model.Time;
import br.com.caelum.vraptor.model.coursetime.Semester;
import br.com.caelum.vraptor.service.CourseService;
import br.com.caelum.vraptor.service.DisciplineService;
import br.com.caelum.vraptor.service.InstituteService;
import br.com.caelum.vraptor.service.SemesterService;
import br.com.compositeam.unb.CoursePage;
import br.com.compositeam.unb.OfferPage;
import br.com.compositeam.unb.storage.CampusStorage;
import br.com.compositeam.unb.storage.CourseStorage;

public class OfferExtractManager implements CourseStorage,CampusStorage {

	private static final Logger logger = LoggerFactory.getLogger(OfferExtractManager.class);
	private InstituteService instituteService;
	private DisciplineService disciplineService;
	private List<Institute> institutes;
	private Discipline disciplineExtracting = null;
	private CourseService courseService;
	private SemesterService semesterService;
	
	@Inject
	public OfferExtractManager(InstituteService instituteService, CourseService courseService, 
			DisciplineService disciplineService, SemesterService semesterService){
		this.instituteService = instituteService;
		this.courseService = courseService;
		this.disciplineService = disciplineService;
		this.semesterService = semesterService;
		this.institutes = new ArrayList<Institute>();
	}
	
	public OfferExtractManager(){
		this(null,null,null,null);
	}
	
	public void getData(){
		this.saveInsitituteDIP();
		this.saveDisciplines();
		
	}
	
	private void saveDisciplines(){
		for(Institute institute: institutes){
			OfferPage offer = new OfferPage(institute.getCode(),disciplineService);
			offer.extractData();
			offer.save();
			List<Discipline> disciplines = disciplineService.list();
			int i = 1;
			int total = disciplines.size();
			for(Discipline discipline: disciplines){
				logger.info("It is processing the discipline " + i + " of " + total);
				disciplineExtracting = discipline;
				CoursePage coursePage = new CoursePage(discipline.getCode(), institute.getCode(), this);
				coursePage.extractData();
				coursePage.save();
				i++;
			}
		}
	}
	
	private void saveInsitituteDIP(){
		Institute institute = new Institute();
		institute.setCode("410");
		institute.setName("Direção do Instituto de Psicologia");
		instituteService.create(institute);
		institutes.add(institute);
	}
	
	private void saveInsitituteFGA(){
		Institute institute = new Institute();
		institute.setCode("650");
		institute.setName("UnB - Faculdade do Gama");
		instituteService.create(institute);
		institutes.add(institute);
	}
	
	@Override
	public void save(Map<String, String> data) {
		// TODO Auto-generated method stub
		Semester semester = getSemester("2015/2");
		logger.info("Finded the semester");
		for(String clas : data.keySet()){
			logger.info("It is going to process the course");
			Course course = getCourse(semester, disciplineExtracting);
			if(course != null){
				logger.info("The coure already exists");
				continue;
			}else{
				course = new Course();
			}
			course.setSemester(semester);
			course.setDiscipline(disciplineExtracting);
			course.setDiscription(clas);
			logger.info("Discipline: " + disciplineExtracting.getName());
			String everything = data.get(clas);
			logger.info("Everything: " + everything);
			String[] piece = everything.split(",");
			logger.info("Pieces: " + piece.length );
			if(piece.length > 5){
				int times = Integer.parseInt(piece[3]);
				logger.info("Number of times Times " + times);
				for(int i = 4; i < times + 4; i++){
					logger.info("Time " + piece[i]);
					Time time = Time.getTime(piece[i]);
					course.addTime(time);
				}
				for(int i = times + 4; i < piece.length;i++){
					Professor professor = new Professor();
					logger.info("Professor: " + piece[i]);
					professor.setName(piece[i]);
					course.addProfessor(professor);
				}
				logger.info("The course is going to be saved");
				this.courseService.create(course);
			}else{
				logger.info("Pieces is less than 5");
			}
		}
		
		
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
	
	private Course getCourse(Semester semester, Discipline discipline){
		Course course = courseService.findCourse(semester, discipline);
		return course;
	}

	@Override
	public void saveCampus(Map<String, String> data) {
		// TODO Auto-generated method stub
		
	}

}
