package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.erlangms.samples.service.EmsServiceProxy;

@Stateless
public class CampusServiceProxy extends EmsServiceProxy {

	public class Campus{
		private Integer id;
		private String nome;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
	}
	
	public Campus findById(Integer id){
		return (Campus) getStream().from("/sitab/campus/:id")
							.setParameter(id)
							.request()
							.getObject(Campus.class);
	}

	
	public List<Object> getListaCampus(){
		List<Object> lista = getStream()
							.from("/sitab/campus")
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
