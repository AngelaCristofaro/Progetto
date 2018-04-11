<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
              <form method="post" action="/j_spring_security_check">
              <c:if test="${param.error == true}"> 
					   <div class="alert alert-warning">
		  					<strong>Attenzione!</strong> Username e/o password non validi!
						</div>
		                </c:if>
		                <c:if test="${param.logout == true}"> 
							 <div class="alert alert-info">
							  <strong>Logout</strong> effettuato con successo!
							</div>
		                </c:if>
                <div class="login-panel panel panel-default">
		         
                    <div class="panel-heading">
                        <h3 class="panel-title">Accedi</h3>
                   	      </div>    
                  			  <div class="panel-body">                   				 
                         		   <fieldset>
                              		  <div class="form-group">
                                		  Username:  <input class="form-control" name="username" type="email" >
                                	</div>
                               	    <div class="form-group">
                                		  Password: <input class="form-control" name="password" type="password" >
                               	    </div>
                               			 <button class="btn btn-lg btn-success" value="sumbit">Login</button>
                            		</fieldset>
                     			
                   		 	</div>
                </div>
              </form>
            </div>
        </div>
</div>
