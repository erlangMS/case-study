package br.unb.sigra.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unb.sigra.infra.AlunoRepository;
import br.unb.sigra.model.Aluno;

@Stateless
public class AlunoService {

	@EJB
	private AlunoRepository repository;

	public Aluno findById(Integer id) {
		return repository.findById(id);
	}

	public List<Aluno> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return repository.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Aluno update(Aluno aluno){
		aluno.validar();
		return repository.update(aluno);
	}

	public Aluno insert(Aluno aluno) {
		aluno.validar();
		return repository.insert(aluno);
	}
	
	public int delete(Integer id) {
		return repository.delete(id);
	}
	
}
