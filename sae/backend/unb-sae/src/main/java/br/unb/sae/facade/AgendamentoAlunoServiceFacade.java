package br.unb.sae.facade;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.Agenda;
import br.unb.sae.service.SaeApplication;

@Singleton
@Startup
public class AgendamentoAlunoServiceFacade extends EmsServiceFacade{
	
	public Agenda agendarEntrevista (IEmsRequest request) {
		Agenda agenda = (Agenda) request.getObject(Agenda.class);
		SaeApplication.getInstance()
			.getAgendamentoService()
			.agendarEntrevista(agenda);
		return agenda;
	}
	
}
