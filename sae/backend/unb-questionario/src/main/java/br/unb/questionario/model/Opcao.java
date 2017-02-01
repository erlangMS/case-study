package br.unb.questionario.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;
import br.unb.questionario.infra.QuestionarioInfra;

@Entity
@Table(name = "TB_Opcao",
	uniqueConstraints = {@UniqueConstraint(columnNames={"OpcPerCodigoPergunta", "OpcValorResposta"})}
)
public class Opcao {

	@Id
	@Column(name = "OpcCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "OpcDescricao", nullable = true, insertable = true, updatable = true)
	private String descricao;
	
	@Column(name = "OpcTipoOpcao", nullable = true, insertable = true, updatable = true)
	private Integer tipoOpcao;

	// caso a opcao seja uma respota a outro questionario
	@Column(name = "OpcIdQuestionario", nullable = true, insertable = true, updatable = true)
	private Integer idQuestionario;
	
	@Column(name = "OpcIdTabelaSitab", nullable = true, insertable = true, updatable = true)
	private Integer idTabelaSitab;
	
	@Column(name = "OpcServico", nullable = true, insertable = true, updatable = true)
	private String nomeServico;
	
	@Column(name = "OpcPerCodigoPergunta", nullable = true, insertable = true, updatable = true)
	private Integer pergunta;

	@Column(name = "OpcValorResposta", nullable = false, insertable = true, updatable = true)
	private float valorResposta;
	
	@Column(name = "OpcAtiva", nullable = true, insertable = true, updatable = true)
	private boolean ativa = true;

	public Opcao() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPergunta() {
		return pergunta;
	}

	public void setPergunta(Integer
			pergunta) {
		this.pergunta = pergunta;
	}

	public float getValorResposta() {
		return valorResposta;
	}

	public void setValorResposta(float valorResposta) {
		this.valorResposta = valorResposta;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if(tipoOpcao == TipoOpcao.Entrada.getCodigo()){	
			if (!EmsUtil.isFieldStrValid(getDescricao())) {
				erro.addError("Informe a descrição da opção.");
			}
			if (!EmsUtil.isFieldObjectValid(getValorResposta())) {
				erro.addError("Informe o valor da opção.");
			}
			if (getPergunta() == null || (getPergunta() != null && getPergunta() == 0)) {
				erro.addError("Informe a pergunta a qual a opção se destina.");
			}
		}else if(tipoOpcao == TipoOpcao.RespostaQuestionario.getCodigo()) {
			if (!EmsUtil.isFieldObjectValid(getIdQuestionario())) {
				erro.addError("Informe o Questionário Resposta.");
			}
			// TODO: O questionário selecionado deve ser diferente do Questionario atual da pergunta
			/*if(getIdQuestionario() == ){
				
			// TODO: O cara nao pode ter mais de uma opcao caso selecione RespostaQuestionario, Servico, Sitab	
			}*/
			
		}else if(tipoOpcao == TipoOpcao.Servico.getCodigo()){
			if (!EmsUtil.isFieldStrValid(getDescricao())) {
				erro.addError("Informe a URL do serviço.");
			}		
		}else if(tipoOpcao == TipoOpcao.Sitab.getCodigo()){
			if (!EmsUtil.isFieldStrValid(getDescricao())) {
				erro.addError("Informe a Tabela do Sitab.");
			}
		}

		if (erro.getErrors().size() > 0) {
			throw erro;
		}
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public Integer getIdQuestionario() {
		return idQuestionario;
	}

	public void setIdResposta(Integer idQuestionario) {
		this.idQuestionario = idQuestionario;
	}

	public Integer getIdTabelaSitab() {
		return idTabelaSitab;
	}

	public void setIdTabelaSitab(Integer idTabelaSitab) {
		this.idTabelaSitab = idTabelaSitab;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public Integer getTipoOpcao() {
		return tipoOpcao;
	}

	public void setTipoOpcao(Integer tipoOpcao) {
		this.tipoOpcao = tipoOpcao;
	}

	
}
