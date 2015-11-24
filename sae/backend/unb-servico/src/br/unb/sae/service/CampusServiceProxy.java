package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.erlangms.ervice.EmsServiceProxy;
import br.unb.sae.model.Campus;

@Stateless
public class CampusServiceProxy extends EmsServiceProxy {

	public Campus findById(Integer id){
		return getStream().from("/sitab/campus/:id")
				.setParameter(id)
				.request()
				.getObject(Campus.class);
	}

	
	public List<Campus> getListaCampus(){
		List<Campus> lista = getStream().from("/sitab/campus")
							.request()
							.toList(Campus.class);
		
		return lista;
	}

	public List<Object> find(String filter, String sort){
		List<Object> lista = getStream().from("/sitab/campus")
								.setQuery("filter", filter)
								.setQuery("sort", sort)
								.request()
								.toList();
		return lista;
	}


	public List<Object> getListaAluno() {
		return getStream().from("/sigra/aluno")
				.request()
				.toList();
	}
	
}
