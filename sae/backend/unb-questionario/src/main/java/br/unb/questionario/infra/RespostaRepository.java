package br.unb.questionario.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.questionario.model.Opcao;
import br.unb.questionario.model.Resposta;

@Stateless
public class RespostaRepository extends EmsRepository<Resposta> {
	
	private static String SQL_LISTA_RESPOSTAS_VINCULADAS_A_PERGUNTA;
	
	@Override
	public EntityManager getEntityManager() {
		return QuestionarioInfra.getInstance().getSaeContext();
	}

	@Override
	public Class<Resposta> getClassOfModel() {
		return Resposta.class;
	}

	@SuppressWarnings("unchecked")
	public List<Opcao> listaRespostasVinculadasAPergunta(Integer idPergunta) {
		return getEntityManager()
				.createQuery(SQL_LISTA_RESPOSTAS_VINCULADAS_A_PERGUNTA)
				.setParameter("idPergunta", idPergunta)
				.getResultList();
	}
	
	
	protected void createCacheSQL(){
		SQL_LISTA_RESPOSTAS_VINCULADAS_A_PERGUNTA = "SELECT this from Resposta this "+
		    											 " WHERE this.pergunta = :idPergunta";
	
	}
	

}
