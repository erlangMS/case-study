package br.unb.questionario.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.questionario.model.Opcao;
import br.unb.questionario.service.QuestionarioApplication;
 
@Singleton
@Startup
public class OpcaoFacade extends EmsServiceFacade {

	public Opcao findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getOpcaoService()
			.findById(id);
	}
	
	public List<Opcao> find(IEmsRequest request){
		String filtro = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return QuestionarioApplication.getInstance()
			.getOpcaoService()
			.find(filtro, fields, limit, offset, sort);
	}

	public Opcao insert(IEmsRequest request){
		Opcao RespostaPergunta = (Opcao) request.getObject(Opcao.class);
		return QuestionarioApplication.getInstance()
			.getOpcaoService()
			.insert(RespostaPergunta);
	}
	
	public Opcao update(IEmsRequest request){
		int id = request.getParamAsInt("id");
		Opcao RespostaPergunta = QuestionarioApplication.getInstance()
			.getOpcaoService()
			.findById(id);
		request.mergeObjectFromPayload(RespostaPergunta);
		return QuestionarioApplication.getInstance()
			.getOpcaoService()
			.update(RespostaPergunta);
	}
	
	public Boolean delete(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getOpcaoService()
			.delete(id);
	}
	
}
