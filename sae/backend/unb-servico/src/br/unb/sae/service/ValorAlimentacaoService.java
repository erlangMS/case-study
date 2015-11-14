package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.unb.sae.infra.InfraFactory;
import br.unb.sae.model.ValorAlimentacao;

@Stateless
public class ValorAlimentacaoService {

	@Inject InfraFactory infra;

	public ValorAlimentacao findById(Integer id) {
		return infra.getValorAlimentacaoRepository().findById(id);
	}

	public List<ValorAlimentacao> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return infra.getValorAlimentacaoRepository().find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public ValorAlimentacao update(ValorAlimentacao obj){
		return infra.getValorAlimentacaoRepository().update(obj);
	}

	public ValorAlimentacao insert(ValorAlimentacao obj) {
		return infra.getValorAlimentacaoRepository().insert(obj);
	}
	
	public int delete(Integer id) {
		return infra.getValorAlimentacaoRepository().delete(id);
	}
	
}
