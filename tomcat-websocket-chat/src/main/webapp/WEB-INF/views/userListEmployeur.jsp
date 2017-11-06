<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="icon" href="/static/images/expehrislogo.ico"/>

	<title>Accès Employeur</title>
		   <link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'> 
	
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	
	<link href="<c:url value='/static/css/w3.css' />" rel="stylesheet"></link>
	<link rel="stylesheet" href="/static/css/demo.css">
</head>

<body id='bodybody' >
 <%@include file="/WEB-INF/views/Employeur_header.jsp" %>
 <%@include file="/WEB-INF/views/Employeur_navbar.jsp" %>
 
<script type="text/javascript" src="<c:url value="/static/js/w3.js" />" ></script>
<script type="text/javascript" src="<c:url value="/static/js/jsex.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<div class="generic-container">
		<div  class=" panel panel-primary">
		
					 		<%-- <a style="width:30%; float:right ; " href="<c:url value='/listbulletins-{"2017"}' />" class="btn btn-success custom-width"> Liste des bulletins de paie </a> --%>
		
			  <!-- Default panel contents -->
			  	<!-- <div class="welll" style="width:0%%; float:right" > -->
	 	
		  	<div class="panel-heading"><span class="lead"><b>Liste des salariés </b></span> 
		  </div>
		  	
		  	<div  id="collapse1" class="tablecontainer">
		  	<br>
		  	   <input type="text" id="myInput1" onkeyup="myFunction1()" placeholder="  Recherche par nom.." title="Type in a name">
       
				<table  id="myTable1" class="table table-hover table-striped" >
		    		<thead>
			      		<tr style=" background-color: rgba(0, 185, 255, 0.3)" >
					        
					        <th>Nom</th>
					        <th>Prenom</th>
					        <th>Login</th>
					        <th>Password</th>
					         <th>Entreprise</th>
					        
					        <th width="100">Documents</th>
					        
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.lastName}</td>
							<td>${user.firstName}</td>
							
							<td>${user.login}</td>
							<td>${user.password}</td>
							<td >${user.entreprise}</td>
							
			<!-- 				<td><a href="<c:url value='/edit-user-${user.login}' />" class="btn btn-success custom-width"><img src="<c:url value="/static/images/icons8-Edit.png"/>"
            title="Modifier un utilisateur" width="20" height="20"/></a></td>
							<td><a href="<c:url value='/delete-user-${user.login}' />" class="btn btn-danger custom-width"><img src="<c:url value=
            "/static/images/icons8-Trash Can.png"/>" title="Supprimer un utilisateur" width="20" height="20"/></a></td>
							<td><a href="<c:url value='/add-document-${user.login}' />" class="btn btn-successs custom-width"><img src="<c:url value=
            "/static/images/up.png"/>" title="Charger un fichier" width="20" height="20"/></a></td>
			-->
							<td><a  href="<c:url value='/listdocumentEmpl-${user.login}-2017' />" class="btn btn-danger custom-width"><img src="<c:url value=
            "/static/images/documents(1).png"/>" title="La liste des documents" width="20" height="20"/>  Documents</a></td>
							 
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
	 	
   	</div>
   	<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>