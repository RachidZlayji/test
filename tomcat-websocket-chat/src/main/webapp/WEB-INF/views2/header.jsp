<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
<html lang="en">
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    		<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
    	<title>Welcome</title>
    </head>
    <body>

        <nav class="navbar navbar-inverse">
        
           <div class="container-fluid">
          
		    <div class="navbar-header">
		    	
		      <a class="navbar-brand">  <a class="navbar-brand">	<img src="<c:url value="/static/images/logo-small-300x103 (2).png"/>" title="Expehris icon" width="135" height="30" />
		    	</a ><a class="navbar-brand" >  Payment Management </a> </a>
		    </div>
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="<c:url value='/logout' />" ><span class="glyphicon glyphicon-log-out"></span> Déconnexion</a></li>
		    </ul>
		  </div>
		</nav>
</body>
</html>