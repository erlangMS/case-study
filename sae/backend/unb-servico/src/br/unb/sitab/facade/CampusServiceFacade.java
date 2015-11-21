package br.unb.sitab.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sitab.model.Campus;
import br.unb.sitab.service.SitabApplication;
 
@Singleton
@Startup
public class CampusServiceFacade extends EmsServiceFacade {

	public Campus findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return SitabApplication.getInstance()
			.getCampusService()
			.findById(id);
	}
	
	public List<Campus> all(IEmsRequest request){
		return SitabApplication.getInstance()
			.getCampusService()
			.getAll();
	}
	
}
