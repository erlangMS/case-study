package br.unb.web.sae.persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

	
	
}
