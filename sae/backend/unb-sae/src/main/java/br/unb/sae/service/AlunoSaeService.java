package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.erlangms.EmsServiceProxy;
import br.unb.sae.model.Agendamento;
import br.unb.sae.model.AlunoSae;
import br.unb.sae.model.AssinaturaTermoBa;
import br.unb.sae.model.Ocorrencia;

@Stateless
public class AlunoSaeService extends EmsServiceProxy {

	public AlunoSae findById(Integer id) {
		return getStream().from("/sigra/aluno/:id")
				.setParameter(id)
				.request()
				.getObject(AlunoSae.class);
	}

	public Ocorrencia registraOcorrencia(Integer idAluno, Ocorrencia ocorrencia) {
		AlunoSae aluno = findById(idAluno);
		return aluno.registraOcorrencia(ocorrencia);
	}

	public Ocorrencia findOcorrenciaAluno(Integer idAluno, Integer idOcorrencia) {
		AlunoSae aluno = findById(idAluno);
		return aluno.findOcorrenciaById(idOcorrencia);
	}

	public boolean removeAssinaturaTermoConcessaoValeAlimentacao(Integer idAluno, Integer idAssinatura) {
		AlunoSae aluno = findById(idAluno);
		return aluno.removeAssinaturaTermoConcessaoValeAlimentacao(idAssinatura);
	}

	public List<AssinaturaTermoBa> getListaAssinaturaTermoConcessaoValeAlimentacao(Integer idAluno) {
		AlunoSae aluno = findById(idAluno);
		return aluno.getListaAssinaturaTermoConcessaoValeAlimentacao();
	}

	public Agendamento agendarEntrevista(Integer aluno_id, Agendamento agendamento) {
		AlunoSae aluno = findById(aluno_id);
		return aluno.agendarEntrevista(agendamento);
	}

	public boolean removeAgendamentoEntrevista(int aluno_id, int agendamento_id) {
		AlunoSae aluno = findById(aluno_id);
		return aluno.removeAgendamentoEntrevista(agendamento_id);
	}

	public Agendamento findAgendamentoEntrevistaById(int aluno_id, int agendamento_id) {
		AlunoSae aluno = findById(aluno_id);
		return aluno.findAgendamentoEntrevistaById(agendamento_id);
	}

	public List<Agendamento> findAgendamentoEntrevista(int aluno_id) {
		AlunoSae aluno = findById(aluno_id);
		return aluno.findAgendamentoEntrevista();
	}

}
