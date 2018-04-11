<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<body>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Prenota</h3>
                    </div>
                    <div class="panel-body">        	
                    		<input type="hidden" id="id" value="">
                            <fieldset>
                                <div class="form-group">
                                  Username:  <input class="form-control" id="username"  readonly  name="username" readonly type="email" value="${pageContext.request.userPrincipal.name}" >
                                </div>
                                <div class="form-group">
                                    <label>Risorsa</label>
                                            <select class="form-control" id="tipo">
                                                <option>Laptop</option>
                                                <option>Sala</option>
                                                <option>Moto</option>
                                            </select>
                                </div>
                                <div class="form-group">
                                 <label>Caratteristica</label> :<input class="form-control" type="number" id="caratteristica" required>
                                </div>
                                <div class="form-group">
										<label>Data:</label>
										<input type="text" id="datepicker"/>
									</div>
									<div class="form-group">
										<label>Data Inizio:</label>
										<input id="hourInput" class="timepicker"/>
									</div>
									<div class="form-group">
										<label>Data Fine:</label>
										<input type="number" id="durationInput" class="form-control" value="1" step="1" pattern="\d+"/>
									</div>
                                <input type="submit" class="btn btn-lg btn-success" id="prenota" value="Prenota"/>
                                
                              <a href="/j_spring_security_logout">  <input type="button" class="btn btn-lg btn-success" id="cancella" value="Cancella Account"/> </a>
                           		
                            </fieldset>
                    </div>
                </div> 
                <table id="rentalsTable" class="display">
							<thead>
								<tr>
									<th>Tipo</th>
									<th>Caratteristica</th>
									<th>Data Iniziale Disponibile</th>
									<th>Data Finale Disponibile</th>
									<th>Prenota</th>
								</tr>
							</thead>
							<tbody></tbody>
				</table>
            </div>
        </div>
<script src="/static/js/moment.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
 $(document).ready(function(){
 $("#prenota").click(function(event){
 	var tipo = $("#tipo").val();
 	var caratteristica = $("#caratteristica").val();
 	var startingTime = moment($("#datepicker").val() + "T" + $("#hourInput").val() + ":00.000Z");
 	var duration = $("#durationInput").val();
 	var endingTime = moment(startingTime).add(duration, 'h');
 	$.ajaxSetup({contentType: "application/json;charset=UTF-8"});
 	$.get("/trovarisorse/?tipo=" + tipo + "&value=" + caratteristica, function(data){
 		var trovarisorse = JSON.stringify(data);
		var requestingRentals = {'res': trovarisorse, 'startingDate': startingTime, 'endingDate': endingTime};
 		$.post("/getpossibiliprenotazioni", JSON.stringify(requestingRentals), function(data){
 			var fittingRentals = JSON.parse(data);
 			console.log(fittingRentals)
 			if(document.getElementById("resultsDiv").style.display == 'none'){
 				document.getElementById("resultsDiv").style.display = 'block';
 			}
				generatedTable = $('#rentalsTable').DataTable( {
				    data: fittingRentals,
				 	destroy: true,
				    columns: [
				        { data: 'resourceId' },
				        { data: 'value' },
				        { data: 'startingDate' },
				        { data: 'endingDate' }
				    ]
				});
	    	});
 	});    	
 });
 	 $('.timepicker').timepicker({
	     timeFormat: 'HH:mm',
	     interval: 60,
	     minTime: '0',
	     maxTime: '12:00pm',
	     defaultTime: '9',
	     startTime: '0:00am',
	     dynamic: true,
	     dropdown: false,
	     scrollbar: true
	 });
		
	 $( function() {
	     $( "#datepicker" ).datepicker({
	     	dateFormat: "yy-mm-dd"
	     	});
	   } );
	)};
 </script>
