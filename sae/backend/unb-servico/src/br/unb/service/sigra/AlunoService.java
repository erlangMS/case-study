package br.unb.service.sigra;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.web.sae.negocio.AlunoNegocio;
import br.unb.web.sae.pojo.Aluno;

@Singleton
@Startup
public class AlunoService extends EmsServiceFacade{
	
	@EJB
	private AlunoNegocio negocio;
	
	public Aluno findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return negocio.findById(id);
	}
	
	public List<Aluno> find(IEmsRequest request){
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return negocio.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Aluno insert(IEmsRequest request){
		final Aluno obj = (Aluno) request.getObject(Aluno.class);
		return negocio.insert(obj);
	}
	
	public Aluno update(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		Aluno obj = negocio.findById(id);
		request.mergeObjectFromPayload(obj);
		return negocio.update(obj);
	}
	
	public int delete(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		return negocio.delete(id);
	}
	

}
