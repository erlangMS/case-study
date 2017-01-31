package br.unb.questionario.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.questionario.model.Opcao;
import br.unb.questionario.model.RespostaItem;

@Stateless
public class RespostaItemRepository extends EmsRepository<RespostaItem> {
	
	private static String SQL_LISTA_RESPOSTAS_ITENS_VINCULADAS_A_RESPOSTA;
	
	@Override
	public EntityManager getEntityManager() {
		return QuestionarioInfra.getInstance().getSaeContext();
	}

	@Override
	public Class<RespostaItem> getClassOfModel() {
		return RespostaItem.class;
	}

	@SuppressWarnings("unchecked")
	public List<Opcao> listaRespostasItensVinculadasAResposta(Integer idResposta) {
		return getEntityManager()
				.createQuery(SQL_LISTA_RESPOSTAS_ITENS_VINCULADAS_A_RESPOSTA)
				.setParameter("idResposta", idResposta)
				.getResultList();
	}
	
	
	protected void createCacheSQL(){
		SQL_LISTA_RESPOSTAS_ITENS_VINCULADAS_A_RESPOSTA = "SELECT this from RespostaItem this "+
		    											 " WHERE this.resposta = :idResposta";
	
	}
	

}
