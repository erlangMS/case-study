package br.unb.questionario.model;

import java.util.LinkedList;
import java.util.List;

import br.unb.questionario.service.QuestionarioApplication;

public class OpcaoGenerica {

	private Integer id;
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Converte o tipo Entrada em Opcoes Generica para a formacao da combo
	 * @param opcoes
	 * @return
	 */
	public List<OpcaoGenerica> converteEntradaEmGenerica(List<Opcao> opcoes){
		List<OpcaoGenerica> opcoesGenerica = new LinkedList<OpcaoGenerica>();
		OpcaoGenerica opcaoGenerica = new OpcaoGenerica();
		for(Opcao op: opcoes){
			opcaoGenerica.setId(op.getId());
			opcaoGenerica.setDescricao(op.getDescricao());					
			opcoesGenerica.add(opcaoGenerica);
		}
		return opcoesGenerica;		
	}
	/**
	 * Converte a resposta de um questionario em valores para formar a combo
	 * @param idQuestionario
	 * @return
	 */
	public List<OpcaoGenerica> converteRespostaQuestionarioEmGenerica(Integer idQuestionario) {
		List<OpcaoGenerica> opcoesGenerica = new LinkedList<OpcaoGenerica>();
		OpcaoGenerica opcaoGenerica = new OpcaoGenerica();
		List<Resposta> listaResposta = new Resposta().getRespostaPorQuestionario(idQuestionario);
		List<RespostaItem> listaRespostaItem = new LinkedList<RespostaItem>();

		for(Resposta rep: listaResposta){
			//Carrego as RespostaItem da Resposta
			listaRespostaItem = rep.getRespostaItemLista(rep.getId());
			//Pra cada RespostaItem
			for(RespostaItem item: listaRespostaItem){
				//Carrego a Pergunta daquela RespostaItem
				Pergunta pergunta = QuestionarioApplication.getInstance()
						.getPerguntaService()
						.findById(item.getPergunta());
				if(pergunta != null){
					//Agora procuro por pergunta cujo enunciado seja descricao
					if(pergunta.getEnunciado().toLowerCase().equals("descrição")){
						opcaoGenerica= new OpcaoGenerica();
						opcaoGenerica.setId(item.getId());
						opcaoGenerica.setDescricao(item.getDescricao());
						opcoesGenerica.add(opcaoGenerica);
					}				
				}else{
					// TODO: Throw erro aki pq a pergunta nao existe mais
				}							
			}
			
		}
		
		if(opcoesGenerica.size()> 0){
			return opcoesGenerica;
		}else{
			return null;
		}
	}
	
}
