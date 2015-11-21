package br.unb.sitab.infra;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public final class SitabInfra {
	private static SitabInfra instance;
	public static SitabInfra getInstance(){ return instance; }

	@PersistenceContext(unitName = "service_context")
	private EntityManager saeContext;

	public SitabInfra(){
		instance = this;
	}
	
	public EntityManager getSaeContext() {
		return saeContext;
	}
	
	
	
}
