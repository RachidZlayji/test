<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="icon" href="/static/images/expehris.ico"/>
	
	<title>Consulter Documents</title>
	<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'> 
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/w3.css' />" rel="stylesheet"></link>
	</head>

<body id='bodybody'>
 <%@include file="/WEB-INF/views/employe_header.jsp" %>

<script type="text/javascript" src="<c:url value="/static/js/w3.js" />" ></script>
<script type="text/javascript" src="<c:url value="/static/js/jsex.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
	 <%@include file="/WEB-INF/views/navbar-employe-docs.jsp" %>
	
		
	<div class="generic-container">
		<div class="panel panel-primary">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead"><b>Liste des Documents </b></span></div>
		  	<div id="collapse1"  class="tablecontainer">
		  	<br>
		  	   <input type="text" id="myInput1" onkeyup="myFunction1()" placeholder="  Recherche par nom.." title="Type in a name">
				<table id="myTable1"  class="table table-hover table-striped">
		    		<thead>
			      		<tr style=" background-color: rgba(0, 185, 255, 0.3)">
					       <!--  <th>No.</th> -->
					        <th>Nom Fichier</th>
					      <!--    <th>Type</th>-->
					        <th>Description</th>
					        <th>Type Fichier</th>
					        <th>Date création</th>
					        <th>Année</th>
					        <th>Mois</th>
					        <th class="text-center"  width="100">Action</th>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${otherdocuments}" var="doc" varStatus="counter">
						<tr>
<%-- 							<td>${counter.index + 1}</td>
 --%>							<td>${doc.name}</td>
							<!--  <td>${doc.type}</td>-->
							<td>${doc.description}</td>
							<td>${doc.typedocument}</td>
							<td>${doc.dateCreation}</td>
							<td>${doc.annee}</td>
							<td>${doc.mois}</td>
							<td class="text-center" ><a href="<c:url value='/download-document-${user.login}-${doc.id}' />" class="btn btn-xs btn-success "><img src="<c:url value="/static/images/download (3).png"/>" title="Télécharger le fichier" width="18" height="18"/>   Télécharger</a></td>
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