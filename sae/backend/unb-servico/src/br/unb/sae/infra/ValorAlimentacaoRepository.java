package br.unb.sae.infra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.unb.sae.model.ValorAlimentacao;

@Stateless
public class ValorAlimentacaoRepository extends EmsRepository<ValorAlimentacao> {
	
	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;

	@Override
	protected EntityManager getEntityManager() {
		return saeContext;
	}

	@Override
	public Class<ValorAlimentacao> getClassOfModel() {
		return ValorAlimentacao.class;
	}

	public boolean existePeriodoVigenciaAberto(ValorAlimentacao obj) {
		try{
			getEntityManager().createQuery("select 1 from ValorAlimentacao where campus = :pCampus and fimVigencia is null")
				.setParameter("pCampus", obj.getCampus())
				.getSingleResult();
			return true;
		}catch (NoResultException e){
			return false;
		}
	}

	public boolean existePeriodoFimMaiorPeriodoInicio(ValorAlimentacao obj) {
		try{
			getEntityManager().createQuery("select 1 from ValorAlimentacao where campus = :pCampus and id <> :pId and fimVigencia >= :pInicioVigencia")
				.setParameter("pCampus", obj.getCampus())
				.setParameter("pId", obj.getId())
				.setParameter("pInicioVigencia", obj.getInicioVigencia())
				.getSingleResult();
			return true;
		}catch (NoResultException e){
			return false;
		}
	}
	
	
}
