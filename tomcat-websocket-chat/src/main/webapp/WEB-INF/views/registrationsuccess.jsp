<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="icon" href="/static/images/expehrislogo.ico"/>
	
	<title>Registration Confirmation Page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	 <link href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' />" rel="stylesheet"></link>
</head>
<body id='bodybody'>
 <%@include file="/WEB-INF/views/header.jsp" %>
	<div class="generic-container">
		<div class="alert alert-success lead">
	    		    <img src="<c:url value="/static/images/check (1).png"/>" title="succès" width="45" height="45"/>	
	    ${success}
	   
		</div>
		
		<span class="well pull-left">
			<a href="<c:url value='/add-document-${user.login}' />" > Charger les documents de ${user.login}</a>	
		</span>
		<span class="well pull-right">
			<a href="<c:url value='/list' />" class="btn btn-danger custom-width">Retour à la liste</a>
		</span>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp" %>
</body>

</html>