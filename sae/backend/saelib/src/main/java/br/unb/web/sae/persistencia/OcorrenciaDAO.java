package br.unb.web.sae.persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsDao;
import br.unb.web.sae.pojo.Ocorrencia;

@Stateless
public class OcorrenciaDAO extends EmsDao<Ocorrencia> {
	

	@PersistenceContext(unitName = "SaePU")
	private EntityManager emSae;
	
	@Override
	protected EntityManager getEntityManager() {
		return emSae;
	}

	@Override
	public Class<Ocorrencia> getClassOfPojo() {
		return Ocorrencia.class;
	}

	
	
}
