package br.unb.questionario.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.questionario.infra.QuestionarioInfra;
import br.unb.questionario.model.Opcao;

@Stateless
public class OpcaoService {
	
	public Opcao findById(Integer id) {
		return QuestionarioInfra.getInstance()
			.getOpcaoRepository()
			.findById(id);
	}

	public List<Opcao> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return QuestionarioInfra.getInstance()
			.getOpcaoRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Opcao update(Opcao opcao){
		opcao.validar();
		return QuestionarioInfra.getInstance()
			.getOpcaoRepository()
			.update(opcao);
	}

	public Opcao insert(Opcao opcao) {
		opcao.validar();
		return QuestionarioInfra.getInstance()
			.getOpcaoRepository()
			.insert(opcao);
	}
	
	public boolean delete(Integer id) {
		return QuestionarioInfra.getInstance()
			.getOpcaoRepository()
			.delete(id);
	}
	
}
