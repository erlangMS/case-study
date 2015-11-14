package br.unb.web.sae.persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsDao;
import br.unb.sae.model.Aluno;

@Stateless
public class AlunoDAO extends EmsDao<Aluno> {
	
	@PersistenceContext(unitName = "SaePU")
	private EntityManager emSae;
	
	@Override
	protected EntityManager getEntityManager() {
		return emSae;
	}

	@Override
	public Class<Aluno> getClassOfPojo() {
		return Aluno.class;
	}
	

}
