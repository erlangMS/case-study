package br.unb.sitab.service;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class SitabApplication {
	private static SitabApplication instance;
	public static SitabApplication getInstance(){ return instance; }

	@EJB private CampusService campusService;
	
	public SitabApplication(){
		instance = this;
	}
	
	public CampusService getCampusService(){
		return campusService;
	}
}
