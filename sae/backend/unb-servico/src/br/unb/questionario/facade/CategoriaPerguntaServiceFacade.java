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
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return QuestionarioApplication.getInstance()
			.getCategoriaPerguntaService()
			.find(filtro, fields, limit_ini, limit_fim, sort);
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
