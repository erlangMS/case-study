package br.unb.questionario.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.questionario.infra.QuestionarioInfra;
import br.unb.questionario.model.Resposta;

@Stateless
public class RespostaService {
	
	public Resposta findById(Integer id) {
		return QuestionarioInfra.getInstance()
			.getRespostaRepository()
			.findById(id);
	}

	public List<Resposta> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return QuestionarioInfra.getInstance()
			.getRespostaRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Resposta update(Resposta respostaPergunta){
		respostaPergunta.validar();
		return QuestionarioInfra.getInstance()
			.getRespostaRepository()
			.update(respostaPergunta);
	}

	public Resposta insert(Resposta respostaPergunta) {
		respostaPergunta.validar();
		return QuestionarioInfra.getInstance()
			.getRespostaRepository()
			.insert(respostaPergunta);
	}
	
	public boolean delete(Integer id) {
		return QuestionarioInfra.getInstance()
			.getRespostaRepository()
			.delete(id);
	}
	
	public Resposta getRespostaCompleta(Integer id){
		Resposta resposta = new Resposta();
		return resposta.getRespostaCompleta(id);
	}
	
	
}
