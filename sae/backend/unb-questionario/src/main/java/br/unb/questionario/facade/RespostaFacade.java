package br.unb.questionario.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsJsonModelAdapter;
import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.questionario.model.Resposta;
import br.unb.questionario.model.RespostaItem;
import br.unb.questionario.service.QuestionarioApplication;
 
@Singleton
@Startup
public class RespostaFacade extends EmsServiceFacade {

	public Resposta findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getRespostaService()
			.findById(id);
	}
	
	public List<Resposta> find(IEmsRequest request){
		String filter = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return QuestionarioApplication.getInstance()
			.getRespostaService()
			.find(filter, fields, limit, offset, sort);
	}

	public Resposta insert(IEmsRequest request){
		Map<String, Object> respostaPayLoad= request.getPayloadAsMap();
		Resposta resposta = new Resposta();
		Double dataCriacao = (Double) respostaPayLoad.get("dataCriacao");
		Double codigoUsuario = (Double) respostaPayLoad.get("codigoUsuario");
		Double questionario = (Double) respostaPayLoad.get("questionario");
		
		resposta.setDataCriacao(new Date(dataCriacao.longValue()));
		resposta.setCodigoUsuario(codigoUsuario.intValue());
		resposta.setQuestionario(questionario.intValue());
		
		//Interando sobre a lista
		resposta.setRespostaItem(new LinkedList<RespostaItem>());
		@SuppressWarnings("unchecked")
		ArrayList<Map<String, Object>> lista = (ArrayList<Map<String, Object>>) respostaPayLoad.get("respostaItem");
		for(Map<String, Object> item : lista){
			String descricao = (String)item.get("descricao");
			Double pergunta = (Double) item.get("pergunta");
			Double opcao = (Double) item.get("opcao");
			
			
			RespostaItem r = new RespostaItem();
			r.setDescricao(descricao);
			
			if(pergunta != null){
				r.setPergunta(pergunta.intValue());
			}
			
			if(opcao != null){
				r.setOpcao(opcao.intValue());
			}
			
			resposta.getRespostaItem().add(r);
		}
			
		QuestionarioApplication.getInstance()
		.getRespostaService()
		.insert(resposta);
		
			
		for(RespostaItem respostaItem: resposta.getRespostaItem() ){
			respostaItem.setResposta(resposta.getId());
			QuestionarioApplication.getInstance()
					.getRespostaItemService()
					.insert(respostaItem);			
		}
		
		return resposta;
		
	}
	
	public Resposta update(IEmsRequest request){
		Resposta resposta = QuestionarioApplication.getInstance()
			.getRespostaService()
			.findById(request.getParamAsInt("id"));
		request.mergeObjectFromPayload(resposta, new EmsJsonModelAdapter() {
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				if (classOfModel == Resposta.class){
					return QuestionarioApplication.getInstance()
							.getRespostaService()
							.findById(id);
				}
				return null;
			}
		});
		return QuestionarioApplication.getInstance()
			.getRespostaService()
			.update(resposta);
	}
	
	public Boolean delete(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getRespostaService()
			.delete(id);
	}
	
	public List<Resposta> recuperaRespostaCompletaQuestionario(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
					.getRespostaService()
					.getRespostaCompletaQuestionario(id);
	}
	
	public Resposta recuperaRespostaCompleta(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
					.getRespostaService()
					.getRespostaCompleta(id);
	}
	

	


	
}
