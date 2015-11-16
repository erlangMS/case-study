package br.unb.sae.service;

import javax.ejb.Stateless;

import br.erlangms.EmsValidationException;
import br.unb.sae.infra.SaeInfra;
import br.unb.sae.model.Agenda;

@Stateless
public class AgendamentoService {

	public void agendamento (Agenda a) {
		int quantidade = SaeInfra.getInstance().getAgendamentoRepository().getQuantidadeAgendamentosMesmoHorario(a.getDataInicio());
		int quantidadeAtendimentosMaximo = 3; //hard code pra trocar pela classe do Vanderlei
		
		if (quantidade >= quantidadeAtendimentosMaximo) {
			throw new EmsValidationException("Não é possível realizar mais agendamentos para esta data e hora");
		}
	
		//repository.insert(a);
	}
	
}
