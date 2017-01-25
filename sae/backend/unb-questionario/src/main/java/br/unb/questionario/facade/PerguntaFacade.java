package br.unb.questionario.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsJsonModelAdapter;
import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.questionario.model.CategoriaPergunta;
import br.unb.questionario.model.Pergunta;
import br.unb.questionario.model.Opcao;
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
		String filter = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return QuestionarioApplication.getInstance()
			.getPerguntaService()
			.find(filter, fields, limit, offset, sort);
	}

	public Pergunta insert(IEmsRequest request){
		Pergunta pergunta = request.getObject(Pergunta.class,
				new EmsJsonModelAdapter(){
					@Override
					public Object findById(Class<?> classOfModel, Integer id) {
						if (classOfModel == CategoriaPergunta.class){
							return QuestionarioApplication.getInstance()
									.getCategoriaPerguntaService()
									.findById(id);
						}
						return null;
					}
		});
		return QuestionarioApplication.getInstance()
			.getPerguntaService()
			.insert(pergunta);
	}
	
	public Pergunta update(IEmsRequest request){
		Pergunta pergunta = QuestionarioApplication.getInstance()
			.getPerguntaService()
			.findById(request.getParamAsInt("id"));
		request.mergeObjectFromPayload(pergunta, new EmsJsonModelAdapter() {
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				if (classOfModel == CategoriaPergunta.class){
					return QuestionarioApplication.getInstance()
							.getCategoriaPerguntaService()
							.findById(id);
				}
				return null;
			}
		});
		return QuestionarioApplication.getInstance()
			.getPerguntaService()
			.update(pergunta);
	}
	
	public Boolean delete(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getPerguntaService()
			.delete(id);
	}
	
	public Opcao registraRespostaParaPergunta(IEmsRequest request){
		int pergunta = request.getParamAsInt("id");
		Opcao resposta = request.getObject(Opcao.class, new EmsJsonModelAdapter() {
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				if (classOfModel == Pergunta.class){
					return QuestionarioApplication.getInstance()
							.getPerguntaService()
							.findById(id);
				}
				return null;
			}
		});
		return QuestionarioApplication.getInstance()
			.getPerguntaService()
			.registraRespostaParaPergunta(pergunta, resposta);
	}
	
	public boolean removeRespostaDaPergunta(IEmsRequest request){
		int pergunta = request.getParamAsInt("id");
		int resposta = request.getParamAsInt("id_2");
		QuestionarioApplication.getInstance()
			.getPerguntaService()
			.removeRespostaDaPergunta(pergunta, resposta);
		return true;
	}
	
	public List<Opcao> listaRespostaDaPergunta(IEmsRequest request){
		int pergunta = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
				.getPerguntaService()
				.listaRespostaDaPergunta(pergunta);
	}
	
}
