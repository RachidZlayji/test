<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="icon" href="/static/images/expehris.ico"/>
	
	<title>Upload/Download/Delete Documents</title>
	<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'> 
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/w3.css' />" rel="stylesheet"></link>
	</head>

<body id='bodybody'>
 <%@include file="/WEB-INF/views/comptable_header.jsp" %>

<script type="text/javascript" src="<c:url value="/static/js/w3.js" />" ></script>
<script type="text/javascript" src="<c:url value="/static/js/jsex.js" />" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<input type="hidden" id="foo" name="foo" />
	<div class="generic-container">
		
		<div class="panel panel-success">
			
			<div class="panel-heading "><span class="lead"><b>Charger un nouveau document</b></span> </div>
			<div class="uploadcontainer">
				<form:form method="POST" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">
			
					<div class="row">
						<div class="form-group col-md-8">
							<label class="col-md-3 control-lable" for="file">Charger un document</label>
							<div class="col-md-8">
								<form:input type="file" path="file" id="file" class="form-control input-sm" required="true"/>
								<div class="has-error">
									<form:errors path="file" class="help-inline"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-8">
							<label class="col-md-3 control-lable" for="file">Description</label>
							<div class="col-md-8">
								<form:input type="text" path="description" id="description" class="form-control input-sm"/>
							</div>
							
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-8">
							<label class="col-md-3 control-lable" for="file">Type</label>
							<div class="col-md-7">
								<form:select path="type" onchange="myFunc(value)" items="${Types}" />
							</div>
							
						</div>
					</div>
			
			<div class="row" id="AnneeDiv">
						<div class="form-group col-md-8">
							<label class="col-md-3 control-lable" for="annee">Année</label>
							<div class="col-md-7">
										<form:select path="annee"  items="${Annees}" />
										<div class="has-error">
											<form:errors path="annee" class="help-inline"/>
										</div> 
							</div>
						</div>
					</div>
					
					<div class="row" id="moisDiv">
						<div class="form-group col-md-8">
							<label class="col-md-3 control-lable" for="mois">Mois</label>
							<div class="col-md-7">										
										<form:select path="mois"  items="${Mois}" />
										<div class="has-error">
											<form:errors path="mois" class="help-inline"/>
										</div> 
							</div>
						</div>
					</div>
			
					<div class="row">
						<div class="form-actions floatRight">
						
							   <!-- Upload</a> -->
							<%-- <a><img src="<c:url value=
            "/static/images/up.png"/>" title="Charger un fichier" width="20" height="20"/> </a>--%>
            <a><input type="submit" value="Upload" class="btn btn-primary  "></a>
			<a href="<c:url value='/list' />" class="btn  btn-danger ">Retour</a>
							
						</div>
					</div>
	
				</form:form>
				</div>
		</div>
		</div>
		<div class="generic-container">
		<div class="panel panel-primary">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead"><b>Liste des documents chargés</b></span></div>
		  	<div id="collapse1"  class="tablecontainer">
		  	<br>
		  	   <input type="text" id="myInput1" onkeyup="myFunction1()" placeholder="  Recherche par nom.." title="Type in a name">
				<table id="myTable1"  class="table table-hover table-striped">
		    		<thead>
			      		<tr style=" background-color: rgba(0, 185, 255, 0.3)">
					        <!-- <th>No.</th> -->
					        <th>Nom Fichier</th>
					        <!-- <th>Type</th> -->
					        <th>Description</th>
					        <th>Type Fichier</th>
					        <th>Date création</th>
					        <th>Année</th>
					        <th>Mois</th>
					        
					        <th style="text-align:center" width="100">Action</th>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${documents}" var="doc" varStatus="counter">
						<tr>
<%-- 							<td>${counter.index + 1}</td>
 --%>							<td>${doc.name}</td>
							<%-- <td>${doc.type}</td> --%>
							<td>${doc.description}</td>
							<td>${doc.typedocument}</td>
							<td>${doc.dateCreation}</td>
							<td>${doc.annee}</td>
							<td>${doc.mois}</td>
							<td style="text-align:center"><a href="<c:url value='/download-document-${user.login}-${doc.id}' />" class="btn btn-xs btn-success "><img src="<c:url value="/static/images/download (3).png"/>" title="Télécharger le fichier" width="18" height="18"/>  Télécharger</a>
							<a href="<c:url value='/delete-document-${user.login}-${doc.id}' />" class="btn btn-xs btn-danger "><img src="<c:url value="/static/images/file.png"/>" title="Télécharger le fichier" width="18" height="18"/>  Supprimer</a></td>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
		</div>
	 	<%-- <div class="well">
	 		aller vers <a href="<c:url value='/list' />">Users List</a>
	 	</div> --%>
   	</div>
   	<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>