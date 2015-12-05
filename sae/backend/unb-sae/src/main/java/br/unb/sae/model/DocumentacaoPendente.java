package br.unb.sae.model;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@Table(name="DocumentacaoPendente")
public class DocumentacaoPendente implements Serializable {

	private static final long serialVersionUID = -4121261049751377228L;

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @Column(name = "dataHora", nullable = false, insertable = true, updatable = true, length = 8)
    private Date dataHora;
    
    @Column(name = "entregue", nullable = false, insertable = true, updatable = true)
    private boolean entregue = false;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="aluno_Id")
    private AlunoSae aluno;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public boolean isEntregue() {
		return entregue;
	}

	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}

	public AlunoSae getAluno() {
		return aluno;
	}

	public void setAluno(AlunoSae aluno) {
		this.aluno = aluno;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if (!EmsUtil.isDateValid(getDataHora())){
			erro.addError("Informe uma data e hora.");
		}
		
		if(erro.getErrors().size() > 0) {
			throw erro;
		}
		
	}


    
}