package br.unb.sae.infra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.unb.sae.model.DocumentacaoPendente;

@Stateless
public class DocumentacaoPendenteRepository extends EmsRepository<DocumentacaoPendente> {

	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;

	@Override
	public EntityManager getEntityManager() {
		return saeContext;
	}

	@Override
	public Class<DocumentacaoPendente> getClassOfModel() {
		return DocumentacaoPendente.class;
	}

}
