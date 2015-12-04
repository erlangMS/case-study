package br.unb.questionario.infra;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class QuestionarioInfra {
	private static QuestionarioInfra instance;
	public static QuestionarioInfra getInstance(){ return instance; }

	@EJB private CategoriaPerguntaRepository categoriaPerguntaRepository;
	@EJB private PerguntaRepository perguntaRepository;
	@EJB private QuestionarioRepository questionarioRepository;
	@EJB private TipoQuestionarioRepository tipoQuestionarioRepository;

	public QuestionarioInfra(){
		instance = this;
	}

	@PersistenceContext(unitName = "service_context")
	private EntityManager saeContext;

	public CategoriaPerguntaRepository getCategoriaPerguntaRepository() {
		return categoriaPerguntaRepository;
	}
	
	public PerguntaRepository getPerguntaRepository() {
		return perguntaRepository;
	}
	
	public QuestionarioRepository getQuestionarioRepository() {
		return questionarioRepository;
	}

	public TipoQuestionarioRepository getTipoQuestionarioRepository() {
		return tipoQuestionarioRepository;
	}

	public EntityManager getSaeContext() {
		return saeContext;
	}
	
	
}
