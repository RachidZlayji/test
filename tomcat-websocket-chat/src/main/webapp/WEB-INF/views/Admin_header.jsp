<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
<html lang="en">
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        	<link rel="icon" href="/static/images/expehris.ico"/>
        
	<title></title>
    		<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'> 
    		
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   

    <link rel="stylesheet" href="/static/css/demo.css">
    </head>
    <body>

        <nav class="navbar navbar-inverse">
        
           <div class="container-fluid">
          
		    <div class="navbar-header">
		    	
		      <a class="navbar-brand">  <a class="navbar-brand">	<img src="<c:url value="/static/images/logo-small-300x103 (2).png"/>" title="Expehris icon" width="135" height="30" />
		    	</a ><a class="navbar-brand" >  Payment Management      </a>  </a>
		    </div>
		    <div class="navbar-header">
		    <a>    <br>    </a>
		    </div>
		     <div class="navbar-header">
		    	
		      <a class="navbar-brand">  	   </a>
		    </div>
		    	
		     
		  <%--    <div style="float:left" class="navbar-header"> 
		      <a class="navbar-brand" >   
		      <center>  <img src="<c:url value="/static/images/admin-online.png"/>" title="Admin" width="45" height="32" /></center></a> 
		     <a class="navbar-brand" >    Administrateur  </a>
		    </div> --%>
		   
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="<c:url value='/logout' />" ><span class="glyphicon glyphicon-log-out"></span> Déconnexion</a></li>
		    </ul>
		  </div>
		</nav>
</body>
</html>