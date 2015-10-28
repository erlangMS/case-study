package br.unb.service.sae;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.web.sae.negocio.OcorrenciaNegocio;
import br.unb.web.sae.pojo.Ocorrencia;
 
@Singleton
@Startup
public class OcorrenciaService extends EmsServiceFacade {

	@EJB
	private OcorrenciaNegocio negocio;
	
	public Ocorrencia findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return negocio.findById(id);
	}
	
	public List<Ocorrencia> find(IEmsRequest request){
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return negocio.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Ocorrencia insert(IEmsRequest request){
		final Ocorrencia obj = (Ocorrencia) request.getObject(Ocorrencia.class);
		return negocio.insert(obj);
	}
	
	public Ocorrencia update(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		Ocorrencia obj = negocio.findById(id);
		request.mergeObjectFromPayload(obj);
		return negocio.update(obj);
	}
	
	public int delete(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		return negocio.delete(id);
	}
	
}
