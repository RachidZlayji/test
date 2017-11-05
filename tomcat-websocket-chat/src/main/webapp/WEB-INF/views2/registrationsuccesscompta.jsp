<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration Confirmation Page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	 <link href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' />" rel="stylesheet"></link>
</head>
<body id='bodybody'>
 <%@include file="/WEB-INF/views/header.jsp" %>
	<div class="generic-container">
		<div class="alert alert-success lead">
	    	${success}
		</div>
		<%-- 
		<span class="well pull-left">
			<a href="<c:url value='/add-document-${user.login}' />">cliquez ici pour gérer/charger documents</a>	
		</span> --%>
		<span class="well pull-right">
		

		
	 <a href="<c:url value='/list-comptable-employeur' />" class="btn btn-danger custom-width" align="right">Retour
			</a>
		</span>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp" %>
</body>

</html>