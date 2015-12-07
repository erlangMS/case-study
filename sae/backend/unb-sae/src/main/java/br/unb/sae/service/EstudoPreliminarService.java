package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.erlangms.EmsUtil;
import br.unb.sae.infra.SaeInfra;
import br.unb.sae.model.EstudoPreliminar;
import br.unb.sae.model.RespostaEstudoPreliminar;

@Stateless
public class EstudoPreliminarService {

	public EstudoPreliminar findById(Integer id) {
		return SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.findById(id);
	}

	public List<EstudoPreliminar> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public EstudoPreliminar update(EstudoPreliminar estudoPreliminar){
		estudoPreliminar.validar();
		return SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.update(estudoPreliminar);
	}

	public EstudoPreliminar insert(EstudoPreliminar estudoPreliminar) {
		estudoPreliminar.validar();
		return SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.insert(estudoPreliminar);
	}
	
	public boolean delete(Integer id) {
		return SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.delete(id);
	}
	
	public List<RespostaEstudoPreliminar> listaRespostas(Integer estudo_id) {
		EstudoPreliminar estudo = findById(estudo_id);
		return estudo.getRespostas();
	}

	public void registraResposta(int estudo_id, RespostaEstudoPreliminar resposta){
		EstudoPreliminar estudo = findById(estudo_id);
		estudo.registraResposta(resposta);
	}

	public boolean deleteResposta(Integer id) {
		return SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.delete(RespostaEstudoPreliminar.class, id);
	}

	public void registraResposta(int estudo_id, int resposta_id, RespostaEstudoPreliminar resposta_update) {
		EstudoPreliminar estudo = findById(estudo_id);
		RespostaEstudoPreliminar resposta = estudo.findResposta(resposta_id);
		EmsUtil.mergeObjects(resposta, resposta_update);
		estudo.registraResposta(resposta);		
	}

	
}
