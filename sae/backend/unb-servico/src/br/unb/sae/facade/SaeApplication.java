package br.unb.sae.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unb.sae.service.AgendaService;
import br.unb.sae.service.AgendamentoService;
import br.unb.sae.service.AlunosSaeService;
import br.unb.sae.service.ValorAlimentacaoService;

@Stateless
public class SaeApplication {
	@EJB private ValorAlimentacaoService valorAlimentacaoService;
	@EJB private AlunosSaeService alunoService;
	@EJB private AgendaService agendaService;
	@EJB private AgendamentoService agendamentoService;
	
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
