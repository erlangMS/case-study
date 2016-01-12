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
import javax.persistence.UniqueConstraint;

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;
import br.unb.sae.service.QuestionarioApplicationProxy;
import br.unb.sae.vo.PerguntaVo;
import br.unb.sae.vo.TipoRespostaVo;

@Entity
@Table(name="TB_RespostaEstudoSE",
	uniqueConstraints = {@UniqueConstraint(columnNames={"RESESECodigoEstudo", "RESPerCodigoPergunta"})}
)
public class RespostaEstudoSocioEconomico implements Serializable {

	private static final long serialVersionUID = -7635163647849931120L;

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="RESESECodigoEstudo")
    private EstudoSocioEconomico estudo;

    @Column(name = "RESPerCodigoPergunta", nullable = false)
    private Integer pergunta;
    
    @Column(name = "RESResCodigoResposta", nullable = true)
    private Integer resposta;

    @Column(name = "RESRespostaSubjetiva", nullable = true, length = 8000)
    private String respostaSubjetiva;

    @Column(name = "RESPontuacaoCalculada", nullable = false)
    private double pontuacaoCalculada = 0.00;

    @Column(name = "RESPontuacaoAtribuida", nullable = true)
    private double pontuacaoAtribuida;

    @Column(name = "RESAssistenteSocial", nullable = true, length = 80)
    private String assistenteSocial;

    @Column(name = "RESJustificativa", nullable = true, length = 8000)
    private String justificativa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstudoSocioEconomico getEstudoSocioEconomico() {
		return estudo;
	}

	public void setEstudo(EstudoSocioEconomico estudo) {
		this.estudo = estudo;
	}


	public Integer getPergunta() {
		return pergunta;
	}

	public void setPergunta(Integer pergunta) {
		this.pergunta = pergunta;
	}

	public Integer getResposta() {
		return resposta;
	}

	public void setResposta(Integer resposta) {
		this.resposta = resposta;
	}

	public EstudoSocioEconomico getEstudo() {
		return estudo;
	}

	public String getRespostaSubjetiva() {
		return respostaSubjetiva;
	}

	public void setRespostaSubjetiva(String respostaSubjetiva) {
		this.respostaSubjetiva = respostaSubjetiva;
	}

	public double getPontuacaoCalculada() {
		return pontuacaoCalculada;
	}

	public void setPontuacaoCalculada(double pontuacaoCalculada) {
		this.pontuacaoCalculada = pontuacaoCalculada;
	}

	public double getPontuacaoAtribuida() {
		return pontuacaoAtribuida;
	}

	public void setPontuacaoAtribuida(double pontuacaoAtribuida) {
		this.pontuacaoAtribuida = pontuacaoAtribuida;
	}

	public String getAssistenteSocial() {
		return assistenteSocial;
	}

	public void setAssistenteSocial(String assistenteSocial) {
		this.assistenteSocial = assistenteSocial;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if (!EmsUtil.isFieldObjectValid(getEstudoSocioEconomico())){
			erro.addError("Informe o estudo socioeconomico.");
		}

		if (!EmsUtil.isFieldObjectValid(getPergunta())){
			erro.addError("Informe a pergunta.");
		}

		PerguntaVo perguntaVo = QuestionarioApplicationProxy.getInstance()
			.getPerguntaQuestionarioProxy()
			.findById(getPergunta());
		
		// Só é possível responder pergunta ativa
		if (!perguntaVo.isAtiva()){
			erro.addError("A pergunta foi desativada.");
		}

		// Se a pergunta for de multipla escolha ou uma escolha é preciso o id da resposta
		if (perguntaVo.getTipoResposta() == TipoRespostaVo.EscolhaUma && !EmsUtil.isFieldObjectValid(getResposta())){
				erro.addError("Informe resposta para pergunta de uma escolha.");
		}

		if (perguntaVo.getTipoResposta() == TipoRespostaVo.MultiplaEscola && !EmsUtil.isFieldObjectValid(getResposta())){
				erro.addError("Informe resposta para pergunta de múltipla escolha.");
		}

		if(erro.getErrors().size() > 0) {
			throw erro;
		}
		
	}
 	
   
}