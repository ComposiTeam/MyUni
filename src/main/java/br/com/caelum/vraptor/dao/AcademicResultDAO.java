package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.model.Course;
import br.com.caelum.vraptor.model.AcademicResult;
import br.com.caelum.vraptor.model.Mention;
import br.com.caelum.vraptor.model.Transcript;
import br.com.caelum.vraptor.model.coursetime.Semester;

public class AcademicResultDAO extends AbstractDAO<AcademicResult> {

	@Override
	public AcademicResult getEntityByField(String field, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AcademicResult searchByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<AcademicResult> list(Transcript transcript) {
		logger.info("It is going to be search the abreviation: "
				+ transcript.getId());
		try {
			Query query = manager
					.createQuery("SELECT dr FROM DisciplineResult dr WHERE dr.transcript=:value ");
			query.setParameter("value", transcript);
			return (List<AcademicResult>) query.getResultList();
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
	}

	public AcademicResult find(Semester semester, Course course,
			Mention mention) {
		try {
			Query query = manager
					.createQuery("SELECT dr FROM DisciplineResult dr WHERE dr.semester=:value and dr.course =: va1 and dr.mention =: val2 ");
			query.setParameter("value", semester);
			query.setParameter("val1", course);
			query.setParameter("val2", mention);
			return (AcademicResult) query.getSingleResult();
		} catch (NonUniqueResultException exception) {
			logger.info(exception.getMessage());
			return null;
		} catch (NoResultException exception) {
			logger.info(exception.getMessage());
			return null;
		}
	}

}
