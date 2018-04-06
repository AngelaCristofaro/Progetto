
<body>
<div>
 	<h1 style="text-align:center;">Risorse</h1>
 	</br>
 </div>
    <div style="overflow: auto;">
    <table id="tabella" class="display">
		<thead>
			<tr>
				<th>Id</th>
				<th>Tipo</th>
				<th>Caratteristica</th>
			</tr>
		</thead>
	</table>
    
    </div>
	
<script>
    $(document).ready(function(){
    	var tabella = $('#tabella').DataTable( {
    	    ajax: {
    	    	url: 'http://localhost:8080/risorse',
    	    	dataSrc: ''
    	    },
    	    columns : [
    	    	{data: "id"},
    	    	{data : "tipo1"},
    	    	{data: "caratteristica"}
    	    ]
    	} );
    });
    	
    </script>