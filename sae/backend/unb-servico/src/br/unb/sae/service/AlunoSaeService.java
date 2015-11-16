package br.unb.sae.service;

import javax.ejb.Stateless;

import br.unb.sae.infra.SaeInfra;
import br.unb.sae.model.AlunoSae;

@Stateless
public class AlunoSaeService {

	public AlunoSae findById(Integer id) {
		return SaeInfra.getInstance().getAlunoSaeRepository().findById(id);
	}

}
