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
@Table(name="TB_RespostaEstudoSE")
public class RespostaEstudoSocioEconomico implements Serializable {

	private static final long serialVersionUID = -7635163647849931120L;

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="RESESECodigoEstudo")
    private EstudoSocioEconomico estudo;

    @Column(name = "RESPerCodigoPergunta", nullable = false, insertable = true, updatable = true)
    private Integer pergunta;
    
    @Column(name = "RESResCodigoResposta", nullable = false, insertable = true, updatable = true)
    private Integer resposta;

    @Column(name = "RESRespostaSubjetiva", nullable = true, insertable = true, updatable = true, length = 8000)
    private String respostaSubjetiva;

    @Column(name = "RESPontuacaoCalculada", nullable = false, insertable = true, updatable = true)
    private double pontuacaoCalculada = 0.00;

    @Column(name = "RESPontuacaoAtribuida", nullable = true, insertable = true, updatable = true)
    private double pontuacaoAtribuida;

    @Column(name = "RESAssistenteSocial", nullable = true, insertable = true, updatable = true, length = 80)
    private String assistenteSocial;

    @Column(name = "RESJustificativa", nullable = true, insertable = true, updatable = true, length = 8000)
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
			erro.addError("Informe o Estudo socioeconomico.");
		}

		if (!EmsUtil.isFieldObjectValid(getPergunta())){
			erro.addError("Informe a pergunta.");
		}

		if (!EmsUtil.isFieldObjectValid(getResposta())){
			erro.addError("Informe a resposta.");
		}

		if(erro.getErrors().size() > 0) {
			throw erro;
		}
		
	}
 	
   
}