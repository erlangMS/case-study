package br.unb.web.sae.pojo;

import java.io.Serializable;

import javax.persistence.Column;

import br.unb.sae.model.EstudosSocioEconomicos;

public class EstudosSocioEconomicosPK implements Serializable {
	private static final long serialVersionUID = 4588925885873895427L;
	
    @Column(name = "Aluno", nullable = false, insertable = true, updatable = true)
	private Integer aluno;

    @Column(name = "SemestreAno", nullable = false, insertable = true, updatable = true, length = 5)
    private String semestreAno;
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((semestreAno == null) ? 0 : semestreAno.hashCode());
		return result;
	}
	
    @Override
	public boolean equals(Object otherObject) {
		if (otherObject == this) {
			return true;
		}
		if (otherObject == null || !(otherObject instanceof EstudosSocioEconomicos)) {
			return false;
		}
		return false;
	}
	
	
}
