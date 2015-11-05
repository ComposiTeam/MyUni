package br.com.caelum.vraptor.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.dao.MentionDAO;
import br.com.caelum.vraptor.model.Mention;

@RequestScoped
public class MentionService {

	private MentionDAO mentionDAO;
	
	@Inject
	public MentionService(MentionDAO mentionDAO){
		this.mentionDAO = mentionDAO;
	}
	
	public MentionService(){
		this(null);
	}
	
	public Mention findByAbreviation(String abreviation){
		return this.mentionDAO.findByAbreviation(abreviation);
	}
	
	public void create(Mention mention){
		this.mentionDAO.create(mention);
	}
}
