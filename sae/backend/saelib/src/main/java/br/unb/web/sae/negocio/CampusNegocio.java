package br.unb.web.sae.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.unb.web.sae.pojo.Campus;

@Stateless
public class CampusNegocio {
	private List<Campus> listaCampus;
	
	public CampusNegocio(){
		listaCampus = new ArrayList<Campus>();
		listaCampus.add(new Campus(1, "Brasilia"));
		listaCampus.add(new Campus(2, "Ceilandia"));
		listaCampus.add(new Campus(3, "Asa Norte"));
	}
	
	public Campus findById(Integer id) {
		for (int i = 0; i < listaCampus.size()-1; i++){
			if (listaCampus.get(i).id == id){
				return listaCampus.get(i);
			}
		}
		return null;
	}

	public List<Campus> getAll() {
		return listaCampus;
	}
	
}
