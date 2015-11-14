package br.unb.sae.infra;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class InfraFactory {
	private static InfraFactory instance;
	public static InfraFactory getInstance(){ return instance; }
 
	@EJB public ValorAlimentacaoRepository valorAlimentacaoRepository;
	@EJB public AssinaturaTermoBaRepository assinaturaTermoBaRepository;
	@EJB public AlunoSaeRepository alunoSaeRepository;
	@EJB public AgendaRepository agendaRepository;
	@EJB public AgendamentoRepository agendamentoRepository;

	public InfraFactory(){
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
}
