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

	public boolean existePeriodoVigenciaAbertoEmCampus(Integer campus) {
		try{
			getEntityManager().createQuery("select 1 from ValorAlimentacao where campus = :pCampus and fimVigencia is null")
				.setParameter("pCampus", campus)
				.getSingleResult();
			return true;
		}catch (NoResultException e){
			return false;
		}
	}

	public boolean existePeriodoFimMaiorPeriodoInicioQueEsteValorAlimentacao(ValorAlimentacao valorAlimentacao) {
		try{
			getEntityManager().createQuery("select 1 from ValorAlimentacao where campus = :pCampus and id <> :pId and fimVigencia >= :pInicioVigencia")
				.setParameter("pCampus", valorAlimentacao.getCampus())
				.setParameter("pId", valorAlimentacao.getId())
				.setParameter("pInicioVigencia", valorAlimentacao.getInicioVigencia())
				.getSingleResult();
			return true;
		}catch (NoResultException e){
			return false;
		}
	}
	
	
}
