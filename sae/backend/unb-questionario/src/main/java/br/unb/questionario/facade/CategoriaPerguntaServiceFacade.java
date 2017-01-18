package br.unb.questionario.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.questionario.model.CategoriaPergunta;
import br.unb.questionario.service.QuestionarioApplication;
 
@Singleton
@Startup
public class CategoriaPerguntaServiceFacade extends EmsServiceFacade {

	public CategoriaPergunta findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getCategoriaPerguntaService()
			.findById(id);
	}
	
	public List<CategoriaPergunta> find(IEmsRequest request){
		String filter = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return QuestionarioApplication.getInstance()
			.getCategoriaPerguntaService()
			.find(filter, fields, limit, offset, sort);
	}

	public CategoriaPergunta insert(IEmsRequest request){
		CategoriaPergunta CategoriaPergunta = (CategoriaPergunta) request.getObject(CategoriaPergunta.class);
		return QuestionarioApplication.getInstance()
			.getCategoriaPerguntaService()
			.insert(CategoriaPergunta);
	}
	
	public CategoriaPergunta update(IEmsRequest request){
		int id = request.getParamAsInt("id");
		CategoriaPergunta CategoriaPergunta = QuestionarioApplication.getInstance()
			.getCategoriaPerguntaService()
			.findById(id);
		request.mergeObjectFromPayload(CategoriaPergunta);
		return QuestionarioApplication.getInstance()
			.getCategoriaPerguntaService()
			.update(CategoriaPergunta);
	}
	
	public Boolean delete(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getCategoriaPerguntaService()
			.delete(id);
	}
	
}
