package br.unb.sae.service;

import java.util.List;

import javax.ejb.Stateless;

import br.unb.sae.infra.SaeInfra;
import br.unb.sae.model.EstudoPreliminar;

@Stateless
public class EstudoPreliminarService {

	public EstudoPreliminar findById(Integer id) {
		return SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.findById(id);
	}

	public List<EstudoPreliminar> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public EstudoPreliminar update(EstudoPreliminar EstudoPreliminar){
		EstudoPreliminar.validar();
		return SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.update(EstudoPreliminar);
	}

	public EstudoPreliminar insert(EstudoPreliminar EstudoPreliminar) {
		EstudoPreliminar.validar();
		return SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.insert(EstudoPreliminar);
	}
	
	public boolean delete(Integer id) {
		return SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.delete(id);
	}
	
}
