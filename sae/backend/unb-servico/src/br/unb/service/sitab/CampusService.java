package br.unb.service.sitab;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.web.sae.negocio.CampusNegocio;
import br.unb.web.sae.pojo.Campus;
 
@Singleton
@Startup
public class CampusService extends EmsServiceFacade {

	@EJB
	private CampusNegocio negocio;
	
	public Campus findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return negocio.findById(id);
	}
	
	public List<Campus> pesquisar(IEmsRequest request){
		return negocio.getAll();
	}
	
}
