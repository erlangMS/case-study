package br.unb.sae.infra;

import java.sql.Timestamp;
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

	@SuppressWarnings("unchecked")
	public List<Agenda> pesquisarPorPeriodo(String dataInicio, String dataFim) {
		StringBuilder SQL = new StringBuilder("Select a from Agenda a WHERE");
		SQL.append("datahora between  :dataInicio AND  :dataFim");
		return getEntityManager().createQuery(SQL.toString())
		.setParameter("dataInicio", dataInicio)
		.setParameter("dataFim", dataFim)
		.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	public List<Agenda> pesquisarPorCampusAndSemestreAno(Integer campus,String semestreAno ) {
		StringBuilder SQL = new StringBuilder("Select a from Agenda a WHERE");
		SQL.append("periodo = :periodo");
		SQL.append("campus = :campus");
		return getEntityManager().createQuery(SQL.toString())
				.setParameter("campus", campus)
				.setParameter("periodo", semestreAno)
		.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Agenda> pesquisarAgendaDiaria(Timestamp dataHora) {
		StringBuilder SQL = new StringBuilder("Select a from Agenda a WHERE");
		SQL.append("date(dataHora) = date(:dataHora)");
		SQL.append("campus = :campus");
		return getEntityManager().createQuery(SQL.toString())
				.setParameter("dataHora", dataHora)
		.getResultList();
	}
	
}