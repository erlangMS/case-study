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
public class AgendaFacade extends EmsServiceFacade{

	public Agenda findById(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getAgendaService()
			.findById(id);
	}

	public Agenda registraAgenda(IEmsRequest request){
		Agenda agenda = null;
		
		if (request.getMetodo().equals("POST")){
			agenda = (Agenda) request.getObject(Agenda.class);
		}else{
			int idAgenda = request.getParamAsInt("id");
			agenda = SaeApplication.getInstance()
						.getAgendaService()
						.findById(idAgenda);
			request.mergeObjectFromPayload(agenda);
		}
		
		return SaeApplication.getInstance()
			.getAgendaService()
			.registraAgenda(agenda);
	}

	public List<Agenda> listaAgenda(IEmsRequest request){
		String filter = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return SaeApplication.getInstance()
			.getAgendaService()
			.find(filter, fields, limit, offset, sort);
	}

	public boolean removeAgenda(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getAgendaService()
			.removeAgenda(id);
	}
	
	
}