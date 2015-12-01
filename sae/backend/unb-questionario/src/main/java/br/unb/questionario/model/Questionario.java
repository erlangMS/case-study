package br.unb.questionario.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.erlangms.EmsValidationException;
import br.unb.questionario.infra.QuestionarioInfra;

@Entity
@Table(name="Questionario")
public class Questionario implements Serializable {

	private static final long serialVersionUID = 5515922866139266680L;

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "denominacao", nullable = false, insertable = true, updatable = true, unique = true)
	private String denominacao;
	
	@Column(name = "dataInicio", nullable = false, insertable = true, updatable = true)
	private Date dataInicio;

	@Column(name = "dataFim", nullable = false, insertable = true, updatable = true)
	private Date dataFim;

	//@OneToMany(fetch=FetchType.LAZY, mappedBy="questionario", cascade=CascadeType.ALL)
	//private List<QuestionarioPergunta> listaPerguntas;

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


	public void validar() {
		EmsValidationException erro = new EmsValidationException();
		
		if (getDenominacao() == null || getDenominacao().isEmpty()){
			erro.addError("Informe a denominação.");
		}
		
		if(getDataInicio() == null) {
			erro.addError("Informe a data de início.");
		}

		if(getDataFim() == null) {
			erro.addError("Informe a data fim.");
		}

		if (getDataInicio() != null &&
				getDataFim() != null &&
				getDataInicio().after(getDataFim())){
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
		Questionario this_questionario = this;
		return QuestionarioInfra.getInstance()
					.getQuestionarioRepository()
					.getStreams(QuestionarioPergunta.class)
					.where(c -> c.getQuestionario().equals(this_questionario))
					.select(p -> p.getPergunta())
					.toList();
	}
	
}