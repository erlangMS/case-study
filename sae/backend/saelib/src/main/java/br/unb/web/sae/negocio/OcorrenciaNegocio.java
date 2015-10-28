package br.unb.web.sae.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.erlangms.EmsValidationException;
import br.unb.web.sae.persistencia.OcorrenciaDAO;
import br.unb.web.sae.pojo.Ocorrencia;

@Stateless
public class OcorrenciaNegocio {

	@EJB
	private OcorrenciaDAO dao;

	public Ocorrencia findById(Integer id) {
		return dao.findById(id);
	}

	public List<Ocorrencia> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return dao.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Ocorrencia update(Ocorrencia obj) throws EmsValidationException{
		validar(obj);
		return dao.update(obj);
	}

	public Ocorrencia insert(Ocorrencia obj) {
		validar(obj);
		return dao.insert(obj);
	}
	
	private void validar(Ocorrencia obj) throws EmsValidationException {
		EmsValidationException validation = new EmsValidationException();
		
		if(validation.getErrors().size() > 0) {
			throw validation;
		}
	}

	public int delete(Integer id) {
		// incluir validação se pode excluir aqui...
		return dao.delete(id);
	}

	

	
}
