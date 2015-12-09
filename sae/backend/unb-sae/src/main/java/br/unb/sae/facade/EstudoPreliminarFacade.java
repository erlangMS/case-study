package br.unb.sae.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsJsonModelAdapter;
import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.EstudoPreliminar;
import br.unb.sae.model.RespostaEstudoPreliminar;
import br.unb.sae.service.SaeApplication;
 
@Singleton
@Startup
public class EstudoPreliminarFacade extends EmsServiceFacade {

	public EstudoPreliminar findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getEstudoPreliminarService()
			.findById(id);
	}
	
	public List<EstudoPreliminar> find(IEmsRequest request){
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return SaeApplication.getInstance()
			.getEstudoPreliminarService()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public EstudoPreliminar insert(IEmsRequest request){
		EstudoPreliminar EstudoPreliminar = request.getObject(EstudoPreliminar.class, new EmsJsonModelAdapter() {
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				return SaeApplication.getInstance()
							.getAlunoService()
							.findById(id);
			}
		});

		return SaeApplication.getInstance()
			.getEstudoPreliminarService()
			.insert(EstudoPreliminar);
	}
	
	public EstudoPreliminar update(IEmsRequest request){
		int id = request.getParamAsInt("id");

		EstudoPreliminar EstudoPreliminar = SaeApplication.getInstance()
			.getEstudoPreliminarService()
			.findById(id);

		request.mergeObjectFromPayload(EstudoPreliminar, new EmsJsonModelAdapter() {
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				return SaeApplication.getInstance()
							.getAlunoService()
							.findById(id);
			}
		});
		
		return SaeApplication.getInstance()
			.getEstudoPreliminarService()
			.update(EstudoPreliminar);
	}
	
	public Boolean delete(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getEstudoPreliminarService()
			.delete(id);
	}
	
	public List<RespostaEstudoPreliminar> listaRespostas(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getEstudoPreliminarService()
			.listaRespostas(id);
	}
	
	public void insertResposta(IEmsRequest request){
		int estudo = request.getParamAsInt("id");
		RespostaEstudoPreliminar resposta = request.getObject(RespostaEstudoPreliminar.class, new EmsJsonModelAdapter() {
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				return SaeApplication.getInstance()
							.getEstudoPreliminarService()
							.findById(id);
			}
		});

		SaeApplication.getInstance()
			.getEstudoPreliminarService()
			.registraResposta(estudo, resposta);
	}
	
	public void updateResposta(IEmsRequest request){
		int estudo_id = request.getParamAsInt("id");
		int resposta_id = request.getParamAsInt("id_2");
		RespostaEstudoPreliminar resposta = request.getObject(RespostaEstudoPreliminar.class);
		SaeApplication.getInstance()
			.getEstudoPreliminarService()
			.registraResposta(estudo_id, resposta_id, resposta);
	}
	
	public Boolean deleteResposta(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getEstudoPreliminarService()
			.deleteResposta(id);
	}
	
}
