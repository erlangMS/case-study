package br.unb.sae.infra;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.unb.sae.model.Agendamento;

@Stateless
public class AgendamentoRepository extends EmsRepository<Agendamento> {
	
	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;
	
	@Override
	public EntityManager getEntityManager() {
		return saeContext;
	}

	@Override
	public Class<Agendamento> getClassOfModel() {
		return Agendamento.class;
	}
	
	public int getQuantidadeAgendamentosMesmoHorario (Date dataHora) {
		final String sql = "SELECT COUNT(a) FROM Agendamento a WHERE a.dataHora = :pDataHora";
		return getEntityManager()
			.createQuery(sql)
			.setParameter("pDataHora", dataHora)
			.getFirstResult();
	}

}
