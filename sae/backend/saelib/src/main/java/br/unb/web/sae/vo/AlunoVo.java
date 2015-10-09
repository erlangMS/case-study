package br.unb.web.sae.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AlunoVo  implements Serializable {
	private static final long serialVersionUID = -3550966618742264684L;

	@Id
	private Integer codigoPessoa;
	private Boolean bloqueado;
	private String nome;
	private String cpf;

	public Integer getCodigoPessoa() {
		return codigoPessoa;
	}
	public void setCodigoPessoa(Integer codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}
	public boolean isBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
