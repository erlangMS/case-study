package br.unb.sitab.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sigra.facade.SigraApplication;
import br.unb.sitab.model.Campus;
 
@Singleton
@Startup
public class CampusServiceFacade extends EmsServiceFacade {

	@EJB private SitabApplication sitabApplication;
	@EJB private SigraApplication sigraApplication; 
	
	public Campus findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return sitabApplication.getCampusService().findById(id);
	}
	
	public List<Campus> all(IEmsRequest request){
		sigraApplication.getAlunoService().findById(2);
		return sitabApplication.getCampusService().getAll();
	}
	
}
