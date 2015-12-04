package br.unb.sae.model;

import java.io.Serializable;

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
@Table(name="RespostaEstudoPreliminar")
public class RespostaEstudoPreliminar implements Serializable {

	private static final long serialVersionUID = 2375061529441558038L;

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @Column(name = "pontuacaoCalculada", nullable = false, insertable = true, updatable = true)
    private double pontuacaoCalculada;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="estudo_preliminar_Id")
    private EstudoPreliminar estudoPreliminar;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPontuacaoCalculada() {
		return pontuacaoCalculada;
	}

	public void setPontuacaoCalculada(double pontuacaoCalculada) {
		this.pontuacaoCalculada = pontuacaoCalculada;
	}

	public EstudoPreliminar getEstudoPreliminar() {
		return estudoPreliminar;
	}

	public void setEstudoPreliminar(EstudoPreliminar estudoPreliminar) {
		this.estudoPreliminar = estudoPreliminar;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if (!EmsUtil.isFieldObjectValid(getEstudoPreliminar())){
			erro.addError("Informe um Estudo preliminar.");
		}

		if(erro.getErrors().size() > 0) {
			throw erro;
		}
		
	}
   
}