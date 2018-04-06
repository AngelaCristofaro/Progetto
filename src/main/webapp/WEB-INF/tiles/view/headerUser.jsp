<!DOCTYPE html>
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
    <script src="js/vendor/jquery.js"></script>
	<script src="js/foundation/foundation.js"></script>
	<script src="js/foundation/foundation.dropdown.js"></script>
	<script>
		$(document).foundation({
		  dropdown: {
		    // specify the class used for active dropdowns
		    active_class: 'open'
		  }
		});
</script>
</head>
<body> <div>
      <nav class="navbar navbar-default colore">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a  href="home.html"><img src="noleggio.png" class="img-responsive" id="logo"></a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="#">Home</a></li>
              <li><a href="/gestiscirisorseUtente">Risorse</a></li>
               <li class="dropdown">			
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Prenotazioni <span class="caret"></span></a>
                <ul class="dropdown-menu f-dropdown" id="drop1"  data-dropdown-content aria-hidden="true" tabindex="-1">
                 		 <li><a href="#">Tutte</a></li>
                  		<li><a href="#">Nuova</a></li>
                  	</ul>
<!--                   <li><a href="#">Something else here</a></li> -->
<!--                   <li role="separator" class="divider"></li> -->
<!--                   <li class="dropdown-header">Nav header</li> -->
<!--                   <li><a href="#">Separated link</a></li> -->
<!--                   <li><a href="#">One more separated link</a></li> -->
                
              </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
             <li><a class="Bcol" href="/gestisciRegistrazione"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> 
              <li class="dropdown"><a href="/impostazioniUtente" role="button" id="btn-id" class="dropdown-toggle"><span class="glyphicon glyphicon-log-in"></span> Login</a>
	 			 <ul class="dropdown-menu">
	     			 <li><a href="#">Accedi</a></li>
         			 <li><a href="/impostazioniUtente">Impostazioni</a></li>
       			 </ul>
       		</li>
            </ul>
          </div>
        </div>
      </nav>
    </div> 
    
