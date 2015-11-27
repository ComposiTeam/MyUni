package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.manager.UserManager;
import br.com.caelum.vraptor.model.Course;
import br.com.caelum.vraptor.model.Discipline;
import br.com.caelum.vraptor.model.coursetime.Semester;
import br.com.caelum.vraptor.model.unb.Institute;
import br.com.caelum.vraptor.service.CourseService;
import br.com.caelum.vraptor.service.DisciplineService;
import br.com.caelum.vraptor.service.SemesterService;
import br.com.caelum.vraptor.service.unb.InstituteService;
import br.com.caelum.vraptor.validator.Validator;
import br.com.compositeam.unb.OfferPage;

@Controller
public class DisciplineOfferController {
	private static final Logger logger = LoggerFactory.getLogger(DisciplineController.class);
	private final UserManager userManager;
	private final DisciplineService disciplineService;
	private final SemesterService semesterService;
	private final InstituteService instituteService;
	private final CourseService courseService;
	private final Result result;
	private Validator validator;
	
	public DisciplineOfferController(){
		this(null,null,null,null,null,null,null);
	}
	
	@Inject
	public DisciplineOfferController(UserManager userManager, DisciplineService disciplineDAO, Result result,
			SemesterService semesterService, CourseService courseService, 
			InstituteService instituteService, Validator validator) {
		super();
		this.userManager = userManager;
		this.result = result;
		this.disciplineService = disciplineDAO;
		this.validator = validator;
		this.semesterService = semesterService;
		this.instituteService = instituteService;
		this.courseService = courseService;
	}
	
	@Path("/oferta/{discipline.id}/{semester.id}")
	public void offer(Discipline discipline, Semester semester){
		List<Course> course = courseService.findCourses(semester, discipline);
		result.include("courses",course);
	}
}

