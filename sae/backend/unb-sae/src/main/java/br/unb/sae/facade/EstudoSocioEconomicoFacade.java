package br.unb.sae.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsJsonModelAdapter;
import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.EstudoSocioEconomico;
import br.unb.sae.service.SaeApplication;
 
@Singleton
@Startup
public class EstudoSocioEconomicoFacade extends EmsServiceFacade {

	public EstudoSocioEconomico findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getEstudoSocioEconomicoService()
			.findById(id);
	}
	
	public List<EstudoSocioEconomico> find(IEmsRequest request){
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return SaeApplication.getInstance()
			.getEstudoSocioEconomicoService()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public EstudoSocioEconomico insert(IEmsRequest request){
		EstudoSocioEconomico estudo = request.getObject(EstudoSocioEconomico.class, new EmsJsonModelAdapter() {
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				return SaeApplication.getInstance()
							.getAlunoService()
							.findById(id);
			}
		});

		return SaeApplication.getInstance()
			.getEstudoSocioEconomicoService()
			.insert(estudo);
	}
	
	public EstudoSocioEconomico update(IEmsRequest request){
		int id = request.getParamAsInt("id");

		EstudoSocioEconomico estudo = SaeApplication.getInstance()
			.getEstudoSocioEconomicoService()
			.findById(id);

		request.mergeObjectFromPayload(estudo, new EmsJsonModelAdapter() {
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				return SaeApplication.getInstance()
							.getAlunoService()
							.findById(id);
			}
		});
		
		return SaeApplication.getInstance()
			.getEstudoSocioEconomicoService()
			.update(estudo);
	}
	
	public Boolean delete(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getEstudoSocioEconomicoService()
			.delete(id);
	}
	/*
	public List<RespostaEstudoSocioEconomico> listaRespostas(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getEstudoSocioEconomicoService()
			.listaRespostas(id);
	}
	
	public void insertResposta(IEmsRequest request){
		int estudo = request.getParamAsInt("id");
		RespostaEstudoSocioEconomico resposta = request.getObject(RespostaEstudoSocioEconomico.class, new EmsJsonModelAdapter() {
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				return SaeApplication.getInstance()
							.getEstudoSocioEconomicoService()
							.findById(id);
			}
		});

		SaeApplication.getInstance()
			.getEstudoSocioEconomicoService()
			.registraResposta(estudo, resposta);
	}
	
	public void updateResposta(IEmsRequest request){
		int estudo_id = request.getParamAsInt("id");
		int resposta_id = request.getParamAsInt("id_2");
		RespostaEstudoSocioEconomico resposta = request.getObject(RespostaEstudoSocioEconomico.class);
		SaeApplication.getInstance()
			.getEstudoSocioEconomicoService()
			.registraResposta(estudo_id, resposta_id, resposta);
	}
	
	public Boolean deleteResposta(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getEstudoSocioEconomicoService()
			.deleteResposta(id);
	}
	*/
}
