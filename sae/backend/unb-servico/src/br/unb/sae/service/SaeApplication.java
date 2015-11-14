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
	@EJB private AlunosSaeService alunoService;
	@EJB private AgendaService agendaService;
	@EJB private AgendamentoService agendamentoService;
	
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
	public AlunosSaeService getAlunoService() {
		return alunoService;
	}
	public AgendaService getAgendaService() {
		return agendaService;
	}
	public AgendamentoService getAgendamentoService() {
		return agendamentoService;
	}
}
