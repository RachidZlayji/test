<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="icon" href="/static/images/expehris.ico"/>
	
	<title>Accès Comptable</title>
	 <link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'> 
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/w3.css' />" rel="stylesheet"></link>
 	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   

    <link rel="stylesheet" href="/static/css/demo.css">
</head>

<body id='bodybody' >
 <%@include file="/WEB-INF/views/comptable_header.jsp" %>
 
 
<script type="text/javascript" src="<c:url value="/static/js/w3.js" />" ></script>
<script type="text/javascript" src="<c:url value="/static/js/jsex.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%-- <script type="text/javascript" src="<c:url value="/static/js/new-age.js" />" ></script>
<script type="text/javascript" src="<c:url value="/static/js/new-age.min.js" />" ></script> --%>

	<div class="generic-container">
		<div class=" panel panel-primary">
			  <!-- Default panel contents -->
			 <%--  <center><div class="panel-heading well"></div></center> --%>
		  	<div class="panel-heading"><span class="lead"><b>Liste des salariés  </b></span></div>
		  	<div  id="collapse1" class="tablecontainer">
		  	<br>
		  	   <input type="text" id="myInput1" onkeyup="myFunction1()" placeholder="  Recherche par nom.." title="Type in a name">
       
				<table  id="myTable1" class="table table-hover table-striped" >
		    		<thead>
			      		<tr style=" background-color: rgba(0, 185, 255, 0.3)">
					        <th id="myTable th">Nom</th>
					        <th id="myTable th">Prénom</th>
					        <th id="myTable th">Login</th>
					        <th id="myTable th">Password</th>
					        <th id="myTable th">Entreprise</th>
					        <th colspan="4" class="text-center" id="myTable th" width="100">Actions</th>
					        
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							
							<td>${user.lastName}</td>
							<td>${user.firstName}</td>
							<td>${user.login}</td>
							<td>${user.password}</td>
							<td>${user.entreprise}</td>
							
							<td><a href="<c:url value='/edit-user-${user.login}' />" class="btn btn-success custom-width"><img src="<c:url value="/static/images/icons8-Edit.png"/>"
            title="Modifier un employé" width="20" height="20"/>   Modifier</a></td>
							<td><a href="<c:url value='/delete-user-${user.login}' />" class="btn btn-danger custom-width"><img src="<c:url value=
            "/static/images/icons8-Trash Can.png"/>" title="Supprimer un utilisateur" width="20" height="20"/>  Supprimer</a></td>
							<td><a href="<c:url value='/add-document-${user.login}' />" class="btn btn-info custom-width"><img src="<c:url value=
            "/static/images/up.png"/>" title="Charger un fichier" width="20" height="20"/>   Upload</a></td>
							<td><a href="<c:url value='/listdocumentbulletinsComptable-${user.login}-2017' />" class="btn btn-warning custom-width"><img src="<c:url value=
            "/static/images/documents(1).png"/>" title="La liste des documents" width="20" height="20"/>  Documents</a></td>
							 
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
	 	<div class=" panel panel-heading" >
	 		<a href="<c:url value='/newuser' />" class="btn btn-success custom-width"><img src="<c:url value="/static/images/user.png"/>" title="Ajouter un salarié" width="18" height="18"/>  Ajouter</a>
	 	</div>
	 	
	 	
   	</div>
   	<%@include file="/WEB-INF/views/footer.jsp" %>
   	
   	
   	
</body>
</html>