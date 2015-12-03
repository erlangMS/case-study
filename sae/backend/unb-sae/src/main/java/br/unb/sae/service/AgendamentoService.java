package br.unb.sae.service;

import javax.ejb.Stateless;

import br.unb.sae.infra.SaeInfra;
import br.unb.sae.model.Agendamento;

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

		if (quantidade >= quantidadeAtendimentosMaximo) {
			throw new EmsValidationException("Não é possível realizar mais agendamentos para esta data e hora");
		}
		
	}*/
	
}
