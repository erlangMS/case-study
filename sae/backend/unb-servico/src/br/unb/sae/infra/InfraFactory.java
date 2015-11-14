package br.unb.sae.infra;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class InfraFactory {
	
	@EJB public ValorAlimentacaoRepository valorAlimentacaoRepository;
	@EJB public AssinaturaTermoBaRepository assinaturaTermoBaRepository;
	@EJB public AlunoSaeRepository alunoSaeRepository;
	@EJB public AgendaRepository agendaRepository;
	@EJB public AgendamentoRepository agendamentoRepository;

	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;

	public ValorAlimentacaoRepository getValorAlimentacaoRepository() {
		return valorAlimentacaoRepository;
	}

	public void setValorAlimentacaoRepository(
			ValorAlimentacaoRepository valorAlimentacaoRepository) {
		this.valorAlimentacaoRepository = valorAlimentacaoRepository;
	}

	public AssinaturaTermoBaRepository getAssinaturaTermoBaRepository() {
		return assinaturaTermoBaRepository;
	}

	public void setAssinaturaTermoBaRepository(
			AssinaturaTermoBaRepository assinaturaTermoBaRepository) {
		this.assinaturaTermoBaRepository = assinaturaTermoBaRepository;
	}

	public AlunoSaeRepository getAlunoSaeRepository() {
		return alunoSaeRepository;
	}

	public void setAlunoSaeRepository(AlunoSaeRepository alunoSaeRepository) {
		this.alunoSaeRepository = alunoSaeRepository;
	}

	public AgendaRepository getAgendaRepository() {
		return agendaRepository;
	}

	public void setAgendaRepository(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
	}

	public AgendamentoRepository getAgendamentoRepository() {
		return agendamentoRepository;
	}

	public void setAgendamentoRepository(AgendamentoRepository agendamentoRepository) {
		this.agendamentoRepository = agendamentoRepository;
	}

	public EntityManager getSaeContext() {
		return saeContext;
	}

	public void setSaeContext(EntityManager saeContext) {
		this.saeContext = saeContext;
	}


	
}
