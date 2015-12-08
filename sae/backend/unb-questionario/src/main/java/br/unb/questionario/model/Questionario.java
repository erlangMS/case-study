package br.unb.questionario.model;

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

import br.erlangms.EmsValidationException;
import br.unb.questionario.infra.QuestionarioInfra;
import br.unb.questionario.infra.extension.ValidateFields;

@Entity
@Table(name="TB_Questionario")
public class Questionario implements Serializable {

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
	private TipoQuestionario tipoQuestionario;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Pergunta.class, optional = false)
	@JoinColumn(name = "QuePerCodigoPergunta")
	private List<Pergunta> perguntas;
	
	public Questionario() {
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


	public TipoQuestionario getTipoQuestionario() {
		return tipoQuestionario;
	}


	public void setTipoQuestionario(TipoQuestionario tipoQuestionario) {
		this.tipoQuestionario = tipoQuestionario;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();
		
		if (!ValidateFields.isFieldStrValid(getDenominacao())){
			erro.addError("Informe a denominação.");
		}
		
		if(!ValidateFields.isDateValid(getDataInicio())) {
			erro.addError("Informe a data de início.");
		}

		if(!ValidateFields.isDateValid(getDataFim())) {
			erro.addError("Informe a data fim.");
		}

		if (!ValidateFields.isDateFinalAfterOrEqualDateInitial(getDataInicio(), getDataFim())){
			erro.addError("A data fim do questionário deve ser maior que a data de início.");
		}
		
		if(erro.getErrors().size() > 0) {
			throw erro;
		}
	}


	public void  vinculaPergunta(Pergunta pergunta){
		QuestionarioPergunta p = new QuestionarioPergunta();
		p.setPergunta(pergunta);
		p.setQuestionario(this);
		QuestionarioInfra.getInstance()
			.getQuestionarioRepository()
			.insert(p);
	}

	public List<Pergunta> getListaPerguntas(){
		return QuestionarioInfra.getInstance()
				.getQuestionarioRepository()
				.listaPerguntasVinculadaAoQuestionario(this);
	}


	public void desvinculaPergunta(int pergunta_id) {
		QuestionarioInfra.getInstance()
			.getQuestionarioRepository()
			.desvinculaPergunta(getId(), pergunta_id);
	}
	
}
