<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Accès Comptable</title>
	 <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/w3.css' />" rel="stylesheet"></link>
  <link href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' />" rel="stylesheet"></link> 
 	<%-- <link href="<c:url value='/static/css/new-age.css' />" rel="stylesheet"></link>
 	<link href="<c:url value='/static/css/new-age.min.css' />" rel="stylesheet"></link> --%>
 	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   

    <link rel="stylesheet" href="/static/css/demo.css">
</head>

<body id='bodybody' >
 <%@include file="/WEB-INF/views/header.jsp" %>
 
 
<script type="text/javascript" src="<c:url value="/static/js/w3.js" />" ></script>
<script type="text/javascript" src="<c:url value="/static/js/jsex.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%-- <script type="text/javascript" src="<c:url value="/static/js/new-age.js" />" ></script>
<script type="text/javascript" src="<c:url value="/static/js/new-age.min.js" />" ></script> --%>

	<div class="generic-container">
		<div class=" panel panel-default">
			  <!-- Default panel contents -->
			  <center><div class="panel-heading well"><span class="lead"><h1><b>Accès Comptable</b></h1> </span></div></center>
		  	<div class="panel-heading"><span class="lead">Liste des salariés </span></div>
		  	<div  id="collapse1" class="tablecontainer">
		  	<br>
		  	   <input type="text" id="myInput" onkeyup="myFunction()" placeholder="  Recherche par nom.." title="Type in a name">
       
				<table  id="myTable" class="table-responsive" >
		    		<thead>
			      		<tr>
					        <th>Prenom</th>
					        <th>Nom</th>
					        <th>Login</th>
					        <th>Password</th>
					        <th>Entreprise</th>
					        
					        <th width="100"></th>
					        <th width="100"></th>
					        <th width="100"></th>
					       	<th width="100"></th>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.login}</td>
							<td>${user.password}</td>
							<td>${user.entreprise}</td>
							
							<td><a href="<c:url value='/edit-user-${user.login}' />" class="btn btn-success custom-width"><img src="<c:url value="/static/images/icons8-Edit.png"/>"
            title="Modifier un employé" width="20" height="20"/>   Modifier</a></td>
							<td><a href="<c:url value='/delete-user-${user.login}' />" class="btn btn-danger custom-width"><img src="<c:url value=
            "/static/images/icons8-Trash Can.png"/>" title="Supprimer un utilisateur" width="20" height="20"/>  Supprimer</a></td>
							<td><a href="<c:url value='/add-document-${user.login}' />" class="btn btn-successs custom-width"><img src="<c:url value=
            "/static/images/up.png"/>" title="Charger un fichier" width="20" height="20"/>   Upload</a></td>
							<td><a href="<c:url value='/listdocument-${user.login}-2017' />" class="btn btn-successs custom-width"><img src="<c:url value=
            "/static/images/documents(1).png"/>" title="La liste des documents" width="20" height="20"/>  Documents</a></td>
							 
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
	 	<div class="well" >
	 		<a href="<c:url value='/newuser' />" class="btn btn-success custom-width"><img src="<c:url value="/static/images/man (1).png"/>" title="Ajouter un salarié" width="18" height="18"/>  Ajouter</a>
	 	</div>
	 	
	 	
   	</div>
   	<%@include file="/WEB-INF/views/footer.jsp" %>
   	
   	
   	
</body>
</html>