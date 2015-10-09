package br.unb.web.sae.negocio;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.erlangms.EmsValidation;
import br.unb.web.sae.persistencia.ValorAlimentacaoDAO;
import br.unb.web.sae.pojo.ValorAlimentacao;

@Stateless
public class ValorAlimentacaoNegocio {

	private static final double LIMITE = 100;
	
	@EJB
	private ValorAlimentacaoDAO dao;

	public ValorAlimentacao findById(Integer id) {
		return dao.findById(id);
	}

	public List<ValorAlimentacao> pesquisar(String filtro, String fields,
			int limit_ini, int limit_fim, String sort) {
		return dao.pesquisar(filtro, fields, limit_ini, limit_fim, sort);
	}

	public ValorAlimentacao update(ValorAlimentacao obj) throws EmsValidation{
		validar(obj);
		return dao.update(obj);
	}
	
	private void validar(ValorAlimentacao obj) throws EmsValidation {
		EmsValidation validation = new EmsValidation();
		
		boolean error = false;
		
		if(obj.getValorBeneficio() != null && obj.getValorBeneficio().doubleValue() > LIMITE) {
			validation.addError("Valor do beneficio > " + LIMITE);
			error = true;
		}
		
		if(error) {
			throw validation;
		}
	}
	

	
}
