package br.unb.questionario.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.questionario.infra.QuestionarioInfra;
import br.unb.questionario.model.CategoriaPergunta;

@Stateless
public class CategoriaPerguntaService {
	
	public CategoriaPergunta findById(Integer id) {
		return QuestionarioInfra.getInstance()
			.getCategoriaPerguntaRepository()
			.findById(id);
	}

	public List<CategoriaPergunta> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return QuestionarioInfra.getInstance()
			.getCategoriaPerguntaRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public CategoriaPergunta update(CategoriaPergunta categoriaPergunta){
		categoriaPergunta.validar();
		return QuestionarioInfra.getInstance()
			.getCategoriaPerguntaRepository()
			.update(categoriaPergunta);
	}

	public CategoriaPergunta insert(CategoriaPergunta categoriaPergunta) {
		categoriaPergunta.validar();
		return QuestionarioInfra.getInstance()
			.getCategoriaPerguntaRepository()
			.insert(categoriaPergunta);
	}
	
	public boolean delete(Integer id) {
		return QuestionarioInfra.getInstance()
			.getCategoriaPerguntaRepository()
			.delete(id);
	}
	
}
