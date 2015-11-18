package br.unb.questionario.service;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class QuestionarioApplication {
	private static QuestionarioApplication instance;
	public static QuestionarioApplication getInstance(){ return instance; }

	@EJB private CategoriaPerguntaService categoriaPerguntaService;
	
	public QuestionarioApplication(){
		instance = this;
	}
	
	public CategoriaPerguntaService getCategoriaPerguntaService(){
		return categoriaPerguntaService;
	}
}
