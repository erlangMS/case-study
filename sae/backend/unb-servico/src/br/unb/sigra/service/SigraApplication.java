package br.unb.sigra.service;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class SigraApplication {
	private static SigraApplication instance;
	public static SigraApplication getInstance(){ return instance; }

	@EJB private AlunoService alunoService;

	public SigraApplication(){
		instance = this;
	}

	public AlunoService getAlunoService() {
		return alunoService;
	}
	
}
