package br.unb.questionario.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsJsonModelAdapter;
import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.questionario.model.Pergunta;
import br.unb.questionario.model.RespostaPergunta;
import br.unb.questionario.service.QuestionarioApplication;
 
@Singleton
@Startup
public class PerguntaFacade extends EmsServiceFacade {

	public Pergunta findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getPerguntaService()
			.findById(id);
	}
	
	public List<Pergunta> find(IEmsRequest request){
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return QuestionarioApplication.getInstance()
			.getPerguntaService()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Pergunta insert(IEmsRequest request){
		Pergunta Pergunta = (Pergunta) request.getObject(Pergunta.class,
				new EmsJsonModelAdapter(){
					@Override
					public Object findById(Class<?> classOfModel, Integer id) {
						return QuestionarioApplication.getInstance()
								.getCategoriaPerguntaService()
								.findById(id);
					}
		});
		return QuestionarioApplication.getInstance()
			.getPerguntaService()
			.insert(Pergunta);
	}
	
	public Pergunta update(IEmsRequest request){
		int id = request.getParamAsInt("id");
		Pergunta Pergunta = QuestionarioApplication.getInstance()
			.getPerguntaService()
			.findById(id);
		request.mergeObjectFromPayload(Pergunta, new EmsJsonModelAdapter() {
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				return QuestionarioApplication.getInstance()
						.getCategoriaPerguntaService()
						.findById(id);
			}
		});
		return QuestionarioApplication.getInstance()
			.getPerguntaService()
			.update(Pergunta);
	}
	
	public Boolean delete(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getPerguntaService()
			.delete(id);
	}
	
	public boolean registraRespostaParaPergunta(IEmsRequest request){
		int pergunta = request.getParamAsInt("id");
		RespostaPergunta resposta = request.getObject(RespostaPergunta.class);
		QuestionarioApplication.getInstance()
			.getPerguntaService()
			.registraRespostaParaPergunta(pergunta, resposta);
		return true;
	}
	
	public boolean removeRespostaDaPergunta(IEmsRequest request){
		int pergunta = request.getParamAsInt("id");
		int resposta = request.getParamAsInt("id_2");
		QuestionarioApplication.getInstance()
			.getPerguntaService()
			.removeRespostaDaPergunta(pergunta, resposta);
		return true;
	}
	
	public List<RespostaPergunta> listaRespostaDaPergunta(IEmsRequest request){
		int pergunta = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
				.getPerguntaService()
				.listaRespostaDaPergunta(pergunta);
	}
	
}
