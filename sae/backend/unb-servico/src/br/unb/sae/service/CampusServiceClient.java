package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.erlangms.samples.service.EmsServiceClient;

@Stateless
public class CampusServiceClient extends EmsServiceClient {

	public Object findById(Integer id){
		Object campus = getStream().from("/sitab/campus/:id")
							.setParameter(0)
							.request()
							.getObject();
		return campus;
	}

	
	public List<Object> getListaCampus(){
		List<Object> lista = getStream().from("/sitab/campus")
								.request()
								.toList();
		
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
	
}
