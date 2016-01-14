package br.unb.sae.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsJsonModelAdapter;
import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.Agenda;
import br.unb.sae.model.Agendamento;
import br.unb.sae.model.AlunoSae;
import br.unb.sae.model.AssinaturaTermoBa;
import br.unb.sae.model.Ocorrencia;
import br.unb.sae.service.AlunoSaeService;
import br.unb.sae.service.SaeApplication;
 
@Singleton
@Startup
public class AlunoSaeFacade extends EmsServiceFacade {
	
	public Ocorrencia inserirOcorrenciaAluno(IEmsRequest request){
		Integer idAluno = request.getParamAsInt("id");
		Ocorrencia ocorrencia = request.getObject(Ocorrencia.class);
		return SaeApplication.getInstance()
			.getAlunoService()
			.registraOcorrencia(idAluno, ocorrencia);
	}
	
	public Ocorrencia atualizaOcorrenciaAluno(IEmsRequest request){
		Integer idAluno = request.getParamAsInt("id");
		AlunoSae aluno = SaeApplication.getInstance()
				.getAlunoService()
				.findById(idAluno);
		Integer idOcorrencia = request.getParamAsInt("id_2");
		Ocorrencia ocorrencia = aluno.findOcorrenciaById(idOcorrencia);
		request.mergeObjectFromPayload(ocorrencia);
		return aluno.registraOcorrencia(ocorrencia);
	}

	public Ocorrencia findOcorrenciaAluno(IEmsRequest request){
		int idAluno = request.getParamAsInt("id");
		int idOcorrencia = request.getParamAsInt("id_2");
		return SaeApplication.getInstance()
				.getAlunoService()
				.findOcorrenciaAluno(idAluno, idOcorrencia);
	}

	public List<Ocorrencia> listaOcorrenciaAluno(IEmsRequest request){
		Integer idAluno = request.getParamAsInt("id");
		return SaeApplication.getInstance()
				.getAlunoService()
				.findById(idAluno)
				.getListaOcorrencia();
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
			assinatura = request.getObject(AssinaturaTermoBa.class);
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
		return SaeApplication.getInstance()
			.getAlunoService()
			.getListaAssinaturaTermoConcessaoValeAlimentacao(idAluno);
}

	public boolean removeAssinaturaTermoConcessaoValeAlimentacao(IEmsRequest request){
		Integer idAluno = request.getParamAsInt("id");
		Integer idAssinatura = request.getParamAsInt("id_2");
		return SaeApplication.getInstance()
			.getAlunoService()
			.removeAssinaturaTermoConcessaoValeAlimentacao(idAluno, idAssinatura);
	}
	
	public Agendamento agendarEntrevista (IEmsRequest request) {
		int aluno = request.getParamAsInt("id");
		Agendamento agendamento = request.getObject(Agendamento.class, new EmsJsonModelAdapter() {
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				if (classOfModel == Agenda.class) {
					return SaeApplication.getInstance()
						.getAgendaService()
						.findById(id);
				}
				return null;
			}
		});
		return SaeApplication.getInstance()
			.getAlunoService()
			.agendarEntrevista(aluno, agendamento);
	}
	
	public boolean removeAgendamentoEntrevista(IEmsRequest request){
		int aluno = request.getParamAsInt("id");
		int agendamento = request.getParamAsInt("id_2");
		return SaeApplication.getInstance()
			.getAlunoService()
			.removeAgendamentoEntrevista(aluno, agendamento);
	}

	public Agendamento findAgendamentoEntrevistaById(IEmsRequest request){
		int aluno = request.getParamAsInt("id");
		int agendamento = request.getParamAsInt("id_2");
		return SaeApplication.getInstance()
			.getAlunoService()
			.findAgendamentoEntrevistaById(aluno, agendamento);
	}

	public List<Agendamento> findAgendamentoEntrevista(IEmsRequest request){
		int aluno = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getAlunoService()
			.findAgendamentoEntrevista(aluno);
	}
	
}
