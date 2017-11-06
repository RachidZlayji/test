<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="icon" href="/static/images/expehrislogo.ico"/>
	
	<title>Consulter Documents</title>
	<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'> 
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/w3.css' />" rel="stylesheet"></link>
	</head>

<body id='bodybody'>
 <%@include file="/WEB-INF/views/Employeur_header.jsp" %>

<script type="text/javascript" src="<c:url value="/static/js/w3.js" />" ></script>
<script type="text/javascript" src="<c:url value="/static/js/jsex.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
  <%@include file="/WEB-INF/views/Employeur_navbar.jsp" %>
 
	<div class="generic-container">
			 <div style="width:0%%; float:right"><%-- <a  href="<c:url value='/listEmployees' />" class="btn btn-danger custom-width" >Retour</a> --%>
			<br>
			<br>  
	</div>
			 <form:form style="color:white"  modelAttribute="search" action="doSearchBulletin" method="get" > 
			 <th style="color:red" >Année :</th>
			 <form:select class="selectpicker show-tick" style="color:black"  path="year">
			    <form:options items="${Annees}"></form:options>
			  </form:select ><td/><td/>
			  <td class="btn btn-sm btn-default" ><i class=" fa fa-search" aria-hidden="true"></i>
			  <input  style="color:black" class="btn btn-sm btn-default " type="submit" value="Rechercher"/></td><td> </form:form>  
			
			<br> <br>
			<div class="panel panel-primary">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><h4><b>Les bulletins de paie</b></h4></div>
		  	<div id="collapse1"  class="panel panel-primary">
		  	<br>
		  	   <input class="input-group" type="text" id="myInput1" onkeyup="myFunction1()" placeholder="  Recherche par nom.." title="Type in a name">
				<table id="myTable1"  class="table table-hover table-striped">
		    		<thead>
			      		<tr style=" background-color: rgba(94, 227, 229,0.5)">
					        <th id="myTable th">Nom</th>
					        <th id="myTable th">Prénom</th>
					        <th id="myTable th">JAN</th>
					        <th id="myTable th">FÉV</th>
					        <th id="myTable th">MAR</th>
					        <th id="myTable th">AVR</th>
					        <th id="myTable th">MAI</th>
					        <th id="myTable th">JUN</th>
					        <th id="myTable th">JUL</th>
					        <th id="myTable th">AOÛ</th>
					        <th id="myTable th">SEP</th>
					        <th id="myTable th">OCT</th>
					        <th id="myTable th">NOV</th>
					        <th id="myTable th">DÉC</th>
