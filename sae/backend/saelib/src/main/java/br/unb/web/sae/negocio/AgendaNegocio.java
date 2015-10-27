package br.unb.web.sae.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.erlangms.EmsValidationException;
import br.unb.web.sae.persistencia.AgendaDAO;
import br.unb.web.sae.pojo.Agenda;
import br.unb.web.sae.util.Time24HoursValidator;

@Stateless
public class AgendaNegocio {
	
	@EJB
	AgendaDAO dao;

	
	public Agenda insert(Agenda agenda){
		validar(agenda);
		return dao.insert(agenda);
	}


	public List<Agenda> pesquisar(String atendimento, String periodo, String dataInicio, String dataFim,
			String horaInicio, String horaFim) {
		return dao.pesquisar(atendimento, periodo, dataInicio, dataFim, horaInicio, horaFim);
	}
	
	private void validar(Agenda obj) throws EmsValidationException {
		EmsValidationException validation = new EmsValidationException();
		if (obj.getDataInicio().after(obj.getDataFim())){
			validation.addError("Data Fim maior que data Inicio.");
		}
	
	}
	
	
}