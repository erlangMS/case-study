package br.unb.sigra.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.sigra.infra.SigraInfra;
import br.unb.sigra.model.Aluno;

@Stateless
public class AlunoService {

	public Aluno findById(Integer id) {
		return SigraInfra.getInstance()
			.getAlunoRepository()
			.findById(id);
	}

	public List<Aluno> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return SigraInfra.getInstance()
			.getAlunoRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Aluno update(Aluno aluno){
		aluno.validar();
		return SigraInfra.getInstance()
			.getAlunoRepository()
			.update(aluno);
	}

	public Aluno insert(Aluno aluno) {
		aluno.validar();
		return SigraInfra.getInstance()
			.getAlunoRepository()
			.insert(aluno);
	}
	
	public boolean delete(Integer id) {
		return SigraInfra.getInstance()
			.getAlunoRepository()
			.delete(id);
	}
	
}
