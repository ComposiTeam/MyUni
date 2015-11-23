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
import br.com.caelum.vraptor.service.CourseService;
import br.com.caelum.vraptor.service.DisciplineService;
import br.com.caelum.vraptor.service.InstituteService;
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
	
	@Inject
	public OfferExtractManager(InstituteService instituteService, CourseService courseService, DisciplineService disciplineService){
		this.instituteService = instituteService;
		this.courseService = courseService;
		this.disciplineService = disciplineService;
		this.institutes = new ArrayList<Institute>();
	}
	
	public OfferExtractManager(){
		this(null,null,null);
	}
	
	public void getData(){
		this.saveInsititute();
		this.saveDisciplines();
		
	}
	
	private void saveDisciplines(){
		for(Institute institute: institutes){
			OfferPage offer = new OfferPage(institute.getCode(),disciplineService);
			offer.extractData();
			offer.save();
			List<Discipline> disciplines = disciplineService.list();
			for(Discipline discipline: disciplines){
				disciplineExtracting = discipline;
				CoursePage coursePage = new CoursePage(discipline.getCode(), institute.getCode(), this);
				coursePage.extractData();
				coursePage.save();
			}
		}
	}
	
	private void saveInsititute(){
		Institute institute = new Institute();
		institute.setCode("650");
		institute.setName("UnB - Faculdade do Gama");
		instituteService.create(institute);
		institutes.add(institute);
	}
	
	@Override
	public void save(Map<String, String> data) {
		// TODO Auto-generated method stub
		for(String clas : data.keySet()){
			Course course = new Course();
			logger.info("Discipline: " + disciplineExtracting.getName());
			course.setDiscipline(disciplineExtracting);
			course.setDiscription(clas);
			String everything = data.get(clas);
			logger.info("Everything: " + everything);
			String[] piece = everything.split(",");
			logger.info("Pieces: " + piece.length );
			int times = Integer.parseInt(piece[3]);
			logger.info("Number of times Times " + times);
			for(int i = 4; i < times + 4; i++){
				logger.info("Time " + piece[i]);
				Time time = Time.getTime(piece[i]);
				course.addTime(time);
			}
			for(int i = times + 3; i < piece.length;i++){
				Professor professor = new Professor();
				logger.info("Professor: " + piece[i]);
				professor.setName(piece[i]);
				course.addProfessor(professor);
			}
			this.courseService.create(course);
		}
		
		
	}

	@Override
	public void saveCampus(Map<String, String> data) {
		// TODO Auto-generated method stub
		
	}

}
