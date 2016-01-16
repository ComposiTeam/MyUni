package br.com.caelum.vraptor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.controller.professor.ProgramController;
import br.com.caelum.vraptor.model.coursetime.Semester;

@Entity
public class AcademicResult {

	private static final Logger logger = LoggerFactory.getLogger(AcademicResult.class);
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private Mention mention;
	
	@OneToOne
	private Semester semester;
	
	@OneToOne
	private Course course;
	
	@ManyToOne
	private Transcript transcript;
	
	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public AcademicResult(){
		
	}
	
	public AcademicResult(Mention mention, int year, int semester) {
		this.mention = mention;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Mention getMention() {
		return mention;
	}
	
	public void setMention(Mention mention) {
		this.mention = mention;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Discipline getDiscipline(){
		return this.course.getDiscipline();
	}
	
	public boolean approved(){
		boolean approved = false;
		if(this.mention.getAbreviation().equals(MentionEnum.SS.toString())
				|| this.mention.getAbreviation().equals(MentionEnum.MS.toString())
				|| this.mention.getAbreviation().equals(MentionEnum.MM.toString())){
			approved = true;
		}
		logger.info("The discipline is: " + approved);
		return approved;
	}
	
	
}
