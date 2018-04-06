
</head>
<body>
 <div>
 	<h1 style="text-align:center;">Tutti gli utenti</h1>
 	</br>
 </div>
	<div style="overflow: auto;">
    	<table id="tabellaUtenti" class="display">
			<thead>
				<tr>
					<th>Id</th>
					<th>Username</th>
					<th></th>
				</tr>
			</thead>
		</table>
 	</div>
 	<script>
	 $(document).ready(function(){
	var table = $('#tabellaUtenti').DataTable( {
	    ajax: {
	    	url:'http://localhost:8080/utenti',
	    	dataSrc:''
	    },
	    columns : [
	    	{data:"id"},
	    	{data:"username"},
	    	{	targets:-1,
	    		data:null,
	    		defaultContent:"<button class='glyphicon glyphicon-trash' id='cancella' onClick='window.location.reload();' ></button>"
	    	}    
	    		  ]
	 });
	
	$('#tabellaUtenti tbody').on('click','#cancella',function(){
		 var riga= table.row($(this).parents('tr')).data();
		 var cancella = riga.id;
		 $.get("http://localhost:8080/delete-utente?id="+cancella); 
		 
		 function refreshPage(){
	 	        window.location.reload();
	 	    } 
	 });
	 });
	</script>