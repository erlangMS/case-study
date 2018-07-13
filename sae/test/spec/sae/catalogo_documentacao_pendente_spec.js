describe("DocumentacaoPendente", function() {
 
 beforeEach(function() {

 });

 
 it("Verifica se consegue obter uma lista de documentação pendente do SAE", function() {
	var result = $.ajax({
					beforeSend: function(request) {
						request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
					}, 
					url:  "http://desenvservicos.unb.br/dados/sae/documentacao/pendente",
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


 
 it("Verifica se consegue incluir, modificar, pesquisar e excluir um cadastro de documentação pendente no SAE", function() {

	var testeId = Math.floor(Math.random() * 99999999);

	// define os dados do aluno
	var objAluno = {"nome":"Aluno Teste "+ testeId,
					"cpf": Math.floor(Math.random() * 99999999).toString(),
					"senha" : "10/10/2015"};
	
	// tenta incluir aluno
	var result = $.ajax({
					beforeSend: function(request) {
						request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
					}, 
					url:  "http://desenvservicos.unb.br/dados/sigra/aluno",
					data : JSON.stringify(objAluno),
					type: "POST",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(201);
	expect(result.responseJSON).toBeDefined();
	var idAluno = result.responseJSON.id;

	// define os dados do cadastro de questionário
	var objQuestionario = {"denominacao":"questionário de teste "+ testeId,
						   "dataInicio":"01/12/2015", 
						   "dataFim":"30/12/2015"}
	
	// tenta incluir questionario		   
	result = $.ajax({
					beforeSend: function(request) {
						request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
					}, 
					url:  "http://desenvservicos.unb.br/dados/questionario/questionario",
					data : JSON.stringify(objQuestionario),
					type: "POST",
					contentType: "application/json; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(201);
	expect(result.responseJSON).toBeDefined();
	var idQuestionario = result.responseJSON.id;


	// define os dados do cadastro estudo socioeconomico
	var objEstudo = {"periodo":"20141", 
					 "dataHora":"01/01/2014", 
					 "aluno":idAluno, 
					 "questionario":idQuestionario}
	
	// tenta incluir estudo		   
	result = $.ajax({
					beforeSend: function(request) {
						request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
					}, 
					url:  "http://desenvservicos.unb.br/dados/sae/estudo/socioeconomico",
					data : JSON.stringify(objEstudo),
					type: "POST",
					contentType: "application/json; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(201);
	expect(result.responseJSON).toBeDefined();
	var idEstudo = result.responseJSON.id;


	// define os dados do cadastro documentação
	var objDocumentacao = {"denominacao": "denominacao teste "+ testeId};
	
	// tenta incluir documentacao		   
	result = $.ajax({
					beforeSend: function(request) {
						request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
					}, 
					url:  "http://desenvservicos.unb.br/dados/sae/documentacao",
					data : JSON.stringify(objDocumentacao),
					type: "POST",
					contentType: "application/json; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(201);
	expect(result.responseJSON).toBeDefined();
	var idDocumentacao = result.responseJSON.id;


	// define os dados do cadastro documentação pendente
	var objDocPendente = {"dataHora":"01/10/2015 15:00",
						  "documentacao" : idDocumentacao,
						  "estudo" : idEstudo,
						  "entregue" : true};
	
	// tenta incluir documentacao pendente		   
	var result = $.ajax({
					beforeSend: function(request) {
						request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
					}, 
					url:  "http://desenvservicos.unb.br/dados/sae/documentacao/pendente",
					data : JSON.stringify(objDocPendente),
					type: "POST",
					contentType: "application/json; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(201);
	expect(result.responseJSON).toBeDefined();

	var objInserido = result.responseJSON;

	// se incluiu, tenta modificar o registro documentacao pendente
	if (result.status == 201 && objInserido.id != undefined){

			objUpdate = objInserido;
			objUpdate.entregue = false;
			objUpdate.documentacao = idDocumentacao;
			objUpdate.estudo = idEstudo,

			// tenta modificar		   
			result = $.ajax({
							beforeSend: function(request) {
								request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
							}, 
							url:  "http://desenvservicos.unb.br/dados/sae/documentacao/pendente/"+ objInserido.id,
							data : JSON.stringify(objUpdate),
							type: "PUT",
							contentType: "application/x-www-form-urlencoded; charset=UTF-8",
							dataType: "json",
							crossDomain: true,
							async: false
						});
			expect(result.status).toBe(200);


			// faz a pesquisa
			result = $.ajax({
							beforeSend: function(request) {
								request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
							}, 
							url:  "http://desenvservicos.unb.br/dados/sae/documentacao/pendente/"+ objInserido.id,
							type: "GET",
							contentType: "application/x-www-form-urlencoded; charset=UTF-8",
							dataType: "json",
							crossDomain: true,
							async: false
						});
			expect(result.status).toBe(200);


			// modificação feita, vamos apagar o registro do teste
			result = $.ajax({
							beforeSend: function(request) {
								request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
							}, 
							url:  "http://desenvservicos.unb.br/dados/sae/documentacao/pendente/"+ objInserido.id,
							type: "DELETE",
							contentType: "application/x-www-form-urlencoded; charset=UTF-8",
							dataType: "json",
							crossDomain: true,
							async: false
						});
			expect(result.status).toBe(200);
	}
	
	// vamos apagar o registro documentacao de teste
	result = $.ajax({
					beforeSend: function(request) {
						request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
					}, 
					url:  "http://desenvservicos.unb.br/dados/sae/documentacao/"+ idDocumentacao,
					type: "DELETE",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(200);
	
	// vamos apagar o registro estudo de teste
	result = $.ajax({
				beforeSend: function(request) {
					request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
				}, 
				url:  "http://desenvservicos.unb.br/dados/sae/estudo/socioeconomico/"+ idEstudo,
				type: "DELETE",
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				dataType: "json",
				crossDomain: true,
				async: false
			});
	expect(result.status).toBe(200);

	// vamos apagar o registro questionário de teste
	result = $.ajax({
					beforeSend: function(request) {
						request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
					}, 
					url:  "http://desenvservicos.unb.br/dados/questionario/questionario/"+ idQuestionario,
					type: "DELETE",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(200);				

	// vamos apagar o registro aluno de teste
	result = $.ajax({
					beforeSend: function(request) {
						request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
					}, 
					url:  "http://desenvservicos.unb.br/dados/sigra/aluno/"+ idAluno,
					type: "DELETE",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(200);				

 });


 
});
