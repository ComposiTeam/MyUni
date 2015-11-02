package br.com.caelum.vraptor.service;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.dao.AbstractDAO;
import br.com.caelum.vraptor.dao.TranscriptOfRecordsDAO;
import br.com.caelum.vraptor.model.Course;
import br.com.caelum.vraptor.model.Discipline;
import br.com.caelum.vraptor.model.Semester;
import br.com.caelum.vraptor.model.TranscriptOfRecords;
import br.com.compositeam.unb.storage.TranscriptStorage;

public class TranscriptOfRecordsService extends AbstractDAO<TranscriptOfRecords> implements TranscriptStorage {

	private TranscriptOfRecordsDAO transcriptDAO;
	private static final Logger logger = LoggerFactory.getLogger(TranscriptOfRecordsService.class);
	private DisciplineService disciplineService;
	private SemesterService semesterService;
	private CourseService courseService;
	
	public TranscriptOfRecordsService() {
		this(null);
	}
	
	@Inject
	public TranscriptOfRecordsService(TranscriptOfRecordsDAO transcriptDAO) {
		this.transcriptDAO = transcriptDAO;
	}

	@Override
	public TranscriptOfRecords getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TranscriptOfRecords searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storage(Map<String, String> data) {
		for(String key: data.keySet()){
			Semester semester = getSemester(key);
			String text = data.get(key);
			String[] d = text.split(",");
			for(int i = 0; i < d.length; i++){
				Discipline dis;
				if( i % 3 == 0){
					dis = this.disciplineService.findByCode(disciplineCode(d[i]));
					if(dis == null){
						dis = new Discipline();
						dis.setCode(disciplineCode(d[i]));
						dis.setName(d[i+1]);
						this.disciplineService.create(dis);
					}
					Course course = new Course();
					course.setDiscipline(dis);
					this.courseService.create(course);
				}
				
			}
		}
		
	}
	
	private String disciplineCode(String text){
		String code = text.split("-")[1];
		return code;
	}
	
	
	
	private Semester getSemester(String semester){
		int ster = Integer.parseInt(semester.substring(0, 1));
		int year = Integer.parseInt(semester.substring(2));
		Semester s = this.semesterService.find(ster, year);
		if(s == null){
			s = new Semester();
			s.setSemester(ster);
			s.setYear(year);
			this.semesterService.create(s);
		}
		return s;
	}
}
