package br.unb.sae.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.erlangms.EmsValidationException;
import br.unb.sae.infra.SaeInfra;

/**
 * Classe modelo para Agendamento.
 * Contem referências para um Aluno e uma Agenda com data e hora escolhida.
 */
@Entity
@Table(name="TB_Agendamento")
public class Agendamento {

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	// Fetch EAGER pois é necessário para realizar consultas 
	// que dependem de atributos de uma Agenda.
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="agenda_id")
    private Agenda agenda;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="aluno_Id")
    private AlunoSae aluno;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public AlunoSae getAluno() {
		return aluno;
	}

	public void setAluno(AlunoSae aluno) {
		this.aluno = aluno;
	}

	/**
	 * Método que valida se os requisitos para incluir um Agendamento são atendidos.
	 */
	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		
		if (getAluno() == null){
			erro.addError("Informe o Aluno do agendamento.");
		}

		if (getAgenda() == null){
			erro.addError("Informe a Agenda do agendamento.");
		}
		
		if (erro.getErrors().size() == 0 && quantidadeMaximaDeAgendamentosAtingida()){
			erro.addError("A quantidade de agendamentos para este mesmo dia e horário já foi atingida.");
		}
		
		if (erro.getErrors().size() == 0 && alunoJaAgendadoParaMesmaDataHora()){
			erro.addError("O aluno já marcou agendamento para esta data e hora.");
		}
		
		if(erro.getErrors().size() > 0) {
			throw erro;
		}
		
	}

	/**
	 * Verifica se a quantidade de agendamentos ja atingiu a quantidade maxima permitida
	 * para a Agenda escolhida
	 */
	private boolean quantidadeMaximaDeAgendamentosAtingida() {
					
		int quantidadeAgendamentosMesmoHorario = SaeInfra.getInstance().
				getAgendamentoRepository().getQuantidadeAgendamentosMesmoHorario(agenda);
		
		//Caso a quantidade de atendimentos já tiver sido atingida, retorna true
		if (quantidadeAgendamentosMesmoHorario >= agenda.getQuantidadeAtendentes()) {
			return true;
		}
		
		return false;
		
		
		//TENTATIVA DE CONSULTAR QUANTIDADE DE AGENDAMENTOS JA FEITOS PARA UMA AGENDA
		//IGUAL DA CLASSE Agenda.java
/*		return SaeInfra.getInstance()
			.getAgendamentoRepository()
			.getStreams()
			.where(a -> a.getAgenda().getId().intValue() == getAgenda().getId().intValue())
			.count() >= getAgenda().getQuantidadeAtendentes(); 
*/			

	}
   
	
	/**
	 * Verifica se a quantidade de agendamentos ja atingiu a quantidade maxima permitida
	 * para a Agenda escolhida
	 */
	private boolean alunoJaAgendadoParaMesmaDataHora() {
					
		return SaeInfra.getInstance().
				getAgendamentoRepository().alunoJaAgendadoParaMesmaDataHora(aluno, agenda);

	}    
}