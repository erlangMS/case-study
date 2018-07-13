describe("Campus", function() {
 
 beforeEach(function() {

 });

 
 it("Verifica se consegue obter uma lista de campus cadastrados no Sitab", function() {
	var result = $.ajax({
					beforeSend: function(request) {
						request.setRequestHeader("Authorization", "Bearer " + JSON.parse(localStorage.getItem( "token" ))["access_token"]);
					}, 
					url:  "http://desenvservicos.unb.br/dados/sitab/campus",
					data : {},
					type: "GET",
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
					dataType: "json",
					crossDomain: true,
					async: false
				});
	expect(result.status).toBe(200);
 });

 
});
