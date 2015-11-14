package br.unb.sigra.infra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.sigra.model.Aluno;

@Stateless
public class AlunoRepository extends EmsRepository<Aluno> {
	
	@Override
	protected EntityManager getEntityManager() {
		return InfraFactory.saeContext;
	}

	@Override
	public Class<Aluno> getClassOfModel() {
		return Aluno.class;
	}
	

}
