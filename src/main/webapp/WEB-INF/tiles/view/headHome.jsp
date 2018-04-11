<html lang="it">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Salva risorsa</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="static/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="static/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="static/jquery/jquery.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/metisMenu/metisMenu.min.js"></script>
    <script src="static/dist/js/sb-admin-2.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/fileCss.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
</head>
    <script>
    $(document).ready(function(){	
    $( "#nonFarlo" ).click(function() {
    	  alert( "Accedi o Registrati" );
    	});
    });
    </script>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <div>
      <nav class="navbar navbar-default colore">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><img src="noleggio.png"  class="img-responsive" id="logo"></a>
          </div>
          <div id="navbar" class="navbar-collapse collapse barra">
            <ul class="nav navbar-nav">
              <li><a href="/">Home</a></li>
              <sec:authorize access="hasRole('ADMIN')">
              <li><a href="/gestione_utenti">Utenti</a></li>       
              </sec:authorize>
              <sec:authorize access="hasRole('ADMIN')">
              <li><a href="/gestisci_risorse">Risorse</a></li>
              </sec:authorize>
              <c:if test="${pageContext.request.userPrincipal.name != 'admin@admin.it'}">
              <li><a href="/gestiscirisorseUtente">Risorse</a></li>
              </c:if>
              <li>   
					<c:if  test = "${pageContext.request.userPrincipal.name == null}">
					              <a href="/login_utente" id="nonFarlo">Prenotazioni</a>
					 </c:if>
					 <c:if  test = "${pageContext.request.userPrincipal.name != null}">
					              <a href="/prenotazioni">Prenotazioni</a>
					 </c:if>
			 </li>
<!--               <li class="dropdown"> -->
<!--                 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a> -->
<!--                 <ul class="dropdown-menu"> -->
<!--                   <li><a href="#">Action</a></li> -->
<!--                   <li><a href="#">Another action</a></li> -->
<!--                   <li><a href="#">Something else here</a></li> -->
<!--                   <li role="separator" class="divider"></li> -->
<!--                   <li class="dropdown-header">Nav header</li> -->
<!--                   <li><a href="#">Separated link</a></li> -->
<!--                   <li><a href="#">One more separated link</a></li> -->
<!--                 </ul> -->
<!--               </li> -->
            </ul>
            <c:if  test = "${pageContext.request.userPrincipal.name != null}">
            <ul class="nav navbar-nav navbar-right">
              <li><a href="/j_spring_security_logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
              <li><a href="/impostazioni_utente?nome=${pageContext.request.userPrincipal.name}">Impostazioni Utente</a></li>
            </ul>
         </c:if>
         <c:if  test = "${pageContext.request.userPrincipal.name == null}">
            <ul class="nav navbar-nav navbar-right">
             <li><a class="Bcol" href="/gestisci_registrazione"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
              <li><a href="/login_utente"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
         </c:if>
          </div>
        </div>
      </nav>
    </div> 