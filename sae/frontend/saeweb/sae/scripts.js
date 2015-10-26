/*
 * 
 * Classe controladora para o cadastro de valor alimentação
 * 
 */ 
var valorAlimentacaoController = {
	/*
	 * Cache para listas de combobox. Assim não é necessário buscar todas as vezes que a tela sofre refresh 
	 * 
	 */ 
	lista_campus : null,

	
	/*
	 * Invocado "após" exibir o formulário. Útil para programar algo necessário após a tela já estar visível 
	 * 
	 */ 
	on_open_form : function(response){

	},
	
	on_format_object : function(obj){
		obj.pagaBeneficio = obj.pagaBeneficio ? "Sim" : "Não";  
	},


	/*
	 * Invocado para renderizar as celulas da grade de dados. Útil para formatar dados  
	 * 
	 */ 
	on_format_cell_datable : function(field, type, value, row, col, html_row){
		switch (field) {
			case "pagaBeneficio":  return (value || value === "true" || value === "1") ? "Sim" : "Não";
			default: return value;
		}
	},

	
	/*
	 * Invocado para renderizar o conteúdo de campos marcado como lazy. Útil para trazer os dados sem segundo plano de combobox, grids  
	 * 
	 */ 
	on_render_lazy_field : function(field){
		if (field.dataset.field === "campus"){
			fpc.callRestIfNull(this.lista_campus, '/sitab/campus')
				.done(function(result) {
					valorAlimentacaoController.lista_campus = result;
					fpc.fillComboboxFromArray(field, valorAlimentacaoController.lista_campus);
				});
			
		}
	},
	
    onchange : function(field, operacao) {
    	// Informar valor do benefício se paga benefício está habilitado
    	if (field.dataset.field === "pagaBeneficio"){
    		var f_valorBeneficio = f_cadastro.querySelector('[data-field=valorBeneficio]');
    		var b_pagaBeneficio = fpc.getValueFromRadioAsBoolean(field);
    		f_valorBeneficio.disabled = !b_pagaBeneficio;
    		f_valorBeneficio.value = "0.00";
    	}
    }
	

};


var estudoSocioEconomicoForm = {

	on_open_form : function(response){
		var doc = document;
		var param = response.params[0]; 
		var update_fields = param.update_fields;
		var f_form = doc.getElementById("f_form");
		//fpc.updateFields(f_form, update_fields);
		//fpc.resetFields(f_form);
	},
		
		
	salva_e_avanca : function(){
    	var doc = document;
    	var f_estudo = doc.getElementById("f_estudo");
    	var dat_estudo = f_estudo.dataset;
    	switch (dat_estudo.passoAtual) {
    		case "ler_edital":
    			this.avanca_etapa();
    			break;
    		case ("estudo_preliminar"):
    			var frm = doc.getElementById('f_estudo_preliminar'); 
    			var obj = fpc.getObject(frm);
    			this.avanca_etapa();
    			break;
    		case ("dados_pessoais"):
    			var frm = doc.getElementById('f_dados_pessoais'); 
				var obj = fpc.getObject(frm);
				this.avanca_etapa();
				break;
    		case ("dados_familiares"):
    			var frm = doc.getElementById('f_dados_familiares'); 
				var obj = fpc.getObject(frm);
				this.avanca_etapa();
    			break;
    		default:
    			throw new Error("Erro ao obter o formulário atual do questionário socioeconômico");
    	}
	},
		
    avanca_etapa : function(){
    	var doc = document;
    	var f_estudo = doc.getElementById("f_estudo");
    	var dat_estudo = f_estudo.dataset;
    	switch (dat_estudo.passoAtual) {
    		case "ler_edital":
    		    if (doc.getElementById('f_aceite').checked){
    		        doc.getElementById('f_estudo_preliminar').style.display = '';
    		        doc.getElementById('f_ler_edital').style.display = 'none';
    		        doc.getElementById("f_estudo").dataset.passoAtual = "estudo_preliminar";
    		    }else{
    		    	alert("Você deve ler o edital primeiro!");
    		    }
    		    break;
    		case ("estudo_preliminar"):
    			doc.getElementById('f_dados_pessoais').style.display = '';
    			doc.getElementById('f_estudo_preliminar').style.display = 'none';
    			doc.getElementById("f_estudo").dataset.passoAtual = "dados_pessoais";
    			break;
    		case ("dados_pessoais"):
    			doc.getElementById('f_dados_familiares').style.display = '';
    			doc.getElementById('f_dados_pessoais').style.display = 'none';
    			doc.getElementById("f_estudo").dataset.passoAtual = "dados_familiares";
    			break;
    		case ("dados_familiares"):
    			doc.getElementById('f_bens').style.display = '';
    			doc.getElementById('f_dados_familiares').style.display = 'none';
    			doc.getElementById("f_estudo").dataset.passoAtual = "bens";
    			break;
    		default:
    			throw new Error("Erro ao obter o formulário atual do questionário socioeconômico");
    	}
    },
    
    volta_etapa : function(){
    	var doc = document;
    	var f_estudo = doc.getElementById("f_estudo");
    	var dat_estudo = f_estudo.dataset;

    	switch (dat_estudo.passoAtual) {
    		case "ler_edital":
    			 window.history.back();
    		    break;
    		case ("estudo_preliminar"):
    			doc.getElementById('f_ler_edital').style.display = '';
    			doc.getElementById('f_estudo_preliminar').style.display = 'none';
    			doc.getElementById("f_estudo").dataset.passoAtual = "ler_edital";
    			break;
    		case ("dados_pessoais"):
    			doc.getElementById('f_estudo_preliminar').style.display = '';
    			doc.getElementById('f_dados_pessoais').style.display = 'none';
    			doc.getElementById("f_estudo").dataset.passoAtual = "estudo_preliminar";
    			break;
    		case ("dados_familiares"):
    			doc.getElementById('f_dados_pessoais').style.display = '';
    			doc.getElementById('f_dados_familiares').style.display = 'none';
    			doc.getElementById("f_estudo").dataset.passoAtual = "dados_pessoais";
    			break;
    		case ("bens"):
    			doc.getElementById('f_dados_familiares').style.display = '';
    			doc.getElementById('f_bens').style.display = 'none';
    			doc.getElementById("f_estudo").dataset.passoAtual = "dados_familiares";
    			break;
    		default:
    			throw new Error("Erro ao obter o formulário atual do questionário socioeconômico");
    	}
    },
    
    get_form_etapa_atual : function(){
    	var doc = document;
    	var f_estudo = doc.getElementById("f_estudo");
    	var dat_estudo = f_estudo.dataset;
    	switch (dat_estudo.passoAtual) {
    		case "ler_edital":	return doc.getElementById('f_ler_edital'); 
    		case ("estudo_preliminar"): return doc.getElementById('f_estudo_preliminar'); 
    		case ("dados_pessoais"): return doc.getElementById('f_dados_pessoais'); 
    		case ("dados_familiares"): return doc.getElementById('f_dados_familiares');
    		case ("bens"): return doc.getElementById('f_bens'); 
    		default: throw new Error("Erro ao obter o formulário atual do questionário socioeconômico");
    	}
    }
    
};    

