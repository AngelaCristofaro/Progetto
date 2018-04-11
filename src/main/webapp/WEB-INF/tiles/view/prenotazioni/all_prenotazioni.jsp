<body>
<div>
 	<h1 style="text-align:center;">Prenotazioni</h1>
 	<br>
 </div>
    <div style="overflow: auto;">
    <table id="tabella" class="display">
		<thead>
			<tr>
				<th>Id</th>
				<th>Risorsa</th>
				<th>Utente</th>
				<th>Data Inizio</th>
				<th>Data Fine</th>
			</tr>
		</thead>
	</table>
    
    </div>
	
<script>
    $(document).ready(function(){
    	var prenotazioni = $(prenotazioni);
    	var tabella = $('#tabella').DataTable( {
    	    data: JSON.parse(prenotazioni),
    	    columns : [
    	    	{data: "id"},
    	    	{data : "utente"},
    	    	{data: "risorse"},
    	    	{data: "dataInizio"},
    	    	{data: "dataFine"}
    	    	
    	    ]
    	} );
    });
    	
    </script>