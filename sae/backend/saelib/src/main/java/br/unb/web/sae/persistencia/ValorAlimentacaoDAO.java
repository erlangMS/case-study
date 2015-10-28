package br.unb.web.sae.persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsDao;
import br.unb.web.sae.pojo.ValorAlimentacao;

@Stateless
public class ValorAlimentacaoDAO extends EmsDao<ValorAlimentacao> {
	

	@PersistenceContext(unitName = "SaePU")
	private EntityManager emSae;
	
	@Override
	protected EntityManager getEntityManager() {
		return emSae;
	}

	@Override
	public Class<ValorAlimentacao> getClassOfPojo() {
		return ValorAlimentacao.class;
	}

	public boolean existePeriodoVigenciaAberto(ValorAlimentacao obj) {
		try{
			emSae.createQuery("select 1 from ValorAlimentacao where campus = :pCampus and fimVigencia is null")
				.setParameter("pCampus", obj.getCampus())
				.getSingleResult();
			return true;
		}catch (NoResultException e){
			return false;
		}
	}

	public boolean existePeriodoFimMaiorPeriodoInicio(ValorAlimentacao obj) {
		try{
			emSae.createQuery("select 1 from ValorAlimentacao where campus = :pCampus and id <> :pId and fimVigencia >= :pInicioVigencia")
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
