package br.unb.questionario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="QuestionarioPergunta",
	   uniqueConstraints = {@UniqueConstraint(columnNames={"QpCodigo", "QpPerCodigoPergunta"})}
	
)
public class QuestionarioPergunta implements Serializable {

	private static final long serialVersionUID = 7983077560355890060L;

	@Id
    @Column(name = "QpCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "QpQueCodigoQuestionario", nullable = true, insertable = true, updatable = true)
	private Integer questionario;
	
    @Column(name = "QpPerCodigoPergunta", nullable = true, insertable = true, updatable = true)
	private Integer pergunta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Integer questionario) {
		this.questionario = questionario;
	}

	public Integer getPergunta() {
		return pergunta;
	}

	public void setPergunta(Integer pergunta) {
		this.pergunta = pergunta;
	}

	
	
}
