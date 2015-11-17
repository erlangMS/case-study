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
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return SaeApplication.getInstance()
			.getAgendaService()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public boolean removeAgenda(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getAgendaService()
			.removeAgenda(id);
	}
	
	
}