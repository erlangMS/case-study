package br.unb.sae.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.DocumentacaoPendente;
import br.unb.sae.service.SaeApplication;
 
@Singleton
@Startup
public class DocumentacaoPendenteFacade extends EmsServiceFacade {
	
	public DocumentacaoPendente findById(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getDocumentacaoService()
			.findById(id);
	}
	
	public List<DocumentacaoPendente> find(IEmsRequest request){
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return SaeApplication.getInstance()
			.getDocumentacaoService()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public DocumentacaoPendente insert(IEmsRequest request){
		final DocumentacaoPendente documentacaoPendente = (DocumentacaoPendente) request.getObject(DocumentacaoPendente.class);
		return SaeApplication.getInstance()
			.getDocumentacaoService()
			.insert(documentacaoPendente);
	}
	
	public DocumentacaoPendente update(IEmsRequest request){
		int idDocumentacao = request.getParamAsInt("id");
		DocumentacaoPendente documentacao = request.getObject(DocumentacaoPendente.class);
		return SaeApplication.getInstance()
				.getDocumentacaoService()
				.update(idDocumentacao, documentacao);
	}
	
	public boolean delete(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getDocumentacaoService()
			.delete(id);
	}
	
}