<!-- 					        <th width="100"></th>
 -->						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${bulletins}" var="bulletin" varStatus="counter">
						<tr>
							<td style="font-family: NORMAL">${bulletin.nom}</td>
							<td style="font-family: NORMAL">${bulletin.prenom}</td>
							<td style="text-align: center;">
								<c:if test="${bulletin.mois1 != ''}">
										<a href="<c:url value='/download-document-${bulletin.login}-${bulletin.mois1}' />" class="btn btn-sm btn-success"><img src="<c:url value="/static/images/download (8).png"/>" title="Télécharger le fichier" width="14" height="12"/>  </a>	
								</c:if>
								<c:if test="${bulletin.mois1 == ''}">
										<img src="<c:url value="/static/images/file.png"/>" title="le fichier n'existe pas !" width="20" height="18"/>  
								</c:if>
							</td>
							<td style="text-align: center;">
								<c:if test="${bulletin.mois2 != ''}">
										<a href="<c:url value='/download-document-${bulletin.login}-${bulletin.mois2}' />" class="btn btn-sm btn-success"><img src="<c:url value="/static/images/download (8).png"/>" title="Télécharger le fichier" width="14" height="12"/>  </a>	
								</c:if>
								<c:if test="${bulletin.mois2 == ''}">
										<img src="<c:url value="/static/images/file.png"/>" title="le fichier n'existe pas !" width="20" height="18"/>  
								</c:if>
							</td>
							<td style="text-align: center;">
								<c:if test="${bulletin.mois3 != ''}">
										<a href="<c:url value='/download-document-${bulletin.login}-${bulletin.mois3}' />" class="btn btn-sm btn-success"><img src="<c:url value="/static/images/download (8).png"/>" title="Télécharger le fichier" width="14" height="12"/>  </a>	
								</c:if>
								<c:if test="${bulletin.mois3 == ''}">
										<img src="<c:url value="/static/images/file.png"/>" title="le fichier n'existe pas !" width="20" height="18"/>  
								</c:if>
							</td>
							<td style="text-align: center;">
								<c:if test="${bulletin.mois4 != ''}">
										<a href="<c:url value='/download-document-${bulletin.login}-${bulletin.mois4}' />" class="btn btn-sm btn-success"><img src="<c:url value="/static/images/download (8).png"/>" title="Télécharger le fichier" width="14" height="12"/>  </a>	
								</c:if>
								<c:if test="${bulletin.mois4 == ''}">
										<img src="<c:url value="/static/images/file.png"/>" title="le fichier n'existe pas !" width="20" height="18"/>  
								</c:if>
							</td>
							<td style="text-align: center;">
								<c:if test="${bulletin.mois5 != ''}">
										<a href="<c:url value='/download-document-${bulletin.login}-${bulletin.mois5}' />" class="btn btn-sm btn-success"><img src="<c:url value="/static/images/download (8).png"/>" title="Télécharger le fichier" width="14" height="12"/>  </a>	
								</c:if>
								<c:if test="${bulletin.mois5 == ''}">
										<img src="<c:url value="/static/images/file.png"/>" title="le fichier n'existe pas !" width="20" height="18"/>  
								</c:if>
							</td>
							<td style="text-align: center;">
								<c:if test="${bulletin.mois6 != ''}">
										<a href="<c:url value='/download-document-${bulletin.login}-${bulletin.mois6}' />" class="btn btn-sm btn-success"><img src="<c:url value="/static/images/download (8).png"/>" title="Télécharger le fichier" width="14" height="12"/>  </a>	
								</c:if>
								<c:if test="${bulletin.mois6 == ''}">
										<img src="<c:url value="/static/images/file.png"/>" title="le fichier n'existe pas !" width="20" height="18"/>  
								</c:if>
							</td>
							<td style="text-align: center;">
								<c:if test="${bulletin.mois7 != ''}">
										<a href="<c:url value='/download-document-${bulletin.login}-${bulletin.mois7}' />" class="btn btn-sm btn-success"><img src="<c:url value="/static/images/download (8).png"/>" title="Télécharger le fichier" width="14" height="12"/>  </a>	
								</c:if>
								<c:if test="${bulletin.mois7 == ''}">
										<img src="<c:url value="/static/images/file.png"/>" title="le fichier n'existe pas !" width="20" height="18"/>  
								</c:if>
							</td>
							<td style="text-align: center;">
								<c:if test="${bulletin.mois8 != ''}">
										<a href="<c:url value='/download-document-${bulletin.login}-${bulletin.mois8}' />" class="btn btn-sm btn-success"><img src="<c:url value="/static/images/download (8).png"/>" title="Télécharger le fichier" width="14" height="12"/>  </a>	
								</c:if>
								<c:if test="${bulletin.mois8 == ''}">
										<img src="<c:url value="/static/images/file.png"/>" title="le fichier n'existe pas !" width="20" height="18"/>  
								</c:if>
							</td>
							<td style="text-align: center;">
								<c:if test="${bulletin.mois9 != ''}">
										<a href="<c:url value='/download-document-${bulletin.login}-${bulletin.mois9}' />" class="btn btn-sm btn-success"><img src="<c:url value="/static/images/download (8).png"/>" title="Télécharger le fichier" width="14" height="12"/></a>	
								</c:if>
								<c:if test="${bulletin.mois9 == ''}">
										<img src="<c:url value="/static/images/file.png"/>" title="le fichier n'existe pas !" width="20" height="18"/>  
								</c:if>
							</td>
							<td style="text-align: center;">
								<c:if test="${bulletin.mois10 != ''}">
										<a href="<c:url value='/download-document-${bulletin.login}-${bulletin.mois10}' />" class="btn btn-sm btn-success"><img src="<c:url value="/static/images/download (8).png"/>" title="Télécharger le fichier" width="14" height="12"/></a>	
								</c:if>
								<c:if test="${bulletin.mois10 == ''}">
										<img src="<c:url value="/static/images/file.png"/>" title="le fichier n'existe pas !" width="20" height="18"/>  
								</c:if>
							</td>
							<td style="text-align: center;">
								<c:if test="${bulletin.mois11 != ''}">
										<a href="<c:url value='/download-document-${bulletin.login}-${bulletin.mois11}' />" class="btn btn-sm btn-success"><img src="<c:url value="/static/images/download (8).png"/>" title="Télécharger le fichier" width="14" height="12"/>  </a>	
								</c:if>
								<c:if test="${bulletin.mois11 == ''}">
										<img src="<c:url value="/static/images/file.png"/>" title="le fichier n'existe pas !" width="20" height="18"/>  
								</c:if>
							</td>
							<td style="text-align: center;">
								<c:if test="${bulletin.mois12 != ''}">
										<a href="<c:url value='/download-document-${bulletin.login}-${bulletin.mois12}' />" class="btn btn-sm btn-success"><img src="<c:url value="/static/images/download (8).png"/>" title="Télécharger le fichier" width="14" height="12" > </a>	
								</c:if>
								<c:if test="${bulletin.mois12 == ''}">
										<img src="<c:url value="/static/images/file.png"/>" title="le fichier n'existe pas !" width="20" height="18"/>  
								</c:if>
							</td>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
	</div>
	
	 	<%-- <div class="welll" >
	 		<a href="<c:url value='/listEmployees' />" class="btn btn-success custom-width"> Liste des employée</a>
	 	</div> --%>
	 	
   	<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>