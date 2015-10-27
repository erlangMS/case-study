package br.unb.web.sae.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.erlangms.EmsValidationException;
import br.unb.web.sae.persistencia.AlunoDAO;
import br.unb.web.sae.pojo.Aluno;

@Stateless
public class AlunoNegocio {

	@EJB
	private AlunoDAO dao;

	public Aluno findById(Integer id) {
		return dao.findById(id);
	}

	public List<Aluno> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return dao.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Aluno update(Aluno obj) throws EmsValidationException{
		validar(obj);
		return dao.update(obj);
	}

	public Aluno insert(Aluno obj) {
		validar(obj);
		return dao.insert(obj);
	}
	
	private void validar(Aluno obj) throws EmsValidationException {
	}

	public int delete(Integer id) {
		return dao.delete(id);
	}
	
}
