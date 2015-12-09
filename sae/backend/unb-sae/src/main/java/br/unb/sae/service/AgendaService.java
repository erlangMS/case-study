package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.sae.infra.SaeInfra;
import br.unb.sae.model.Agenda;

@Stateless
public class AgendaService {

	public Agenda findById(int id) {
		return SaeInfra.getInstance()
			.getAgendaRepository()
			.findById(id);
	}

	public Agenda registraAgenda(Agenda agenda) {
		agenda.validar();
		return SaeInfra.getInstance()
			.getAgendaRepository()
			.insertOrUpdate(agenda);
	}

	public List<Agenda> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return SaeInfra.getInstance()
			.getAgendaRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public boolean removeAgenda(int id) {
		return SaeInfra.getInstance()
			.getAgendaRepository()
			.delete(id);
	}
	
	
	public List<Agenda> buscarAgendaPorPeriodo(String dataInicio, String dataFim){
		return SaeInfra.getInstance()
			.getAgendaRepository()
			.pesquisarPorPeriodo(dataInicio, dataFim);
	}
	
	
	public List<Agenda> buscarAgendaPorCampusAndSemestreAno(int campus,String semestreAno){
		return SaeInfra.getInstance()
			.getAgendaRepository()
			.pesquisarPorCampusAndSemestreAno(campus, semestreAno);
	}
	
	
}