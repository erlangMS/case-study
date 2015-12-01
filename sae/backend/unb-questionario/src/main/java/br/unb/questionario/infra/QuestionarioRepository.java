package br.unb.questionario.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.questionario.model.Pergunta;
import br.unb.questionario.model.Questionario;

@Stateless
public class QuestionarioRepository extends EmsRepository<Questionario> {
	
	@Override
	public EntityManager getEntityManager() {
		return QuestionarioInfra.getInstance().getSaeContext();
	}

	@Override
	public Class<Questionario> getClassOfModel() {
		return Questionario.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pergunta> listaPerguntasVinculadaAoQuestionario(Questionario questionario){
		final String sql = "select this.pergunta from QuestionarioPergunta this where ap.questionario = :pQuestionario";
		return getEntityManager()
			.createQuery(sql)
			.setParameter("pQuestionario", questionario)
			.getResultList();
	}
	

}
