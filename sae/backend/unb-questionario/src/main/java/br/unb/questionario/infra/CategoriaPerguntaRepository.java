package br.unb.questionario.infra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.questionario.model.CategoriaPergunta;

@Stateless
public class CategoriaPerguntaRepository extends EmsRepository<CategoriaPergunta> {
	
	@Override
	public EntityManager getEntityManager() {
		return QuestionarioInfra.getInstance().getSaeContext();
	}

	@Override
	public Class<CategoriaPergunta> getClassOfModel() {
		return CategoriaPergunta.class;
	}
	

}
