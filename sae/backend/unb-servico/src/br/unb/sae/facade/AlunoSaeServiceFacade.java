package br.unb.sae.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.AlunoSae;
import br.unb.sae.model.Ocorrencia;
import br.unb.sae.service.AlunoSaeService;
import br.unb.sae.service.SaeApplication;
 
@Singleton
@Startup
public class AlunoSaeServiceFacade extends EmsServiceFacade {
	
	public Ocorrencia inserirOcorrenciaAluno(IEmsRequest request){
		// Localiza o aluno 
		Integer idAluno = request.getParamAsInt("id");
		AlunoSae aluno = SaeApplication.getInstance().getAlunoService().findById(idAluno);

		// Adiciona ocorrência no aluno
		Ocorrencia ocorrencia = (Ocorrencia) request.getObject(Ocorrencia.class);
		aluno.adicionaOcorrencia(ocorrencia);

		return ocorrencia;
	}
	
	public boolean atualizaOcorrenciaAluno(IEmsRequest request){
		// Localiza o aluno 
		Integer idAluno = request.getParamAsInt("id");
		AlunoSae aluno = SaeApplication.getInstance().getAlunoService().findById(idAluno);

		// Localiza a ocorrencia 
		Integer idOcorrencia = request.getParamAsInt("id_2");
		Ocorrencia ocorrencia = aluno.findOcorrenciaById(idOcorrencia);
		
		// Atualiza e valida a ocorrencia
		request.mergeObjectFromPayload(ocorrencia);

		ocorrencia.validar();
		aluno.save();

		return true;
	}

	public List<Ocorrencia> listaOcorrenciaAluno(IEmsRequest request){
		Integer idAluno = request.getParamAsInt("id");
		AlunoSae aluno = SaeApplication.getInstance().getAlunoService().findById(idAluno);
		return aluno.getListaOcorrencia();
	}

	public boolean excluirOcorrenciaAluno(IEmsRequest request){
		AlunoSaeService alunoService = SaeApplication.getInstance().getAlunoService();
		Integer idAluno = request.getParamAsInt("id");
		Integer idOcorrencia = request.getParamAsInt("id_2");
		AlunoSae aluno = alunoService.findById(idAluno);
		return aluno.removeOcorrencia(idOcorrencia);
	}
	
}
