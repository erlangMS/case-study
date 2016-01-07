package br.unb.sae.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EstudosSocioEconomicos")
public class EstudosSocioEconomico implements Serializable {
	private static final long serialVersionUID = 5471384039041899158L;

	@Id
    @Column(name = "ESECodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "ESEPeriodo", nullable = false, insertable = true, updatable = true, length = 5)
	private String periodo;

	@Column(name = "ESEDataHora", nullable = false, insertable = true, updatable = true, length = 8)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;

	@Column(name = "ESEPontuacaoCalculada", nullable = false, insertable = true, updatable = true)
	private double pontuacaoCalculada = 0.0;

	@Column(name = "ESEPontuacaoAtribuida", nullable = false, insertable = true, updatable = true)
	private double pontuacaoAtribuida = 0.0;

	@Column(name = "ESEPontuacaoFinal", nullable = false, insertable = true, updatable = true)
	private double pontuacaoFinal = 0.0;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ESEAluMatricula")
	private AlunoSae aluno;

	@Column(name = "ESEClassificacaoCEU", nullable = false, insertable = true, updatable = true)
	private Integer classificacaoCEU;

	@Column(name = "ESEParecerTecnico", nullable = false, insertable = true, updatable = true, length = 8000)
	private String parecer;

	@Column(name = "ESEPontuacaoParecer", nullable = false, insertable = true, updatable = true)
	private double pontuacaoParecer = 0.0;

	@Column(name = "ESEJustificativa", nullable = false, insertable = true, updatable = true, length = 8000)
	private String justificativa;

	@Column(name = "ESEQueCodigoQuestionario", nullable = false, insertable = true, updatable = true)
	private Integer questionario;

	@Column(name = "ESESituacao", nullable = false, insertable = true, updatable = true)
	private Integer situacao;

	
}
