package br.unb.sae.facade;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.Agenda;
import br.unb.sae.service.SaeApplication;

@Singleton
@Startup
public class AgendamentoAlunoServiceFacade extends EmsServiceFacade{
	@EJB private SaeApplication saeApplication;
	
	public Agenda agendarEntrevista (IEmsRequest request) {
		final Agenda agenda = (Agenda) request.getObject(Agenda.class);
		saeApplication.getAgendamentoService().agendamento(agenda);
		return agenda;
	}
	
}
