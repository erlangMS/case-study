package br.unb.sae.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import br.unb.sae.infra.SaeInfra;

import br.unb.sae.model.Agendamento;
import br.unb.sae.model.AlunoSae;

/**
 * Classe serviço para Agendamento.
 * Contem métodos para incluir um novo agendamento e pesquisar agendamentos por dados do Aluno
 */
@Stateless
public class AgendamentoService {

	public void agendarEntrevista(Agendamento agendamento) {
		agendamento.validar();
		SaeInfra.getInstance()
			.getAgendamentoRepository()
			.insert(agendamento);
	}

	public List<Agendamento> buscarAgendamentoPorParteNome(AlunoSae alunoSae){
		return SaeInfra.getInstance().getAgendamentoRepository().pesquisarAgendamentoPorAlunoPorParteNome(alunoSae);
	}
	
	public List<Agendamento> pesquisarAgendamentoPorCpf(AlunoSae alunoSae){
		return SaeInfra.getInstance().getAgendamentoRepository().pesquisarAgendamentoPorAlunoCPF(alunoSae);
	}

	public List<Agendamento> pesquisarAgendamentoDoDia(Date dataDoDia){
		return SaeInfra.getInstance().getAgendamentoRepository().pesquisarAgendamentoDoDia(dataDoDia);
	}

	public boolean removeAgendamento(int id) {
		return SaeInfra.getInstance()
			.getAgendamentoRepository()
			.delete(id);
	}
	
}
