package br.unb.questionario.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.erlangms.EmsValidationException;
import br.unb.questionario.infra.QuestionarioInfra;

@Entity
@Table(name = "TB_Resposta")
public class Resposta {

	@Id
	@Column(name = "ResCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ResDataCriacao", nullable = false, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name = "ResCodigoUsuario", nullable = true, insertable = true, updatable = true)
	private Integer codigoUsuario;
	
	@Column(name = "ResCodigoUsuarioAdministrador", nullable = true, insertable = true, updatable = true)
	private Integer codigoUsuarioAdministrador;
	
	@Column(name = "ResCodigoQuestionario", nullable = true, insertable = true, updatable = true)
	private Integer questionario;
	
	@Transient
	private List<RespostaItem> respostaItem;
							   
	
	public Resposta() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Integer getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Integer questionario) {
		this.questionario = questionario;
	}

	
	public List<RespostaItem> getRespostaItem() {
		return respostaItem;
	}

	public void setRespostaItem(List<RespostaItem> respostaItem) {
		this.respostaItem = respostaItem;
	}
	
	public Resposta getRespostaCompleta(Integer idResposta) {
		EmsValidationException erro = new EmsValidationException();		
		
		Resposta resposta = new Resposta();
		resposta = QuestionarioInfra.getInstance()
				.getRespostaRepository().findById(idResposta);
		if(resposta == null || (resposta != null && resposta.getId() == null)){
			erro.addError("Nenhum resposta encontrada com esse Id.");
		}else{
			resposta.setRespostaItem(getRespostaItemLista(resposta.id));
		}
		
		if(erro.getErrors().size() > 0) {
			throw erro;
		}
				
		return	resposta;
	}

	public List<RespostaItem> getRespostaItemLista(Integer idResposta) {
		int resposta_id = idResposta;
		return QuestionarioInfra.getInstance()
				.getRespostaItemRepository()
				.getStreams()
				.where(a -> a.getResposta() == resposta_id)
				.toList();	
	}

	
	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Integer getCodigoUsuarioAdministrador() {
		return codigoUsuarioAdministrador;
	}

	public void setCodigoUsuarioAdministrador(Integer codigoUsuarioAdministrador) {
		this.codigoUsuarioAdministrador = codigoUsuarioAdministrador;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if (erro.getErrors().size() > 0) {
			throw erro;
		}
	}

}
