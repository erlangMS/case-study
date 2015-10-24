package br.unb.service.sae;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.web.sae.negocio.AgendamentoNegocio;
import br.unb.web.sae.pojo.Agenda;

@Singleton
@Startup
public class AgendamentoAlunoService extends EmsServiceFacade{

	@EJB
	private AgendamentoNegocio negocio;
	
	public Agenda agendarEntrevista (IEmsRequest request) {
		final Agenda agenda = (Agenda) request.getObject(Agenda.class);
		negocio.agendamento(agenda);
		
		return agenda;
	}
	
	
	
}
