package br.unb.questionario.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.questionario.infra.QuestionarioInfra;
import br.unb.questionario.model.TipoQuestionario;

@Stateless
public class TipoQuestionarioService {
	
	public TipoQuestionario findById(Integer id) {
		return QuestionarioInfra.getInstance()
			.getTipoQuestionarioRepository()
			.findById(id);
	}

	public List<TipoQuestionario> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return QuestionarioInfra.getInstance()
			.getTipoQuestionarioRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public TipoQuestionario update(TipoQuestionario TipoQuestionario){
		TipoQuestionario.validar();
		return QuestionarioInfra.getInstance()
			.getTipoQuestionarioRepository()
			.update(TipoQuestionario);
	}

	public TipoQuestionario insert(TipoQuestionario TipoQuestionario) {
		TipoQuestionario.validar();
		return QuestionarioInfra.getInstance()
			.getTipoQuestionarioRepository()
			.insert(TipoQuestionario);
	}
	
	public boolean delete(Integer id) {
		return QuestionarioInfra.getInstance()
			.getTipoQuestionarioRepository()
			.delete(id);
	}
	
}
