package br.unb.sigra.infra;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SigraInfra {
	private static SigraInfra instance;
	public static SigraInfra getInstance(){ return instance; }

	@EJB private AlunoRepository alunoRepository;

	public SigraInfra(){
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
