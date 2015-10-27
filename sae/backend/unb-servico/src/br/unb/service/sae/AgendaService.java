package br.unb.service.sae;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.erlangms.IEmsServiceFacade;
import br.unb.web.sae.negocio.AgendaNegocio;
import br.unb.web.sae.pojo.Agenda;

@Singleton
@Startup
public class AgendaService extends EmsServiceFacade implements IEmsServiceFacade{
	
	@EJB
	AgendaNegocio negocio;
	
	public Agenda insert(IEmsRequest request){
		final Agenda obj = (Agenda) request.getObject(Agenda.class);
		return negocio.insert(obj);
	
	}
	
	/*public Agenda update(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		Agenda obj = negocio.findById(id);
		request.mergeObjectFromPayload(obj);
		return negocio.update(obj);
	}*/	
	
	public List<Agenda> find(IEmsRequest request){
		String atendimento = request.getQuery("atendimento");
		String periodo = request.getQuery("periodo");
		String dataInicio = request.getQuery("data_inicio");
		String dataFim = request.getQuery("data_fim");
		String horaInicio = request.getQuery("hora_inicio");
		String horaFim = request.getQuery("hora_fim");
		return negocio.pesquisar(atendimento, periodo, dataInicio, dataFim, horaInicio, horaFim);
	}

}