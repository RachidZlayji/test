<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Accès super-user</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/w3.css' />" rel="stylesheet"></link>
	 <link href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' />" rel="stylesheet"></link>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   

    <link rel="stylesheet" href="/static/css/demo.css">


</head>

<body id='bodybody'>
 <%@include file="/WEB-INF/views/header.jsp" %>

<script type="text/javascript" src="<c:url value="/static/js/w3.js" />" ></script>
	<div class="generic-container"> 	<center><div class="panel-heading well"><span class="lead"><h1><b>Accès Admin</b></h1> </span></div></center>
	</div>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead"><b>Liste des comptables </b></span></div>
		  	<div id="collapse1" class="tablecontainer">
		  	<br>
		  	   <input type="text" id="myInput" onkeyup="myFunction()" placeholder="  Recherche par nom.." title="Type in a name">
       
				<table id="myTable" class="table-responsive"> 
		    		<thead>
			      		<tr id="myTable tr">
					        <th id="myTable th">Nom</th>
					        <th id="myTable th">Prenom</th>
					        <th id="myTable th">Login</th>
					        <th id="myTable th">password</th>
					        <th id="myTable th">Entreprise</th>
					        <th id="myTable th" width="100"></th>
					        <th id="myTable th" width="100"></th>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${comptables}" var="user">
						<tr>
							<td>${user.nom}</td>
							<td>${user.prenom}</td>
							<td>${user.login}</td>
							<td>${user.passwd}</td>
							<td>${user.entreprise}</td>
							<%-- class="btn btn-success custom-width"><img src="<c:url value="/static/images/man (1).png"/>" title="Ajouter un salarié" width="18" height="18" --%>
							
							<td><a href="<c:url value='/edit-comptable-${user.login}' />" class="btn btn-success custom-width"><img src="<c:url value="/static/images/icons8-Edit.png"/>"
            title="Modifier un comptable" width="20" height="20"/> Modifier</a></td>
							<td><a href="<c:url value='/delete-comptable-${user.login}' />" class="btn btn-danger custom-width"><img src="<c:url value=
            "/static/images/icons8-Trash Can.png"/>" title="Supprimer un utilisateur" width="20" height="20"/>    Supprimer</a></td>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/newcomptable' />"  class="btn btn-success custom-width"><img src="<c:url value="/static/images/man(2).png"/>" title="Ajouter un comptable" width="18" height="18"/>  Ajouter</a>
	 	</div>
   	</div>
   	<br>
   	<br>
   	
   	<br>
   	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead"><b>Liste des employeurs</b> </span></div>
		  	<div id="collapse1" class="tablecontainer">
		  	<br>
		  	   <input type="text" id="myInput1" onkeyup="myFunction1()" placeholder="  Recherche par nom.." title="Type in a name">
       
				<table id="myTable1" class="table table-hover">
		    		<thead>
			      		<tr id="myTable1 tr">
					        <th id="myTable th">Nom</th>
					        <th id="myTable th">Prénom</th>
					        <th id="myTable th">Login</th>
					        <th id="myTable th">Password</th>
					        <th id="myTable th">Entreprise</th>
					        <th id="myTable th" width="100"></th>
					        <th id="myTable th" width="100"></th>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${employeurs}" var="user">
						<tr>
							<td>${user.nom}</td>
							<td>${user.prenom}</td>
							<td>${user.login}</td>
							<td>${user.passwd}</td>
							<td>${user.entreprise}</td>
							<td><a href="<c:url value='/edit-employeur-${user.login}' />" class="btn btn-success custom-width"><img src="<c:url value="/static/images/icons8-Edit.png"/>"
            title="Modifier un employeur" width="20" height="20"/> Modifier</a></td>
							<td><a href="<c:url value='/delete-employeur-${user.login}' />" class="btn btn-danger custom-width"><img src="<c:url value=
            "/static/images/icons8-Trash Can.png"/>" title="Supprimer un utilisateur" width="20" height="20"/>   Supprimer</a></td>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/newemployeur' />" class="btn btn-success custom-width"><img src="<c:url value="/static/images/man (1).png"/>" title="Ajouter un employeur" width="18" height="18"/>  Ajouter</a>
	 	</div>
   	</div>
   		<%@include file="/WEB-INF/views/footer.jsp" %>
   	
</body>
</html>