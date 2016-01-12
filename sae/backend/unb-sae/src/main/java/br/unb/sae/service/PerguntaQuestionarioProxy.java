package br.unb.sae.service;

import javax.ejb.Stateless;

import br.erlangms.EmsServiceProxy;
import br.unb.sae.vo.PerguntaVo;

@Stateless
public class PerguntaQuestionarioProxy extends EmsServiceProxy {

	public PerguntaVo findById(Integer id){
		return getStream().from("/questionario/pergunta/:id")
				.setParameter(id)
				.request()
				.getObject(PerguntaVo.class);
	}

	
	
}
