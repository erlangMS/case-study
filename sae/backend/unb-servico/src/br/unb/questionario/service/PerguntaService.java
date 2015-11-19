package br.unb.questionario.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.questionario.infra.QuestionarioInfra;
import br.unb.questionario.model.Pergunta;

@Stateless
public class PerguntaService {
	
	public Pergunta findById(Integer id) {
		return QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.findById(id);
	}

	public List<Pergunta> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Pergunta update(Pergunta pergunta){
		pergunta.validar();
		return (Pergunta) QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.update(pergunta);
	}

	public Pergunta insert(Pergunta pergunta) {
		pergunta.validar();
		return (Pergunta) QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.insert(pergunta);
	}
	
	public boolean delete(Integer id) {
		return QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.delete(id);
	}
	
}
