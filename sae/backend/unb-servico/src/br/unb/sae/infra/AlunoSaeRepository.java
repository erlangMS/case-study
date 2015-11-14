package br.unb.sae.infra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.unb.sae.model.AlunoSae;

@Stateless
public class AlunoSaeRepository extends EmsRepository<AlunoSae> {

	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;

	@Override
	protected EntityManager getEntityManager() {
		return saeContext;
	}

	@Override
	public Class<AlunoSae> getClassOfModel() {
		return AlunoSae.class;
	}
	

}
