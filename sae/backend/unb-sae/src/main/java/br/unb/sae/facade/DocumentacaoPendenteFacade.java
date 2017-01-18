package br.unb.sae.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsJsonModelAdapter;
import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.Documentacao;
import br.unb.sae.model.DocumentacaoPendente;
import br.unb.sae.model.EstudoSocioEconomico;
import br.unb.sae.service.SaeApplication;
 
@Singleton
@Startup
public class DocumentacaoPendenteFacade extends EmsServiceFacade {
	
	public DocumentacaoPendente findById(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getDocumentacaoPendenteService()
			.findById(id);
	}
	
	public List<DocumentacaoPendente> find(IEmsRequest request){
		String filter = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return SaeApplication.getInstance()
			.getDocumentacaoPendenteService()
			.find(filter, fields, limit, offset, sort);
	}

	public DocumentacaoPendente insert(IEmsRequest request){
		final DocumentacaoPendente documentacaoPendente = request.getObject(DocumentacaoPendente.class, new EmsJsonModelAdapter() {
			
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				if (classOfModel == Documentacao.class){
					return SaeApplication.getInstance()
							.getDocumentacaoService()
							.findById(id);
				}else if (classOfModel == EstudoSocioEconomico.class){
					return SaeApplication.getInstance()
							.getEstudoSocioEconomicoService()
							.findById(id);
				}
				return null;
			}
		});
		return SaeApplication.getInstance()
			.getDocumentacaoPendenteService()
			.insert(documentacaoPendente);
	}
	
	public DocumentacaoPendente update(IEmsRequest request){
		int idDocumentacao = request.getParamAsInt("id");
		final DocumentacaoPendente documentacaoPendente = request.getObject(DocumentacaoPendente.class, new EmsJsonModelAdapter() {
			
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				if (classOfModel == Documentacao.class){
					return SaeApplication.getInstance()
							.getDocumentacaoService()
							.findById(id);
				}else if (classOfModel == EstudoSocioEconomico.class){
					return SaeApplication.getInstance()
							.getEstudoSocioEconomicoService()
							.findById(id);
				}
				return null;
			}
		});
		return SaeApplication.getInstance()
				.getDocumentacaoPendenteService()
				.update(idDocumentacao, documentacaoPendente);
		}
	
	public boolean delete(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getDocumentacaoPendenteService()
			.delete(id);
	}
	
}