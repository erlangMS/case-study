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
public class ValorAlimentacaoFacade extends EmsServiceFacade {
	
	public ValorAlimentacao findById(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getValorAlimentacaoService()
			.findById(id);
	}
	
	public List<ValorAlimentacao> find(IEmsRequest request){
		String filter = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return SaeApplication.getInstance()
			.getValorAlimentacaoService()
			.find(filter, fields, limit, offset, sort);
	}

	public ValorAlimentacao insert(IEmsRequest request){
		final ValorAlimentacao valorAlimentacao = (ValorAlimentacao) request.getObject(ValorAlimentacao.class);
		return SaeApplication.getInstance()
			.getValorAlimentacaoService()
			.insert(valorAlimentacao);
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
		return SaeApplication.getInstance()
			.getValorAlimentacaoService()
			.delete(id);
	}
	
}