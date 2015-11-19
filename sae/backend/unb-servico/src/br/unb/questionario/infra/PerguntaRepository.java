package br.unb.questionario.infra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.questionario.model.Pergunta;
import br.unb.sae.infra.SaeInfra;

@Stateless
public class PerguntaRepository extends EmsRepository<Pergunta> {
	
	@Override
	public EntityManager getEntityManager() {
		return SaeInfra.getInstance().getSaeContext();
	}

	@Override
	public Class<Pergunta> getClassOfModel() {
		return Pergunta.class;
	}
	

}
