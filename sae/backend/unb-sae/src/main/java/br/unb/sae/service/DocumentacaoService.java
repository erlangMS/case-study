package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.sae.infra.SaeInfra;
import br.unb.sae.model.Documentacao;

@Stateless
public class DocumentacaoService {

	public Documentacao findById(Integer id) {
		return SaeInfra.getInstance()
			.getDocumentacaoRepository()
			.findById(id);
	}

	public List<Documentacao> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return SaeInfra.getInstance()
			.getDocumentacaoRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Documentacao update(Documentacao Documentacao){
		Documentacao.validar();
		return SaeInfra.getInstance()
			.getDocumentacaoRepository()
			.update(Documentacao);
	}

	public Documentacao insert(Documentacao Documentacao) {
		Documentacao.validar();
		return SaeInfra.getInstance()
			.getDocumentacaoRepository()
			.insert(Documentacao);
	}
	
	public boolean delete(Integer id) {
		return SaeInfra.getInstance()
			.getDocumentacaoRepository()
			.delete(id);
	}
	
}
