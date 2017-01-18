package br.unb.questionario.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.questionario.model.TipoQuestionario;
import br.unb.questionario.service.QuestionarioApplication;
 
@Singleton
@Startup
public class TipoQuestionarioFacade extends EmsServiceFacade {

	public TipoQuestionario findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getTipoQuestionarioService()
			.findById(id);
	}
	
	public List<TipoQuestionario> find(IEmsRequest request){
		String filter = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return QuestionarioApplication.getInstance()
			.getTipoQuestionarioService()
			.find(filter, fields, limit, offset, sort);
	}

	public TipoQuestionario insert(IEmsRequest request){
		TipoQuestionario TipoQuestionario = (TipoQuestionario) request.getObject(TipoQuestionario.class);
		return QuestionarioApplication.getInstance()
			.getTipoQuestionarioService()
			.insert(TipoQuestionario);
	}
	
	public TipoQuestionario update(IEmsRequest request){
		int id = request.getParamAsInt("id");
		TipoQuestionario TipoQuestionario = QuestionarioApplication.getInstance()
			.getTipoQuestionarioService()
			.findById(id);
		request.mergeObjectFromPayload(TipoQuestionario);
		return QuestionarioApplication.getInstance()
			.getTipoQuestionarioService()
			.update(TipoQuestionario);
	}
	
	public Boolean delete(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getTipoQuestionarioService()
			.delete(id);
	}
	
}
