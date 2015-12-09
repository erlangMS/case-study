package br.unb.questionario.service;

import java.util.List;

import javax.ejb.Stateless;

import br.erlangms.EmsValidationException;
import br.unb.questionario.infra.QuestionarioInfra;
import br.unb.questionario.model.Pergunta;
import br.unb.questionario.model.Questionario;

@Stateless
public class QuestionarioService {
	
	public Questionario findById(Integer id) {
		return QuestionarioInfra.getInstance()
			.getQuestionarioRepository()
			.findById(id);
	}

	public List<Questionario> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return QuestionarioInfra.getInstance()
			.getQuestionarioRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Questionario update(Questionario Questionario){
		Questionario.validar();
		return QuestionarioInfra.getInstance()
			.getQuestionarioRepository()
			.update(Questionario);
	}

	public Questionario insert(Questionario Questionario) {
		Questionario.validar();
		return QuestionarioInfra.getInstance()
			.getQuestionarioRepository()
			.insert(Questionario);
	}
	
	public boolean delete(Integer id) {
		Questionario questionario = findById(id);
		validaExclusao(questionario);
		return QuestionarioInfra.getInstance()
			.getQuestionarioRepository()
			.delete(id);
	}

	public void vinculaPerguntaAoQuestionario(int questionario_id, int pergunta_id) {
		Questionario questionario = findById(questionario_id);
		Pergunta pergunta = QuestionarioApplication.getInstance()
								.getPerguntaService()
								.findById(pergunta_id);
		questionario.vinculaPergunta(pergunta);
	}

	public List<Pergunta> listaPerguntasVinculadaAoQuestionario(int id) {
		Questionario questionario = findById(id);
		return questionario.getListaPerguntas();
	}

	public void desvinculaPerguntaDoQuestionario(int questionario_id, int pergunta_id) {
		Questionario questionario = findById(questionario_id);
		questionario.desvinculaPergunta(pergunta_id);
	}

	private void validaExclusao(Questionario questionario) {
		// Não permite excluir se tem alguma pergunta vinculada
		if (questionario.temAlgumaPerguntaVinculada()){
			throw new EmsValidationException("O questionário não pode ser excluído pois existem perguntas vinculadas!"); 
		}
	}	
}
