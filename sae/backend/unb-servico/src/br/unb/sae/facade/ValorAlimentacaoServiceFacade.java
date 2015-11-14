package br.unb.sae.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.ValorAlimentacao;
 
@Singleton
@Startup
public class ValorAlimentacaoServiceFacade extends EmsServiceFacade {
	@EJB private SaeApplication saeApplication;
	
	public ValorAlimentacao findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return saeApplication.getValorAlimentacaoService().findById(id);
	}
	
	public List<ValorAlimentacao> find(IEmsRequest request){
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return saeApplication.getValorAlimentacaoService().find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public ValorAlimentacao insert(IEmsRequest request){
		final ValorAlimentacao obj = (ValorAlimentacao) request.getObject(ValorAlimentacao.class);
		return saeApplication.getValorAlimentacaoService().insert(obj);
	}
	
	public ValorAlimentacao update(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		ValorAlimentacao obj = saeApplication.getValorAlimentacaoService().findById(id);
		request.mergeObjectFromPayload(obj);
		return saeApplication.getValorAlimentacaoService().update(obj);
	}
	
	public int delete(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		return saeApplication.getValorAlimentacaoService().delete(id);
	}
	
}