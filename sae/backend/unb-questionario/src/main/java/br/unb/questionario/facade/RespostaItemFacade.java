package br.unb.questionario.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsJsonModelAdapter;
import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.questionario.model.RespostaItem;
import br.unb.questionario.service.QuestionarioApplication;
 
@Singleton
@Startup
public class RespostaItemFacade extends EmsServiceFacade {

	public RespostaItem findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getRespostaItemService()
			.findById(id);
	}
	
	public List<RespostaItem> find(IEmsRequest request){
		String filter = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return QuestionarioApplication.getInstance()
			.getRespostaItemService()
			.find(filter, fields, limit, offset, sort);
	}

	public RespostaItem insert(IEmsRequest request){
		RespostaItem respostaItem = request.getObject(RespostaItem.class,
				new EmsJsonModelAdapter(){
					@Override
					public Object findById(Class<?> classOfModel, Integer id) {
						if (classOfModel == RespostaItem.class){
							return QuestionarioApplication.getInstance()
									.getRespostaItemService()
									.findById(id);
						}
						return null;
					}
		});
		
		return QuestionarioApplication.getInstance()
				.getRespostaItemService()
				.insert(respostaItem);
				
	}
	
	public RespostaItem update(IEmsRequest request){
		RespostaItem respostaItem = QuestionarioApplication.getInstance()
			.getRespostaItemService()
			.findById(request.getParamAsInt("id"));
		request.mergeObjectFromPayload(respostaItem, new EmsJsonModelAdapter() {
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				if (classOfModel == RespostaItem.class){
					return QuestionarioApplication.getInstance()
							.getRespostaItemService()
							.findById(id);
				}
				return null;
			}
		});
		return QuestionarioApplication.getInstance()
			.getRespostaItemService()
			.update(respostaItem);
	}
	
	public Boolean delete(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return QuestionarioApplication.getInstance()
			.getRespostaItemService()
			.delete(id);
	}
	

	


	
}
