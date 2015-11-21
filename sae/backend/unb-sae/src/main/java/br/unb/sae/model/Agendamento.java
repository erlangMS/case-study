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

@Entity
@Table(name="TB_Agendamento")
public class Agendamento {

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @Column(name = "agenda_id", nullable = false, insertable = true, updatable = true)
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

		
		if(erro.getErrors().size() > 0) {
			throw erro;
		}
		
	}

   
    
}