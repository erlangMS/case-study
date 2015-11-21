package br.unb.sae.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.unb.sae.model.Agenda;

@Stateless
public class AgendaRepository extends EmsRepository<Agenda>{
	
	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;
	
	@Override
	public Class<Agenda> getClassOfModel() {
		return Agenda.class;
	}

	@Override
	public EntityManager getEntityManager() {
		return saeContext;
	}

	public List<Agenda> pesquisar(String atendimento, String periodo, String dataInicio, String dataFim,
			String horaInicio, String horaFim) {
		// TODO Auto-generated method stub
		return null;
	}

}