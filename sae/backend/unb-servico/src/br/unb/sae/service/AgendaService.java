package br.unb.sae.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.erlangms.EmsValidationException;
import br.unb.sae.infra.SaeInfra;
import br.unb.sae.model.Agenda;

@Stateless
public class AgendaService {

	@EJB private SaeInfra infra;

	public Agenda insert(Agenda agenda){
		validar(agenda);
		return SaeInfra.getInstance().getAgendaRepository().insert(agenda);
	}

	public List<Agenda> pesquisar(String atendimento, String periodo, String dataInicio, String dataFim,
			String horaInicio, String horaFim) {
		return SaeInfra.getInstance().getAgendaRepository().pesquisar(atendimento, periodo, dataInicio, dataFim, horaInicio, horaFim);
	}
	
	private void validar(Agenda obj) throws EmsValidationException {
		EmsValidationException validation = new EmsValidationException();
		if (obj.getDataInicio().after(obj.getDataFim())){
			validation.addError("Data Fim maior que data Inicio.");
		}
	
	}
	
	
}