package br.unb.sae.infra;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SaeInfra {
	private static SaeInfra instance;
	public static SaeInfra getInstance(){ return instance; }
 
	@EJB private ValorAlimentacaoRepository valorAlimentacaoRepository;
	@EJB private AssinaturaTermoBaRepository assinaturaTermoBaRepository;
	@EJB private AlunoSaeRepository alunoSaeRepository;
	@EJB private AgendaRepository agendaRepository;
	@EJB private AgendamentoRepository agendamentoRepository;
	@EJB private EstudoPreliminarRepository estudoPreliminarRepository;

	public SaeInfra(){
		instance = this;
	}
	
	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;

	public ValorAlimentacaoRepository getValorAlimentacaoRepository() {
		return valorAlimentacaoRepository;
	}

	public AssinaturaTermoBaRepository getAssinaturaTermoBaRepository() {
		return assinaturaTermoBaRepository;
	}

	public AlunoSaeRepository getAlunoSaeRepository() {
		return alunoSaeRepository;
	}

	public AgendaRepository getAgendaRepository() {
		return agendaRepository;
	}

	public AgendamentoRepository getAgendamentoRepository() {
		return agendamentoRepository;
	}

	public EntityManager getSaeContext() {
		return saeContext;
	}

	public EstudoPreliminarRepository getEstudoPreliminarRepository() {
		return estudoPreliminarRepository;
	}

	
	
}
