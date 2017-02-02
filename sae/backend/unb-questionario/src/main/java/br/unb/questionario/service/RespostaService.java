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
	
	// Recupera respostas completa pelo id de um questionario
	public List<Resposta> getRespostaCompletaQuestionario (Integer idQuestionario){
		return new Resposta().getRespostaCompletaQuestionario(idQuestionario);
	}
	
	// Recupera respostas completa pelo id de um questionario
	public Resposta getRespostaCompleta (Integer idPergunta){
		return new Resposta().getRespostaCompleta(idPergunta);
	}
	
	
}
