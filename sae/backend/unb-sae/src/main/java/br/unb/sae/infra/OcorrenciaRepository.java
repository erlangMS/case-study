package br.unb.sae.infra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.unb.sae.model.Ocorrencia;

@Stateless
public class OcorrenciaRepository extends EmsRepository<Ocorrencia>{
	
	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;
	
	@Override
	public Class<Ocorrencia> getClassOfModel() {
		return Ocorrencia.class;
	}

	@Override
	public EntityManager getEntityManager() {
		return saeContext;
	}

}