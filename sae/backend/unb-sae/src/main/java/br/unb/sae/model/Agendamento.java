package br.unb.sae.model;

import java.io.Serializable;
import java.sql.Timestamp;

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

@Entity
@Table(name="TB_Agendamento")
public class Agendamento  implements Serializable {

	private static final long serialVersionUID = 4514450478730109793L;


	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="agenda_id")
    private Agenda agenda;

    @OneToOne(fetch=FetchType.LAZY)
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

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		
		if (getAluno() == null){
			erro.addError("Informe o Aluno do agendamento.");
		}

		if (getAgenda() == null){
			erro.addError("Informe a Agenda do agendamento.");
		}
		
		if (erro.getErrors().size() == 0 && quantidadeMaximaDeAgendamentosAtingida()){
			erro.addError("Já existe projeção na agenda para a data de início.");
		}
		
		if(erro.getErrors().size() > 0) {
			throw erro;
		}
		
	}

	/**
	 * Verifica se a quantidade de agendamentos ja atingiu a quantidade maxima permitida
	 * para a Agenda escolhida
	 * @return BOOLEAN
	 */
	private boolean quantidadeMaximaDeAgendamentosAtingida() {
		
		//TENTATIVA 01 DE CONSULTAR QUANTIDADE DE AGENDAMENTOS JA FEITOS PARA UMA AGENDA
		//igual da classe Agenda.java
		return SaeInfra.getInstance()
			.getAgendamentoRepository()
			.getStreams()
			.where(a -> a.getAgenda().getId().intValue() == getAgenda().getId().intValue())
			.count() >= getAgenda().getQuantidadeAtendentes(); 
			
			
		//TENTATIVAS 02 E 03 DE CONSULTAR QUANTIDADE DE AGENDAMENTOS JA FEITOS PARA UMA AGENDA
/*		int quantidadeAgendamentosMesmoHorario = SaeInfra.getInstance().
				getAgendamentoRepository().getQuantidadeAgendamentosMesmoHorario(agenda);
		
		if (quantidadeAgendamentosMesmoHorario >= getAgenda().getQuantidadeAtendentes()) {
			return true;
		}
		
		return false;
*/		
	}
   
    
}