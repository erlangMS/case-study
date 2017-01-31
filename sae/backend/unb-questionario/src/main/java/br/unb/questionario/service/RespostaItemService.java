package br.unb.questionario.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.questionario.infra.QuestionarioInfra;
import br.unb.questionario.model.RespostaItem;

@Stateless
public class RespostaItemService {
	
	public RespostaItem findById(Integer id) {
		return QuestionarioInfra.getInstance()
			.getRespostaItemRepository()
			.findById(id);
	}

	public List<RespostaItem> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return QuestionarioInfra.getInstance()
			.getRespostaItemRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public RespostaItem update(RespostaItem respostaItemPergunta){
		respostaItemPergunta.validar();
		return QuestionarioInfra.getInstance()
			.getRespostaItemRepository()
			.update(respostaItemPergunta);
	}

	public RespostaItem insert(RespostaItem respostaItemPergunta) {
		respostaItemPergunta.validar();
		return QuestionarioInfra.getInstance()
			.getRespostaItemRepository()
			.insert(respostaItemPergunta);
	}
	
	public boolean delete(Integer id) {
		return QuestionarioInfra.getInstance()
			.getRespostaItemRepository()
			.delete(id);
	}
	
}
