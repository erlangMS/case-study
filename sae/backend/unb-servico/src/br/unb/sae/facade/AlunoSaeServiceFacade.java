package br.unb.sae.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.AlunoSae;
import br.unb.sae.model.Ocorrencia;
 
@Singleton
@Startup
public class AlunoSaeServiceFacade extends EmsServiceFacade {
	
	@EJB private SaeApplication saeApplication;
	
	public Ocorrencia insertOcorrencia(IEmsRequest request){
		// Localiza o aluno 
		Integer idAluno = request.getParamAsInt("id");
		AlunoSae aluno = saeApplication.getAlunoService().findById(idAluno);

		// Adiciona ocorrência no aluno
		Ocorrencia ocorrencia = (Ocorrencia) request.getObject(Ocorrencia.class);
		aluno.adicionaOcorrencia(ocorrencia);
		saeApplication.getAlunoService().update(aluno);

		return ocorrencia;
	}
	
	public List<Ocorrencia> listaOcorrencia(IEmsRequest request){
		Integer idAluno = request.getParamAsInt("id");
		AlunoSae aluno = saeApplication.getAlunoService().findById(idAluno);
		return aluno.getListaOcorrencia();
	}
	
}
