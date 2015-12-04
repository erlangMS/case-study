package br.unb.questionario.infra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.questionario.model.TipoQuestionario;

@Stateless
public class TipoQuestionarioRepository extends EmsRepository<TipoQuestionario> {
	
	@Override
	public EntityManager getEntityManager() {
		return QuestionarioInfra.getInstance().getSaeContext();
	}

	@Override
	public Class<TipoQuestionario> getClassOfModel() {
		return TipoQuestionario.class;
	}
	

}
