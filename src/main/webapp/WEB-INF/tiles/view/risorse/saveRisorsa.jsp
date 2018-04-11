    <div class="container">
        <div class="row" style="margin-top:-70px">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Inserisci una nuova risorsa</h3>
                    </div>
                    <div class="panel-body">
                         <input type="hidden" name="id" value = "-1" id="id">
                            <fieldset>
                                <div class="form-group">
                                    <label>Tipo</label>
                                            <select class="form-control" id="tipo">
                                                <option>Laptop</option>
                                                <option>Sala</option>
                                                <option>Moto</option>
                                            </select>
                                </div>
                                <div class="form-group">
                                 <label>Caratteristica</label> :<input class="form-control" type="number" id="caratteristica" required>
                                </div>
                                
                                 <input type="submit" class="btn btn-lg btn-success" id="b1" value="Invio" onClick="window.location.reload();">
                                 <input type="reset" class="btn btn-lg btn-success" id="b2" value="Cancella" onClick="window.location.reload();">
                            </fieldset>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div style="overflow: auto;">
    <table id="tabella" class="display">
		<thead>
			<tr>
				<th>Id</th>
				<th>Tipo</th>
				<th>Caratteristica</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
<!-- 		<tbody> -->
<!-- 			<tr> -->
<!-- 				<td>Id</td> -->
<!-- 				<td>Tipo</td> -->
<!-- 				<td>Caratteristica</td>	 -->
<!-- 				<td>Bottone</td>	 -->
<!-- 			</tr> -->
<!-- 		</tbody> -->
	</table>
    
    </div>
    
        <script>
    $(document).ready(function(){	
    	$('#b1').click(function(){
    		var id = $("#id").val();
    		var tipo= $("#tipo").val();
    		var caratteristica = $("#caratteristica").val();
    		//$.ajaxSetup({contentType: "application/json;charset=UTF-8"});
    		var Risorsa = {"id" : id, "tipo1": tipo, "caratteristica": caratteristica};
    		var risString = JSON.stringify(Risorsa);
    		if(caratteristica > 0){
    	    $.post({
    	    	url:"http://localhost:8080/save-risorsa",
    	    	contentType: "application/json",
    	        data:risString
    	       /*function(data){
    	        	$("#UserResult").text("ID: " + data.id + " - Nome: " + data.username +
    	            		" - Password: " + data.password);
    	        					  }*/
    	    });
    		}
    		else{
    			alert("Inserisci caratteristica corretta!")
    		}
    	    function refreshPage(){
    	        window.location.reload();
    	    } 
    	    });

	var tabella = $('#tabella').DataTable( {
		//var risorsa = $(risorsa);
	    ajax: {
	    	url: 'http://localhost:8080/risorse',
	    	dataSrc: ''
	    },
	    columns : [
	    	{data: "id"},
	    	{data : "tipo1"},
	    	{data: "caratteristica"},
	    	{
	    		targets : -1,
	    		data: null,
	    		defaultContent:"<button class='glyphicon glyphicon-trash' id='cancella' onClick='window.location.reload();' ></button>"
	    		
	    	},
	    	{
	    		targets : -1,
	    		data: null,
	    		defaultContent:"<button class='glyphicon glyphicon-edit' id='modifica' onClick='window.location.reload();'></button>"
	    		
	    	}
	    ]
	} );
	
	 $('#tabella tbody').on('click','#cancella',function(){
		 var riga= tabella.row($(this).parents('tr')).data();
		 var cancella = riga.id;
		 $.get("http://localhost:8080/delete-risorsa?id="+cancella); 
		 
		 function refreshPage(){
	 	        window.location.reload();
	 	    } 
	 });
	 
	 
	 $('#tabella tbody').on('click','#modifica',function(){
		 var riga= tabella.row($(this).parents('tr')).data();
		 var updateID = riga.id;
		 var updateTIPO = riga.tipo1;
		 var updateCAR = riga.caratteristica;
		 var caratteristica = prompt("Inserisci nuova caratteristica", updateCAR);
			 if (caratteristica === null) {
			   caratteristica = updateCAR;
			 }
		 var Risorsa = {"id" : updateID, "tipo1": updateTIPO, "caratteristica": caratteristica};
 		 var risString = JSON.stringify(Risorsa);
		 $.post({
			 url: "http://localhost:8080/save-risorsa",
			 contentType: "application/json",
		     data:risString
		 });
		 
		 function refreshPage(){
 	        window.location.reload();
 	    } 
	 });
	
});

    </script>
