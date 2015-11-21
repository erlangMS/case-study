package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.sae.infra.SaeInfra;
import br.unb.sae.model.ValorAlimentacao;

@Stateless
public class ValorAlimentacaoService {

	public ValorAlimentacao findById(Integer id) {
		return SaeInfra.getInstance()
			.getValorAlimentacaoRepository()
			.findById(id);
	}

	public List<ValorAlimentacao> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return SaeInfra.getInstance()
			.getValorAlimentacaoRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public ValorAlimentacao update(ValorAlimentacao valorAlimentacao){
		valorAlimentacao.validar();
		return SaeInfra.getInstance()
			.getValorAlimentacaoRepository()
			.update(valorAlimentacao);
	}

	public ValorAlimentacao insert(ValorAlimentacao valorAlimentacao) {
		valorAlimentacao.validar();
		return SaeInfra.getInstance()
			.getValorAlimentacaoRepository()
			.insert(valorAlimentacao);
	}
	
	public boolean delete(Integer id) {
		return SaeInfra.getInstance()
			.getValorAlimentacaoRepository()
			.delete(id);
	}
	
}
