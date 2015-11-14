package br.unb.sigra.infra;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class InfraFactory {
	private static InfraFactory instance;
	public static InfraFactory getInstance(){ return instance; }

	@EJB private AlunoRepository alunoRepository;

	public InfraFactory(){
		instance = this;
	}

	@PersistenceContext(unitName = "service_context")
	private EntityManager saeContext;

	public AlunoRepository getAlunoRepository() {
		return alunoRepository;
	}

	public EntityManager getSaeContext() {
		return saeContext;
	}

}
