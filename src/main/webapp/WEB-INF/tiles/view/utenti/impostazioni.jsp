<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Modifica i tuoi dati</h3>
                    </div>
                    <div class="panel-body">        	
                    		<input type="hidden" id="id" value="${us.id}">
                            <fieldset>
                            <c:if test="${pageContext.request.userPrincipal.name == 'admin@admin.it'}">
                                <div class="form-group">
                                  Username:  <input class="form-control" id="username"  readonly  name="username" type="email" value="${pageContext.request.userPrincipal.name}" >
                                </div>
                             </c:if>
                             <c:if test="${pageContext.request.userPrincipal.name != 'admin@admin.it'}">
                                <div class="form-group">
                                  Username:  <input class="form-control" id="username"  readonly  name="username" type="email" value="${us.username}" >
                                </div>
                             </c:if>
                             
                                <div class="form-group">
                                  Password: <input class="form-control" id="password"  name="password" type="password" >
                                </div>
                                <input type="submit" class="btn btn-lg btn-success" id="modifica" value="Modifica"/>
                                <c:if test="${pageContext.request.userPrincipal.name != 'admin@admin.it'}">
                              <a href="/j_spring_security_logout">  <input type="button" class="btn btn-lg btn-success" id="cancella" value="Cancella Account"/> </a>
                           		</c:if>
                            </fieldset>
                    </div>
                </div> 
            </div>
        </div>
    </div>
<script>
$(document).ready(function(){	
	$('#modifica').click(function(){
		var id = $("#id").val();
		var username= $("#username").val();
		var password = $("#password").val();
		//$.ajaxSetup({contentType: "application/json;charset=UTF-8"});
		var Utente = {"id" : id, "password": password, "username": username};
		var utenteString = JSON.stringify(Utente);
		var lunghezza_pass=password.length;
		console.log(Utente);
		if(!!password && lunghezza_pass>8){
    	    $.post({
    	    	url:"http://localhost:8080/update-utente",
    	    	contentType: "application/json",
    	        data: utenteString
    	       /*function(data){
    	        	$("#UserResult").text("ID: " + data.id + " - Nome: " + data.username +
    	            		" - Password: " + data.password);
    	        					  }*/
    	    });
    	    alert("Modifica effettuata con successo!")
    		}
    		else
    		{
    		alert("Formato password non corretto");
    		}
    	    });
	});
	
	$('#cancella').click(function(){
		var id = $("#id").val();
	 $.get("http://localhost:8080/delete-utente?id="+id); 
	 
	});
</script>














