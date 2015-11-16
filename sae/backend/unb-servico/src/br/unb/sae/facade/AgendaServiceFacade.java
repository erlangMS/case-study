package br.unb.sae.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.Agenda;
import br.unb.sae.service.SaeApplication;

@Singleton
@Startup
public class AgendaServiceFacade extends EmsServiceFacade{
	
	public Agenda insert(IEmsRequest request){
		final Agenda obj = (Agenda) request.getObject(Agenda.class);
		return SaeApplication.getInstance().getAgendaService().insert(obj);
	}
	
	/*public Agenda update(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		Agenda obj = service.findById(id);
		request.mergeObjectFromPayload(obj);
		return SaeApplication.agendaService.update(obj);
	}*/	
	
	public List<Agenda> find(IEmsRequest request){
		String atendimento = request.getQuery("atendimento");
		String periodo = request.getQuery("periodo");
		String dataInicio = request.getQuery("data_inicio");
		String dataFim = request.getQuery("data_fim");
		String horaInicio = request.getQuery("hora_inicio");
		String horaFim = request.getQuery("hora_fim");
		return SaeApplication.getInstance().getAgendaService().pesquisar(atendimento, periodo, dataInicio, dataFim, horaInicio, horaFim);
	}

}