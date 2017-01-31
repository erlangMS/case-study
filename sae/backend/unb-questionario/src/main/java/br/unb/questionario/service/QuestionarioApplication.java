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
	@EJB private OpcaoService opcaoService;
	@EJB private RespostaService respostaService;
	@EJB private RespostaItemService respostaItemService;
	
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

	public OpcaoService getOpcaoService() {
		return opcaoService;
	}

	public void setOpcaoService(OpcaoService opcaoService) {
		this.opcaoService = opcaoService;
	}
	
	public RespostaService getRespostaService() {
		return respostaService;
	}

	public void setRespostaService(RespostaService respostaService) {
		this.respostaService = respostaService;
	}

	public RespostaItemService getRespostaItemService() {
		return respostaItemService;
	}

	public void setRespostaItemService(RespostaItemService respostaItemService) {
		this.respostaItemService = respostaItemService;
	}

	
	
}
