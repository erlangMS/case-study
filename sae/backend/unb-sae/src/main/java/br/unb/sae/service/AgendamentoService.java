package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.sae.infra.SaeInfra;

import br.unb.sae.model.Agenda;
import br.unb.sae.model.Agendamento;
import br.unb.sae.model.AlunoSae;

@Stateless
public class AgendamentoService {

	public void agendarEntrevista(Agendamento agendamento) {
		agendamento.validar();
		SaeInfra.getInstance()
			.getAgendamentoRepository()
			.insert(agendamento);
	}

		
/*		int quantidade = SaeInfra.getInstance().getAgendamentoRepository().getQuantidadeAgendamentosMesmoHorario(a.getDataInicio());
		int quantidadeAtendimentosMaximo = 3; //hard code pra trocar pela classe do Vanderlei
	public void agendarEntrevista(Agenda a) {
		int quantidade = SaeInfra.getInstance().getAgendamentoRepository().getQuantidadeAgendamentosMesmoHorario(a.getDatahora());
		int quantidadeAtendimentosMaximo = a.getQuantidadeAtendentes(); //hard code pra trocar pela classe do Vanderlei

		if (quantidade >= quantidadeAtendimentosMaximo) {
			throw new EmsValidationException("Não é possível realizar mais agendamentos para esta data e hora");
		}
		
	}

	}*/

	public List<Agendamento> buscarAgendamentoPorParteNome(AlunoSae alunoSae){
		return SaeInfra.getInstance().getAgendamentoRepository().pesquisarAgendamentoPorAlunoPorParteNome(alunoSae);
	}
	
	public List<Agendamento> pesquisarAgendamentoPorCpf(AlunoSae alunoSae){
		return SaeInfra.getInstance().getAgendamentoRepository().pesquisarAgendamentoPorAlunoCPF(alunoSae);
	}

	
}
