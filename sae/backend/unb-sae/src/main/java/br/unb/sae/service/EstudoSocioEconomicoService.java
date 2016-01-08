package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.erlangms.EmsUtil;
import br.unb.sae.infra.SaeInfra;
import br.unb.sae.model.EstudoSocioEconomico;
import br.unb.sae.model.RespostaEstudoSocioEconomico;

@Stateless
public class EstudoSocioEconomicoService {

	public EstudoSocioEconomico findById(Integer id) {
		return SaeInfra.getInstance()
			.getEstudoSocioEconomicoRepository()
			.findById(id);
	}

	public List<EstudoSocioEconomico> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return SaeInfra.getInstance()
			.getEstudoSocioEconomicoRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public EstudoSocioEconomico update(EstudoSocioEconomico EstudoSocioEconomico){
		EstudoSocioEconomico.validar();
		return SaeInfra.getInstance()
			.getEstudoSocioEconomicoRepository()
			.update(EstudoSocioEconomico);
	}

	public EstudoSocioEconomico insert(EstudoSocioEconomico EstudoSocioEconomico) {
		EstudoSocioEconomico.validar();
		return SaeInfra.getInstance()
			.getEstudoSocioEconomicoRepository()
			.insert(EstudoSocioEconomico);
	}
	
	public boolean delete(Integer id) {
		return SaeInfra.getInstance()
			.getEstudoSocioEconomicoRepository()
			.delete(id);
	}

	public List<RespostaEstudoSocioEconomico> listaRespostas(Integer estudo_id) {
		EstudoSocioEconomico estudo = findById(estudo_id);
		return estudo.getRespostas();
	}

	public void registraResposta(int estudo_id, RespostaEstudoSocioEconomico resposta){
		EstudoSocioEconomico estudo = findById(estudo_id);
		estudo.registraResposta(resposta);
	}

	public boolean deleteResposta(Integer id) {
		return SaeInfra.getInstance()
			.getEstudoSocioEconomicoRepository()
			.delete(RespostaEstudoSocioEconomico.class, id);
	}

	public void registraResposta(int estudo_id, int resposta_id, RespostaEstudoSocioEconomico resposta_update) {
		EstudoSocioEconomico estudo = findById(estudo_id);
		RespostaEstudoSocioEconomico resposta = estudo.findResposta(resposta_id);
		EmsUtil.mergeObjects(resposta, resposta_update);
		estudo.registraResposta(resposta);		
	}

	
}
