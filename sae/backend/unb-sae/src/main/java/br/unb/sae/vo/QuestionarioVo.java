package br.unb.sae.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_Questionario")
public class QuestionarioVo implements Serializable {

	private static final long serialVersionUID = 5515922866139266680L;

	@Id
    @Column(name = "QueCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "QueDenominacao", nullable = false, insertable = true, updatable = true, unique = true)
	private String denominacao;
	
	@Column(name = "QueDataInicio", nullable = false, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;

	@Column(name = "QueDataFim", nullable = false, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim;

	@OneToOne
	@JoinColumn(name = "QueTQuCodigoTipo")
	private TipoQuestionarioVo tipoQuestionario;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = PerguntaVo.class, optional = false)
	@JoinColumn(name = "QuePerCodigoPergunta")
	private List<PerguntaVo> perguntas;
	
	public QuestionarioVo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getDenominacao() {
		return denominacao;
	}


	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}


	public Date getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	public Date getDataFim() {
		return dataFim;
	}


	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}


	public TipoQuestionarioVo getTipoQuestionario() {
		return tipoQuestionario;
	}


	public void setTipoQuestionario(TipoQuestionarioVo tipoQuestionario) {
		this.tipoQuestionario = tipoQuestionario;
	}


	
}
