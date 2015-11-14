package br.unb.sigra.infra;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public final class InfraFactory {
	@EJB public static AlunoRepository alunoRepository;

	@PersistenceContext(unitName = "service_context")
	public static EntityManager saeContext;
	
}
