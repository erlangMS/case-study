package br.unb.sae.model;

import java.util.Date;
import java.util.List;

import br.erlangms.EmsValidationException;
import br.unb.sae.infra.SaeInfra;

public class AlunoSae{
	private Integer id;
	private Boolean bloqueado;
	private String nome;
	private String cpf;
	private String senha;
	private Date dataNascimento;
	private String sexo;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Ocorrencia registraOcorrencia(Ocorrencia ocorrencia){
		EmsValidationException erro = new EmsValidationException();
		ocorrencia.setAluno(getId());
		ocorrencia.validar();
		
		if (ocorrencia.getPeriodo() != null) {
			if ((ocorrencia.getDataInicio() != null) &&
				 existeOcorrenciaAberto(ocorrencia.getPeriodo(), ocorrencia.getDataInicio())){
					 erro.addError("O aluno já possui uma ocorrência aberta.");
			}
			
			if (assinouTermoConcessaoValeAlimentacao(ocorrencia.getPeriodo())){
				erro.addError("Aluno ainda não possui termo de concessão do benefício socioeconômico assinado.");
			}
		}
		
		if (erro.getErrors().size() > 0){
			throw erro;
		}
		return SaeInfra.getInstance()
			.getOcorrenciaRepository()
			.insertOrUpdate(ocorrencia);
	}
	
	private boolean assinouTermoConcessaoValeAlimentacao(String periodo) {
		int this_aluno = getId();
		return SaeInfra.getInstance()
			.getAssinaturaTermoBaRepository()
			.getStreams()
			.anyMatch(a -> a.getAluno() == this_aluno &&
						   a.getPeriodo().equals(periodo));
	}

	private boolean existeOcorrenciaAberto(String periodo, Date dataInicio) {
		int this_aluno = getId();
		return SaeInfra.getInstance()
			.getOcorrenciaRepository()
			.getStreams()
			.anyMatch(a -> a.getAluno() == this_aluno &&
						   a.getPeriodo().equals(periodo) &&
				           a.getDataInicio().equals(dataInicio));
	}

	public List<Ocorrencia> getListaOcorrencia() {
		int aluno_id = getId();
		return SaeInfra.getInstance()
				.getOcorrenciaRepository()
				.getStreams()
				.where(a -> a.getAluno() == aluno_id)
				.toList();
	}    
	
	public Ocorrencia findOcorrenciaById(Integer idOcorrencia) {
		return SaeInfra.getInstance()
			.getOcorrenciaRepository()
			.findById(idOcorrencia);
	}
	
	public boolean removeOcorrencia(Integer idOcorrencia){
		return SaeInfra.getInstance()
			.getOcorrenciaRepository()
			.delete(idOcorrencia);
	}
	
	public AssinaturaTermoBa findAssinaturaTermoConcessaoValeAlimentacaoById(int idAssinatura) {
		return (AssinaturaTermoBa) SaeInfra.getInstance()
			.getAssinaturaTermoBaRepository()
			.findById(idAssinatura);
	}	

	public AssinaturaTermoBa assinaTermoConcessaoValeAlimentacao(AssinaturaTermoBa assinatura){
		assinatura.setAluno(getId());
		assinatura.validar();
		if (!existeEstudoSocioeconomicoPontuadoComoParticipanteDoProgramaAssistenciaEstudantil()){
			throw new EmsValidationException("Aluno não possui estudo socioeconômico válido pontuado como Participante dos Programas de Assistência Estudantil.");
		}
		return SaeInfra.getInstance()
			.getAssinaturaTermoBaRepository()
			.insertOrUpdate(assinatura);
	}
	
	private boolean existeEstudoSocioeconomicoPontuadoComoParticipanteDoProgramaAssistenciaEstudantil() {
		return true;
	}

	public List<AssinaturaTermoBa> getListaAssinaturaTermoConcessaoValeAlimentacao() {
		int this_aluno = getId();
		return SaeInfra.getInstance()
				.getAssinaturaTermoBaRepository()
				.getStreams()
				.where(a -> a.getAluno() == this_aluno)
				.toList();
	}

	public boolean removeAssinaturaTermoConcessaoValeAlimentacao(Integer idAssinatura) {
		return SaeInfra.getInstance()
			.getAssinaturaTermoBaRepository()
			.delete(AssinaturaTermoBa.class, idAssinatura);
	}
	
	public Agendamento agendarEntrevista(Agendamento agendamento) {
		agendamento.setAluno(getId());
		agendamento.validar();
		if (existeAlunoJaAgendadoParaMesmaDataHora(agendamento.getAgenda())){
			throw new EmsValidationException("O aluno já marcou agendamento para esta data e hora.");
		}
		return SaeInfra.getInstance()
			.getAgendamentoRepository()
			.insertOrUpdate(agendamento);
	}

	public Agendamento findAgendamentoEntrevistaById(Integer agendamento_id) {
		return SaeInfra.getInstance()
			.getAgendamentoRepository()
			.findById(Agendamento.class, agendamento_id);
	}

	public boolean removeAgendamentoEntrevista(int agendamento_id) {
		return SaeInfra.getInstance()
			.getAgendamentoRepository()
			.delete(Agendamento.class, agendamento_id);
	}

	public List<Agendamento> findAgendamentoEntrevista() {
		int aluno_id = getId();
		return SaeInfra.getInstance()
				.getAgendamentoRepository()
				.getStreams()
				.where(a -> a.getAluno() == aluno_id)
				.toList();
	}
	
	private boolean existeAlunoJaAgendadoParaMesmaDataHora(Agenda agenda) {
		return SaeInfra.getInstance()
				.getAgendamentoRepository()
				.alunoJaAgendadoParaMesmaDataHora(this, agenda);
	}


}
