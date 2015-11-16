package br.unb.sae.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.ValorAlimentacao;
import br.unb.sae.service.SaeApplication;
 
@Singleton
@Startup
public class ValorAlimentacaoServiceFacade extends EmsServiceFacade {
	
	public ValorAlimentacao findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return SaeApplication.getInstance().getValorAlimentacaoService().findById(id);
	}
	
	public List<ValorAlimentacao> find(IEmsRequest request){
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return SaeApplication.getInstance().getValorAlimentacaoService().find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public ValorAlimentacao insert(IEmsRequest request){
		final ValorAlimentacao valorAlimentacao = (ValorAlimentacao) request.getObject(ValorAlimentacao.class);
		return SaeApplication.getInstance().getValorAlimentacaoService().insert(valorAlimentacao);
	}
	
	public ValorAlimentacao update(IEmsRequest request){
		SaeApplication saeApplication = SaeApplication.getInstance();
		int id = request.getParamAsInt("id");
		ValorAlimentacao valorAlimentacao = saeApplication.getValorAlimentacaoService().findById(id);
		request.mergeObjectFromPayload(valorAlimentacao);
		return saeApplication.getValorAlimentacaoService().update(valorAlimentacao);
	}
	
	public boolean delete(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		return SaeApplication.getInstance().getValorAlimentacaoService().delete(id);
	}
	
}