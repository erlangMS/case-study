package br.unb.sae.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unb.sae.infra.InfraFactory;
import br.unb.sae.model.AlunoSae;

@Stateless
public class AlunosSaeService {

	@EJB private InfraFactory infra;

	public AlunoSae findById(Integer id) {
		return infra.alunoSaeRepository.findById(id);
	}

	public AlunoSae update(AlunoSae aluno){
		aluno.validar();
		return infra.alunoSaeRepository.update(aluno);
	}

}
