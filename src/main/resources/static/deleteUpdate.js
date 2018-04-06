$(document).ready(function(){	
$('#modifica').click(function(){
	var id = $("#id").val();
	var username= $("#username").val();
	var password = $("#password").val();
	//$.ajaxSetup({contentType: "application/json;charset=UTF-8"});
	var Utente = {"id" : id, "password": password, "username": username};
	var utenteString = JSON.stringify(Utente);
    $.post({
    	url:"http://localhost:8080/update-utente",
    	contentType: "application/json",
        data: utenteString
       /*function(data){
        	$("#UserResult").text("ID: " + data.id + " - Nome: " + data.username +
            		" - Password: " + data.password);
        					  }*/
    });
    
    });
});

$(document).ready(function(){	
	$('#delete').click(function(){
		var id = $("#id").val();
		var username= $("#username").val();
		var password = $("#password").val();
		//$.ajaxSetup({contentType: "application/json;charset=UTF-8"});
		var Utente = {"id" : id, "password": password, "username": username};
		var utenteString = JSON.stringify(Utente);
	    $.post({
	    	url:"http://localhost:8080/delete-utente",
	    	contentType: "application/json",
	        data: utenteString
	       /*function(data){
	        	$("#UserResult").text("ID: " + data.id + " - Nome: " + data.username +
	            		" - Password: " + data.password);
	        					  }*/
	    });
	    
	    });
	});