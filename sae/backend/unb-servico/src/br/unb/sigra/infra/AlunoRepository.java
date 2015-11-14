package br.unb.sigra.infra;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.sae.infra.InfraFactory;
import br.unb.sigra.model.Aluno;

@Stateless
public class AlunoRepository extends EmsRepository<Aluno> {
	
	@Inject InfraFactory infra;	
	
	@Override
	protected EntityManager getEntityManager() {
		return infra.getSaeContext();
	}

	@Override
	public Class<Aluno> getClassOfModel() {
		return Aluno.class;
	}
	

}
