package br.unb.sitab.infra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public final class InfraFactory {

	@PersistenceContext(unitName = "service_context")
	public static EntityManager saeContext;
	
}
