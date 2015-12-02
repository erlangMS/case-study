package br.unb.questionario.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.questionario.model.Pergunta;
import br.unb.questionario.model.Questionario;
import br.unb.questionario.service.QuestionarioApplication;
 
@Singleton
@Startup
public class QuestionarioServiceFacade extends EmsServiceFacade {

	public Questionario findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getQuestionarioService()
			.findById(id);
	}
	
	public List<Questionario> find(IEmsRequest request){
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return QuestionarioApplication.getInstance()
			.getQuestionarioService()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Questionario insert(IEmsRequest request){
		Questionario Questionario = (Questionario) request.getObject(Questionario.class);
		return QuestionarioApplication.getInstance()
			.getQuestionarioService()
			.insert(Questionario);
	}
	
	public Questionario update(IEmsRequest request){
		int id = request.getParamAsInt("id");
		Questionario questionario = QuestionarioApplication.getInstance()
			.getQuestionarioService()
			.findById(id);
		request.mergeObjectFromPayload(questionario);
		return QuestionarioApplication.getInstance()
			.getQuestionarioService()
			.update(questionario);
	}
	
	public Boolean delete(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getQuestionarioService()
			.delete(id);
	}

	public boolean vinculaPerguntaAoQuestionario(IEmsRequest request){
		int questionario_id = request.getParamAsInt("id");
		int pergunta_id = request.getPropertyAsInt("pergunta");
		QuestionarioApplication.getInstance()
			.getQuestionarioService()
			.vinculaPerguntaAoQuestionario(questionario_id, pergunta_id);
		return true;
	}
	
	public List<Pergunta> listaPerguntasVinculadaAoQuestionario(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
					.getQuestionarioService()
					.listaPerguntasVinculadaAoQuestionario(id);
	}
}
