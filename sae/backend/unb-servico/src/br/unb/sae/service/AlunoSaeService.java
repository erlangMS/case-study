package br.unb.sae.service;

import javax.ejb.Stateless;

import br.unb.sae.infra.SaeInfra;
import br.unb.sae.model.AlunoSae;
import br.unb.sae.model.Ocorrencia;

@Stateless
public class AlunoSaeService {

	public AlunoSae findById(Integer id) {
		return SaeInfra.getInstance().getAlunoSaeRepository().findById(id);
	}

	public void registraOcorrencia(Integer idAluno, Ocorrencia ocorrencia) {
		AlunoSae aluno = findById(idAluno);
		aluno.registraOcorrencia(ocorrencia);
	}

}
