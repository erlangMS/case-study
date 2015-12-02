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
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return QuestionarioApplication.getInstance()
			.getTipoQuestionarioService()
			.find(filtro, fields, limit_ini, limit_fim, sort);
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
