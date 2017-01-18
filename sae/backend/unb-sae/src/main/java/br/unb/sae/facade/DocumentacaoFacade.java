package br.unb.sae.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.Documentacao;
import br.unb.sae.service.SaeApplication;
 
@Singleton
@Startup
public class DocumentacaoFacade extends EmsServiceFacade {
	
	public Documentacao findById(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getDocumentacaoService()
			.findById(id);
	}
	
	public List<Documentacao> find(IEmsRequest request){
		String filter = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return SaeApplication.getInstance()
			.getDocumentacaoService()
			.find(filter, fields, limit, offset, sort);
	}

	public Documentacao insert(IEmsRequest request){
		final Documentacao documentacaoPendente = (Documentacao) request.getObject(Documentacao.class);
		return SaeApplication.getInstance()
			.getDocumentacaoService()
			.insert(documentacaoPendente);
	}
	
	public Documentacao update(IEmsRequest request){
		SaeApplication saeApplication = SaeApplication.getInstance();
		int id = request.getParamAsInt("id");
		Documentacao documentacaoPendente = saeApplication.getDocumentacaoService().findById(id);
		request.mergeObjectFromPayload(documentacaoPendente);
		return saeApplication.getDocumentacaoService().update(documentacaoPendente);
	}
	
	public boolean delete(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getDocumentacaoService()
			.delete(id);
	}
	
}