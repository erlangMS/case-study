package br.unb.sigra.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.unb.sigra.service.AlunoService;

@Stateless
public class SigraApplication {
	@EJB private AlunoService alunoService;

	public AlunoService getAlunoService() {
		return alunoService;
	}
	
}
