package br.unb.service.sae;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.web.sae.negocio.ValorAlimentacaoNegocio;
import br.unb.web.sae.pojo.ValorAlimentacao;
 
@Singleton
@Startup
public class ValorAlimentacaoService extends EmsServiceFacade {

	@EJB
	private ValorAlimentacaoNegocio negocio;
	
	public ValorAlimentacao findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return negocio.findById(id);
	}
	
	public List<ValorAlimentacao> find(IEmsRequest request){
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return negocio.pesquisar(filtro, fields, limit_ini, limit_fim, sort);
	}

	public ValorAlimentacao insert(IEmsRequest request){
		final ValorAlimentacao obj = (ValorAlimentacao) request.getObject(ValorAlimentacao.class);
		return negocio.insert(obj);
	}
	
	public ValorAlimentacao update(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		ValorAlimentacao obj = negocio.findById(id);
		request.mergeObjectFromPayload(obj);
		return negocio.update(obj);
	}
	
	
}
