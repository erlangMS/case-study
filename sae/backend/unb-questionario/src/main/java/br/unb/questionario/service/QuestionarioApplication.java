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
	@EJB private PerguntaService perguntaService;
	@EJB private QuestionarioService questionarioService;
	@EJB private TipoQuestionarioService tipoQuestionarioService;
	
	public QuestionarioApplication(){
		instance = this;
	}
	
	public CategoriaPerguntaService getCategoriaPerguntaService(){
		return categoriaPerguntaService;
	}
	
	public PerguntaService getPerguntaService(){
		return perguntaService;
	}

	public QuestionarioService getQuestionarioService() {
		return questionarioService;
	}

	public TipoQuestionarioService getTipoQuestionarioService() {
		return tipoQuestionarioService;
	}

	
	
}
