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

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;
import br.unb.sae.infra.SaeInfra;

@Entity
@Table(name="TB_Agendamento")
public class Agendamento {

	@Id
    @Column(name = "AgoCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="AgoAgeCodigoAgenda")
    private Agenda agenda;

    @Column(name="AgoAluMatricula")
    private Integer aluno;

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

	public Integer getAluno() {
		return aluno;
	}

	public void setAluno(Integer aluno) {
		this.aluno = aluno;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		
		if (!EmsUtil.isFieldObjectValid(getAgenda())){
			erro.addError("Informe a Agenda do agendamento.");
		}
		
		if (erro.getErrors().size() == 0 && quantidadeMaximaDeAgendamentosAtingida()){
			erro.addError("A quantidade de agendamentos para este mesmo dia e horário já foi atingida.");
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
   
	
}