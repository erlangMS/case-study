package br.unb.sae.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.erlangms.EmsValidationException;
import br.unb.sae.infra.InfraFactory;
import br.unb.sae.model.Agenda;

@Stateless
public class AgendamentoService {

	@Inject InfraFactory infra;
	
	public void agendamento (Agenda a) {
		int quantidade = infra.agendamentoRepository.getQuantidadeAgendamentosMesmoHorario(a.getDataInicio());
		int quantidadeAtendimentosMaximo = 3; //hard code pra trocar pela classe do Vanderlei
		
		if (quantidade >= quantidadeAtendimentosMaximo) {
			throw new EmsValidationException("Não é possível realizar mais agendamentos para esta data e hora");
		}
	
		//repository.insert(a);
	}
	
}
