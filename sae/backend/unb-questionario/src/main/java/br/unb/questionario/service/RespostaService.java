package br.unb.questionario.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.questionario.infra.QuestionarioInfra;
import br.unb.questionario.model.RespostaPergunta;

@Stateless
public class RespostaService {
	
	public RespostaPergunta findById(Integer id) {
		return QuestionarioInfra.getInstance()
			.getRespostaRepository()
			.findById(id);
	}

	public List<RespostaPergunta> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return QuestionarioInfra.getInstance()
			.getRespostaRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public RespostaPergunta update(RespostaPergunta RespostaPergunta){
		RespostaPergunta.validar();
		return QuestionarioInfra.getInstance()
			.getRespostaRepository()
			.update(RespostaPergunta);
	}

	public RespostaPergunta insert(RespostaPergunta RespostaPergunta) {
		RespostaPergunta.validar();
		return QuestionarioInfra.getInstance()
			.getRespostaRepository()
			.insert(RespostaPergunta);
	}
	
	public boolean delete(Integer id) {
		return QuestionarioInfra.getInstance()
			.getRespostaRepository()
			.delete(id);
	}
	
}
