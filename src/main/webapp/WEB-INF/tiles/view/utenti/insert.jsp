

    <body>
<div id="includedContent"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Registrazione Utente</h3>
                    </div>
                    <div class="panel-body">
                         <input type="hidden" name="id" value = "-1">
                            <fieldset>
                                <div class="form-group">
                                  Username:  <input class="form-control" id="username"  name="username" type="email" >
                                </div>
                                <div class="form-group">
                                  Password: <input class="form-control" id="password"  name="password" type="password" >
                                </div>
                                <input type="submit" class="btn btn-lg btn-success btn-block" id="b1" value="Invio">
                            </fieldset>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script>
    $(document).ready(function(){	
    	$('#b1').click(function(){
    		var id = $("#id").val();
    		var username= $("#username").val();
    		var password = $("#password").val();
    		//$.ajaxSetup({contentType: "application/json;charset=UTF-8"});
    		var Utente = {"id" : id, "password": password, "username": username};
    		var utenteString = JSON.stringify(Utente);
    		var lunghezza_pass=password.length;
    		var chiocciola = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$/ ;
    		if(!!username && !!password && lunghezza_pass>8 && chiocciola.test(username)){
    	    $.post({
    	    	url:"http://localhost:8080/save-utente",
    	    	contentType: "application/json",
    	        data: utenteString
    	       /*function(data){
    	        	$("#UserResult").text("ID: " + data.id + " - Nome: " + data.username +
    	            		" - Password: " + data.password);
    	        					  }*/
    	    });
    	    alert("Registrazione effettuata con successo!")
    		}
    		else
    		{
    		alert("Inserisci utente o password corretta");
    		}
    	    });
    	});
</script>
