package br.unb.sae.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.AlunoSae;
import br.unb.sae.model.AssinaturaTermoBa;
import br.unb.sae.model.Ocorrencia;
import br.unb.sae.service.AlunoSaeService;
import br.unb.sae.service.SaeApplication;
 
@Singleton
@Startup
public class AlunoSaeServiceFacade extends EmsServiceFacade {
	
	public Ocorrencia inserirOcorrenciaAluno(IEmsRequest request){
		Integer idAluno = request.getParamAsInt("id");
		Ocorrencia ocorrencia = (Ocorrencia) request.getObject(Ocorrencia.class);
		SaeApplication.getInstance().getAlunoService().registraOcorrencia(idAluno, ocorrencia);
		return ocorrencia;
	}
	
	public boolean atualizaOcorrenciaAluno(IEmsRequest request){
		// Localiza o aluno 
		Integer idAluno = request.getParamAsInt("id");
		AlunoSae aluno = SaeApplication.getInstance().getAlunoService().findById(idAluno);

		// Localiza a ocorrencia 
		Integer idOcorrencia = request.getParamAsInt("id_2");
		Ocorrencia ocorrencia = aluno.findOcorrenciaById(idOcorrencia);
		
		// // Merge com dados que serão atualizados
		request.mergeObjectFromPayload(ocorrencia);

		aluno.registraOcorrencia(ocorrencia);

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

	public AssinaturaTermoBa assinaTermoConcessaoValeAlimentacao(IEmsRequest request){
		// Localiza o aluno 
		Integer idAluno = request.getParamAsInt("id");
		AlunoSae aluno = SaeApplication.getInstance().getAlunoService().findById(idAluno);

		AssinaturaTermoBa assinatura = null;
		
		// POST == insert e PUT == update 
		if (request.getMetodo().equals("POST")){
			assinatura = (AssinaturaTermoBa) request.getObject(AssinaturaTermoBa.class);
		}else{
			// Localiza a ocorrencia 
			int idAssinatura = request.getParamAsInt("id_2");
			assinatura = aluno.findAssinaturaTermoConcessaoValeAlimentacaoById(idAssinatura);
			
			// Merge com dados que serão atualizados
			request.mergeObjectFromPayload(assinatura);
		}
		
		// Assina o termo
		aluno.assinaTermoConcessaoValeAlimentacao(assinatura);

		return assinatura;
	}

	public List<AssinaturaTermoBa> listaAssinaturaTermoConcessaoValeAlimentacao(IEmsRequest request){
		Integer idAluno = request.getParamAsInt("id");
		AlunoSae aluno = SaeApplication.getInstance()
							.getAlunoService()
							.findById(idAluno);
		return aluno.getListaAssinaturaTermoConcessaoValeAlimentacao();
	}

	public boolean removeAssinaturaTermoConcessaoValeAlimentacao(IEmsRequest request){
		AlunoSaeService alunoService = SaeApplication.getInstance().getAlunoService();
		Integer idAluno = request.getParamAsInt("id");
		Integer idAssinatura = request.getParamAsInt("id_2");
		AlunoSae aluno = alunoService.findById(idAluno);
		return aluno.removeAssinaturaTermoConcessaoValeAlimentacao(idAssinatura);
	}
	
}
