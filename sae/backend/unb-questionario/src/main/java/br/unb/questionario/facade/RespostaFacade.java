package br.unb.questionario.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.questionario.model.RespostaPergunta;
import br.unb.questionario.service.QuestionarioApplication;
 
@Singleton
@Startup
public class RespostaFacade extends EmsServiceFacade {

	public RespostaPergunta findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getRespostaService()
			.findById(id);
	}
	
	public List<RespostaPergunta> find(IEmsRequest request){
		String filtro = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return QuestionarioApplication.getInstance()
			.getRespostaService()
			.find(filtro, fields, limit, offset, sort);
	}

	public RespostaPergunta insert(IEmsRequest request){
		RespostaPergunta RespostaPergunta = (RespostaPergunta) request.getObject(RespostaPergunta.class);
		return QuestionarioApplication.getInstance()
			.getRespostaService()
			.insert(RespostaPergunta);
	}
	
	public RespostaPergunta update(IEmsRequest request){
		int id = request.getParamAsInt("id");
		RespostaPergunta RespostaPergunta = QuestionarioApplication.getInstance()
			.getRespostaService()
			.findById(id);
		request.mergeObjectFromPayload(RespostaPergunta);
		return QuestionarioApplication.getInstance()
			.getRespostaService()
			.update(RespostaPergunta);
	}
	
	public Boolean delete(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getRespostaService()
			.delete(id);
	}
	
}
