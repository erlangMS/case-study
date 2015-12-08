package br.unb.sae.infra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.unb.sae.model.Documentacao;

@Stateless
public class DocumentacaoRepository extends EmsRepository<Documentacao> {

	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;

	@Override
	public EntityManager getEntityManager() {
		return saeContext;
	}

	@Override
	public Class<Documentacao> getClassOfModel() {
		return Documentacao.class;
	}

}
