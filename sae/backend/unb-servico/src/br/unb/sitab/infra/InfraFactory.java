package br.unb.sitab.infra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public final class InfraFactory {
	private static InfraFactory instance;
	public static InfraFactory getInstance(){ return instance; }

	@PersistenceContext(unitName = "service_context")
	private EntityManager saeContext;

	public InfraFactory(){
		instance = this;
	}
	
	public EntityManager getSaeContext() {
		return saeContext;
	}
	
	
	
}
