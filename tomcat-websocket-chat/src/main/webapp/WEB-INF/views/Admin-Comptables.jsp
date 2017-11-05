<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="icon" href="/static/images/expehris.ico"/>
	
	<title>Accès Admin</title>
    		
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   	<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'> 
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/w3.css' />" rel="stylesheet"></link>



</head>

<body style="width:100% ; height:120%" id="bodybody">
 <%@include file="/WEB-INF/views/Admin_header.jsp" %>
 <%@include file="/WEB-INF/views/navbar.jsp" %>
<script type="text/javascript" src="<c:url value="/static/js/w3.js" />" ></script>

  <div class="generic-container">
		<div class="panel panel-primary">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead"><b>Liste des comptables </b></span></div>
		  	<div id="collapse1" class="tablecontainer">
		  	<br>
		  	   <input type="text" id="myInput1" onkeyup="myFunction1()" placeholder="  Recherche par nom.." title="Type in a name">
       
				<table id="myTable1" class="table table-hover table-striped"> 
		    		<thead>
			      		<tr style=" background-color: rgba(0, 185, 255, 0.3)"class="p3" id="myTable tr">
					        <th id="myTable th">Nom</th>
					        <th id="myTable th">Prénom</th>
					        <th id="myTable th">Login</th>
					        <th id="myTable th">password</th>
					        <th id="myTable th">Entreprise</th>
					        <th class="text-center"  id="myTable th" width="100">Action</th>
					        
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
							
							<td class="text-center"><a href="<c:url value='/edit-comptable-${user.login}' />" class="btn btn-xs btn-success "><img src="<c:url value="/static/images/icons8-Edit.png"/>"
            title="Modifier un comptable" width="20" height="20"/> Modifier</a>
							<a href="<c:url value='/delete-comptable-${user.login}' />" class="btn btn-xs btn-danger "><img src="<c:url value=
            "/static/images/icons8-Trash Can.png"/>" title="Supprimer un comptable" width="20" height="20"/>    Supprimer</a></td>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
	 	<div  class=" panel panel-heading">
	 		<a href="<c:url value='/newcomptable' />"  class="btn btn-success custom-width"><img src="<c:url value="/static/images/man (5).png"/>" title="Ajouter un comptable" width="20" height="20"/>  Ajouter</a>
	 	</div>
   	</div>
   	<br>
   	<br>
   	
	 	
   		<%@include file="/WEB-INF/views/footer.jsp" %>
   	
</body>
</html>