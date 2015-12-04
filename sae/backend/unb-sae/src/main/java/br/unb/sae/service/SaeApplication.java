package br.unb.sae.service;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class SaeApplication {
	private static SaeApplication instance;
	public static SaeApplication getInstance(){ return instance; }
	
	@EJB private ValorAlimentacaoService valorAlimentacaoService;
	@EJB private AlunoSaeService alunoService;
	@EJB private AgendaService agendaService;
	@EJB private AgendamentoService agendamentoService;
	@EJB private CampusServiceProxy campusServiceProxy;
	@EJB private EstudoPreliminarService estudoPreliminarService;
	@EJB private DocumentacaoPendenteService documentacaoService;

	
	public SaeApplication(){
		instance = this;
	}
	
	public ValorAlimentacaoService getValorAlimentacaoService() {
		return valorAlimentacaoService;
	}
	public void setValorAlimentacaoService(
			ValorAlimentacaoService valorAlimentacaoService) {
		this.valorAlimentacaoService = valorAlimentacaoService;
	}
	public AlunoSaeService getAlunoService() {
		return alunoService;
	}
	public AgendaService getAgendaService() {
		return agendaService;
	}
	public AgendamentoService getAgendamentoService() {
		return agendamentoService;
	}

	public CampusServiceProxy getCampusServiceProxy() {
		return campusServiceProxy;
	}

	public EstudoPreliminarService getEstudoPreliminarService() {
		return estudoPreliminarService;
	}
	
	public DocumentacaoPendenteService getDocumentacaoService() {
		return documentacaoService;
	}

	
	
}
