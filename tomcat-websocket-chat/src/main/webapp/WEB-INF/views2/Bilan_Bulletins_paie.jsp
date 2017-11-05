<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Accès Employeur</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/w3.css' />" rel="stylesheet"></link>
    <link href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' />" rel="stylesheet"></link>
	<link rel="stylesheet" href="/static/css/demo.css">
</head>

<body id='bodybody' >
 <%@include file="/WEB-INF/views/header.jsp" %>
<script type="text/javascript" src="<c:url value="/static/js/w3.js" />" ></script>
<script type="text/javascript" src="<c:url value="/static/js/jsex.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<div class="generic-container">
	
	<form:form modelAttribute="search" action="doSearchEmpl/${user.login}" method="get" > 
			 <td>Année :</td><td>  </td><td/>
			 <form:select  path="year">
			    <form:options items="${Annees}"></form:options>
			  </form:select><td/><td/>
			  <td><input type="submit" value="Rechercher"/></td>
			</form:form>
			<br>
	
	
		<div  class=" panel panel-default">
		<div class="panel-heading well"><center><span class="lead"><h1><b>Accès Employeur</b></h1> </span></center></div>
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead"><b>Liste des salariés </b></span></div>
		  	<div  id="collapse1" class="tablecontainer">
		  	<br>
		  	   <input type="text" id="myInput" onkeyup="myFunction()" placeholder="  Recherche par nom.." title="Type in a name">
       
				<table  id="myTable" class="table-responsive" >
		    		<thead>
			      		<tr >
			      		
					        <th>Nom</th>
					        <th>Prenom</th>
					        <th>Janvier</th>
					        <th>Février</th>
					        <th>Mars</th>
					        <th>Avril</th>
					        <th>Mai</th>
					        <th>Juin</th>
					        <th>Juillet</th>
					        <th>Août</th>
					        <th>Septembre</th>
					        <th>Octobre</th>
					        <th>Novembre</th>
					        <th>Décembre</th>
					       
					        
					        <th width="100"></th>
					        
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
						    <td>${user.lastName}</td>
							<td>${user.firstName}</td>
							
							
			
							<td><a href="<c:url value='/listdocumentEmpl-${user.login}-2017' />" class="btn btn-successs custom-width"><img src="<c:url value=
            "/static/images/documents(1).png"/>" title="La liste des documents" width="20" height="20"/>  Documents</a></td>
							 
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
	 	<%-- <div class="welll" >
	 		<a href="<c:url value='/newuser' />" class="btn btn-success custom-width"><img src="<c:url value="/static/images/man(1).png"/>" title="Ajouter un employé" width="18" height="18"/>  Ajouter</a>
	 	</div> --%>
   	</div>
   	<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>