describe("CategoriaPergunta", function() {
 
 beforeEach(function() {

 });

 
 it("Verifica se consegue obter uma lista de categorias de perguntas", function() {
	var result = $.ajax({
					url:  "http://localhost:2301/questionario/categoria_pergunta",
					data : {},
					type: "GET",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(200);
	if (result.status == 200){
		expect(result.responseJSON).toEqual(jasmine.any(Object));
	}
 });


 
 it("Verifica se consegue incluir, modificar e excluir um cadastro de categoria pergunta", function() {

	var testeId = Math.floor(Math.random() * 99999999);

	// define os dados do cadastro
	var obj = {"denominacao" : "Dados Familiares Teste "+ testeId};
	
	// tenta incluir		   
	var result = $.ajax({
					url:  "http://localhost:2301/questionario/categoria_pergunta",
					data : JSON.stringify(obj),
					type: "POST",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});

	expect(result.status).toBe(201);
	expect(result.responseJSON).toBeDefined();

	var objInserido = result.responseJSON;

	// se incluiu, tenta modificar o registro
	if (result.status == 201 && objInserido.id != undefined){
		
			// vamos fazer uma modificação no registro
			objUpdate = objInserido;
			objUpdate.denominacao = objUpdate.denominacao + "(update)";

			// tenta modificar		   
			var result = $.ajax({
							url:  "http://localhost:2301/questionario/categoria_pergunta/"+ objUpdate.id,
							data : JSON.stringify(objUpdate),
							type: "PUT",
							contentType: "application/x-www-form-urlencoded; charset=UTF-8",
							dataType: "json",
							crossDomain: true,
							async: false
						});
			expect(result.status).toBe(200);

			// vamos apagar o registro do teste
			var result = $.ajax({
							url:  "http://localhost:2301/questionario/categoria_pergunta/"+ objInserido.id,
							type: "DELETE",
							contentType: "application/x-www-form-urlencoded; charset=UTF-8",
							dataType: "json",
							crossDomain: true,
							async: false
						});
			expect(result.status).toBe(200);
	}
	
 });



 it("Verifica se consegue pesquisar um cadastro de categoria de pergunta pelo id", function() {

	var testeId = Math.floor(Math.random() * 99999999);

	// define os dados do cadastro
	var obj = {"denominacao" : "Dados Familiares Teste "+ testeId};
	
	// tenta incluir categoria de pergunta para o teste		   
	var result = $.ajax({
					url:  "http://localhost:2301/questionario/categoria_pergunta",
					data : JSON.stringify(obj),
					type: "POST",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(201);
	expect(result.responseJSON).toBeDefined();
	
	var idCategoria = result.responseJSON.id;

	// faz a pesquisa
	var result = $.ajax({
					url:  "http://localhost:2301/questionario/categoria_pergunta/"+ idCategoria,
					type: "GET",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(200);

	// vamos apagar o registro do teste
	var result = $.ajax({
					url:  "http://localhost:2301/questionario/categoria_pergunta/"+ idCategoria,
					type: "DELETE",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(200);
	
 });

 
});
