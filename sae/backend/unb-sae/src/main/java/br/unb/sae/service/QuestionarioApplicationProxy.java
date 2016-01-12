package br.unb.sae.service;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class QuestionarioApplicationProxy {
	private static QuestionarioApplicationProxy instance;
	public static QuestionarioApplicationProxy getInstance(){ return instance; }
	
	@EJB private PerguntaQuestionarioProxy perguntaQuestionarioProxy;
	
	public PerguntaQuestionarioProxy getPerguntaQuestionarioProxy() {
		return perguntaQuestionarioProxy;
	}

	public void setPerguntaQuestionarioProxy(
			PerguntaQuestionarioProxy perguntaQuestionarioProxy) {
		this.perguntaQuestionarioProxy = perguntaQuestionarioProxy;
	}



	public QuestionarioApplicationProxy(){
		instance = this;
	}
	
	
	
}
