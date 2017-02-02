package br.unb.questionario.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.questionario.model.Opcao;
import br.unb.questionario.model.Resposta;

@Stateless
public class RespostaRepository extends EmsRepository<Resposta> {
	
	private static String SQL_LISTA_RESPOSTA_VINCULADAS_A_PERGUNTA;
	private static String SQL_LISTA_RESPOSTAS_VINCULADAS_AO_QUESTIONARIO;
	
	@Override
	public EntityManager getEntityManager() {
		return QuestionarioInfra.getInstance().getSaeContext();
	}

	@Override
	public Class<Resposta> getClassOfModel() {
		return Resposta.class;
	}

	
	public Resposta listaRespostaVinculadasAPergunta(Integer idPergunta) {
		return (Resposta) getEntityManager()
				.createQuery(SQL_LISTA_RESPOSTA_VINCULADAS_A_PERGUNTA)
				.setParameter("idPergunta", idPergunta)
				.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Resposta> listaRespostasVinculadasAoQuestionario(Integer idQuestionario) {
		return getEntityManager()
				.createQuery(SQL_LISTA_RESPOSTAS_VINCULADAS_AO_QUESTIONARIO)
				.setParameter("idQuestionario", idQuestionario)
				.getResultList();
	}
	
	
	protected void createCacheSQL(){
		SQL_LISTA_RESPOSTA_VINCULADAS_A_PERGUNTA = "SELECT this from Resposta this "+
		    											 " WHERE this.pergunta = :idPergunta";
		
		SQL_LISTA_RESPOSTAS_VINCULADAS_AO_QUESTIONARIO = "SELECT this from Resposta this "+
				 " WHERE this.questionario = :idQuestionario";
	
	}
	

}
