<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="icon" href="/static/images/expehris.ico"/>
	
	<title>Formulaire d'inscription  Comptables </title>
    		<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'> 
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/w3.css' />" rel="stylesheet"></link>
</head>

<body id='bodybody'>
 <%@include file="/WEB-INF/views/header.jsp" %>
  <%@include file="/WEB-INF/views/navbar.jsp" %>

 	<div class="generic-container">
	<div class="well lead"><b>Formulaire d'inscription  Comptable</b></div>
 	<form:form method="POST" modelAttribute="user" class="form-horizontal">
		<form:input type="hidden" path="id" id="id"/>
		
		<div class="row">
			<div style="color:white" class="form-group col-md-6">
				<label class="col-md-3 control-lable" for="prenom">Prénom<span class="red-star"> *</span></label>
				<div class="col-md-7">
					<form:input type="text" path="prenom" id="prenom" required="true" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="prenom" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div style="color:white" class="form-group col-md-6">
				<label class="col-md-3 control-lable" for="nom">Nom<span class="red-star"> *</span></label>
				<div class="col-md-7">
					<form:input type="text" required="true" path="nom" id="nom" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="nom" class="help-inline"/>
					</div>
					
				</div>
			</div>
		</div>

		<div class="row">
			<div style="color:white" class="form-group col-md-6">
				<label class="col-md-3 control-lable" for="login">Login<span class="red-star"> *</span></label>
				<div class="col-md-7">
					<c:choose>
						<c:when test="${edit}">
							<form:input type="text" path="login" id="login" class="form-control input-sm" disabled="true"/>
						</c:when>
						<c:otherwise>
							<form:input type="text" required="true" path="login" id="login" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="login" class="help-inline"/>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>

		<div class="row">
			<div style="color:white" class="form-group col-md-6">
				<label class="col-md-3 control-lable" for="passwd">Password<span class="red-star"> *</span></label>
				<div class="col-md-7">
					<form:input type="text"  required="true" path="passwd" id="passwd" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="passwd" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		 <div class="row">
			<div style="color:white" class="form-group col-md-6">
				<label class="col-md-3 control-lable" for="entreprise">Entreprise<span class="red-star"> *</span></label>
				<div class="col-md-7">
					<form:input type="text" path="entreprise" required="true" id="entreprise" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="entreprise" class="help-inline"/>
					</div>
				</div>
			</div>
		</div> 
		<div class="row">
		<div align="left" width="60%" >    <pre>(<span class="red-star">*</span>) : Champs requis </pre> </div>
		<br>
			<div class="form-actions floatRight">
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Valider" class="btn btn-success custom-width"/>  <a href="<c:url value='/list-comptables' />" class="btn btn-danger custom-width">Annuler</a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Enregistrer" class="btn btn-primary btn-sm custom-width"/>  <a href="<c:url value='/list-comptables' />" class="btn btn-danger custom-width">Annuler</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<%-- <c:if test="${edit}">
			<span class="well pull-left">
				<a href="<c:url value='/add-document-${user.login}' />">cliquez ici pour gérer/charger documents</a>	
			</span>
		</c:if> --%>
		
	</form:form>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>