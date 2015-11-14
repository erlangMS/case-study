package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.sae.infra.InfraFactory;
import br.unb.sae.model.ValorAlimentacao;

@Stateless
public class ValorAlimentacaoService {

	public ValorAlimentacao findById(Integer id) {
		return InfraFactory.getInstance().getValorAlimentacaoRepository().findById(id);
	}

	public List<ValorAlimentacao> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return InfraFactory.getInstance().getValorAlimentacaoRepository().find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public ValorAlimentacao update(ValorAlimentacao valorAlimentacao){
		valorAlimentacao.validar();
		return InfraFactory.getInstance().getValorAlimentacaoRepository().update(valorAlimentacao);
	}

	public ValorAlimentacao insert(ValorAlimentacao valorAlimentacao) {
		valorAlimentacao.validar();
		return InfraFactory.getInstance().getValorAlimentacaoRepository().insert(valorAlimentacao);
	}
	
	public int delete(Integer id) {
		return InfraFactory.getInstance().getValorAlimentacaoRepository().delete(id);
	}
	
}
