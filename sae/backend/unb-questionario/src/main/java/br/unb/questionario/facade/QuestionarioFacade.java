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
public class QuestionarioFacade extends EmsServiceFacade {

	public Questionario findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getQuestionarioService()
			.findById(id);
	}
	
	public List<Questionario> find(IEmsRequest request){
		String filter = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return QuestionarioApplication.getInstance()
			.getQuestionarioService()
			.find(filter, fields, limit, offset, sort);
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
	
	public boolean desvinculaPerguntaDoQuestionario(IEmsRequest request){
		int questionario_id = request.getParamAsInt("id");
		int pergunta_id = request.getParamAsInt("id_2");
		QuestionarioApplication.getInstance()
			.getQuestionarioService()
			.desvinculaPerguntaDoQuestionario(questionario_id, pergunta_id);
		return true;
	}

	public List<Pergunta> listaPerguntasVinculadaAoQuestionario(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
					.getQuestionarioService()
					.listaPerguntasVinculadaAoQuestionario(id);
	}
	
	public Questionario recuperaQuestionarioCompleto(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
					.getQuestionarioService()
					.getQuestionarioCompleto(id);
	}
	
	
}
