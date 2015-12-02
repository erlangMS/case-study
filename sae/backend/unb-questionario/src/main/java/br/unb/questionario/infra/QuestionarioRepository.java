package br.unb.questionario.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.questionario.model.Pergunta;
import br.unb.questionario.model.Questionario;

@Stateless
public class QuestionarioRepository extends EmsRepository<Questionario> {
	
	private static String SQL_LISTA_PERGUNTAS_VINCULADAS_AO_QUESTIONARIO;
	private static String SQL_DESVINCULA_PERGUNTA_DO_QUESTIONARIO;


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
		return getEntityManager()
			.createQuery(SQL_LISTA_PERGUNTAS_VINCULADAS_AO_QUESTIONARIO)
			.setParameter("pQuestionario", questionario)
			.getResultList();
	}

	public void desvinculaPergunta(Integer questionario_id, int pergunta_id) {
		getEntityManager()
			.createQuery(SQL_DESVINCULA_PERGUNTA_DO_QUESTIONARIO)
			.setParameter("pQuestionario", questionario_id)
			.setParameter("pPergunta", pergunta_id)
			.executeUpdate();
	}
	
	protected void createCacheSQL(){
		SQL_LISTA_PERGUNTAS_VINCULADAS_AO_QUESTIONARIO = "select this.pergunta from QuestionarioPergunta this "+
		    											 "where this.questionario = :pQuestionario";
		
		SQL_DESVINCULA_PERGUNTA_DO_QUESTIONARIO = "delete from QuestionarioPergunta this "+
				 								  "where this.questionario.id = :pQuestionario "+
												  "  and this.pergunta.id = :pPergunta";

	
	}

}
