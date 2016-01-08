package br.unb.sae.infra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.unb.sae.model.EstudoSocioEconomico;

@Stateless
public class EstudoSocioEconomicoRepository extends EmsRepository<EstudoSocioEconomico> {
	
	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;

	@Override
	public EntityManager getEntityManager() {
		return saeContext;
	}

	@Override
	public Class<EstudoSocioEconomico> getClassOfModel() {
		return EstudoSocioEconomico.class;
	}

	
}
