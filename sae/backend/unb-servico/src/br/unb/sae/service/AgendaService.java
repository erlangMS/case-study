package br.unb.sae.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.erlangms.EmsValidationException;
import br.unb.sae.infra.InfraFactory;
import br.unb.sae.model.Agenda;

@Stateless
public class AgendaService {

	@EJB private InfraFactory infra;

	public Agenda insert(Agenda agenda){
		validar(agenda);
		return infra.agendaRepository.insert(agenda);
	}

	public List<Agenda> pesquisar(String atendimento, String periodo, String dataInicio, String dataFim,
			String horaInicio, String horaFim) {
		return infra.agendaRepository.pesquisar(atendimento, periodo, dataInicio, dataFim, horaInicio, horaFim);
	}
	
	private void validar(Agenda obj) throws EmsValidationException {
		EmsValidationException validation = new EmsValidationException();
		if (obj.getDataInicio().after(obj.getDataFim())){
			validation.addError("Data Fim maior que data Inicio.");
		}
	
	}
	
	
}