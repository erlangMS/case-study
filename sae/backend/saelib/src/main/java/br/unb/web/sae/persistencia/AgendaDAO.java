package br.unb.web.sae.persistencia;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsDao;
import br.unb.web.sae.pojo.Agenda;

@Stateless
public class AgendaDAO extends EmsDao<Agenda>{
	
	@PersistenceContext(unitName = "SaePU")
	private EntityManager emSae;

	@Override
	public Class<Agenda> getClassOfPojo() {
		return Agenda.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return emSae;
	}

	public List<Agenda> pesquisar(String atendimento, String periodo, String dataInicio, String dataFim,
			String horaInicio, String horaFim) {
		// TODO Auto-generated method stub
		return null;
	}

}