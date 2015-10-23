package br.unb.web.sae.persistencia;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsDao;
import br.unb.web.sae.pojo.Agenda;

@Stateless
public class AgendamentoDAO extends EmsDao<Agenda> {
	
	@PersistenceContext(unitName = "SaePU")
	private EntityManager emSae;
	
	@Override
	protected EntityManager getEntityManager() {
		return emSae;
	}

	@Override
	public Class<Agenda> getClassOfPojo() {
		return Agenda.class;
	}
	
	public int getQuantidadeAgendamentosMesmoHorario (Date dataHora) {
		String sql = "SELECT COUNT(a) FROM Agenda a WHERE a.dataHora = :pDataHora";
		return (int) emSae.createQuery(sql).setParameter("pDataHora", dataHora).getSingleResult();
	}

}
