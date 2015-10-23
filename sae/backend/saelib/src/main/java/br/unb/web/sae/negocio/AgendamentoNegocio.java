package br.unb.web.sae.negocio;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.erlangms.EmsValidationException;
import br.unb.web.sae.persistencia.AgendamentoDAO;
import br.unb.web.sae.pojo.Agenda;

@Stateless
public class AgendamentoNegocio {

	@EJB
	private AgendamentoDAO dao;
	
	public void agendamento (Agenda a) {
		int quantidade = dao.getQuantidadeAgendamentosMesmoHorario(a.getDataHora());
		int quantidadeAtendimentosMaximo = 3; //hard code pra trocar pela classe do Vanderlei
		
		if (quantidade >= quantidadeAtendimentosMaximo) {
			throw new EmsValidationException("Não é possível realizar mais agendamentos para esta data e hora");
		}
	
		dao.insert(a);
	}
	
}
