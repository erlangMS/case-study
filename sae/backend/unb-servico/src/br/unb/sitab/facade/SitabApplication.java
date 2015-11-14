package br.unb.sitab.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unb.sitab.service.CampusService;

@Stateless
public class SitabApplication {
	@EJB private CampusService campusService;
	
	public CampusService getCampusService(){
		return campusService;
	}
}
