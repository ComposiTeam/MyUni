package br.com.caelum.vraptor.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.model.Course;
import br.com.caelum.vraptor.model.Discipline;
import br.com.caelum.vraptor.model.Professor;
import br.com.caelum.vraptor.model.Time;
import br.com.caelum.vraptor.model.User;
import br.com.caelum.vraptor.model.coursetime.Semester;
import br.com.caelum.vraptor.model.unb.Institute;
import br.com.caelum.vraptor.service.CourseService;
import br.com.caelum.vraptor.service.DisciplineService;
import br.com.caelum.vraptor.service.SemesterService;
import br.com.caelum.vraptor.service.UserService;
import br.com.caelum.vraptor.service.ProfessorService;
import br.com.caelum.vraptor.service.unb.InstituteService;
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
	private UserService userService;
    private ProfessorService professorService;

	@Inject
	public OfferExtractManager(InstituteService instituteService, CourseService courseService, 
			DisciplineService disciplineService, SemesterService semesterService,
			UserService userService, ProfessorService professorService ){
		this.instituteService = instituteService;
		this.courseService = courseService;
		this.disciplineService = disciplineService;
		this.semesterService = semesterService;
		this.institutes = new ArrayList<Institute>();
		this.userService = userService;
        this.professorService = professorService;
	}
	
	public OfferExtractManager(){
		this(null,null,null,null,null,null);
	}
	
	public void getData(){
		this.saveDisciplines();
		
	}
	
	
	
	public List<Institute> getInstitutes() {
		return institutes;
	}

	public void setInstitutes(List<Institute> institutes) {
		this.institutes = institutes;
	}

	private void saveDisciplines(){
		for(Institute institute: institutes){
			List<Discipline> disciplines = institute.getDisciplines();
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
	
	
	@Override
	public void save(Map<String, String> data) {
		// TODO Auto-generated method stub
		Semester semester = getSemester("2015/2");
		User user = getDefaultUser();
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
			course.setDescription(clas);
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
					String professorName = piece[i];
                    logger.info("Professor: " + piece[i]);
					Professor professor = professorService.findByName(professorName);
                    if(professor == null){
                        professor = new Professor();
					    professor.setName(piece[i]);
					    professor.setUser(user);
                    }
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
	
	private User getDefaultUser(){
		return userService.getUser("default");
	}

	@Override
	public void saveCampus(Map<String, String> data) {
		// TODO Auto-generated method stub
		
	}

}
