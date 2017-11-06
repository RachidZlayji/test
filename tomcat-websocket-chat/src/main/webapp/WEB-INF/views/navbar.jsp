<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link rel="icon" href="/static/images/expehrislogo.ico"/>
	
	<title></title>
	        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
			<link href="<c:url value='/static/css/w3.css' />" rel="stylesheet"></link>	
    		<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'> 
    		
</head>
<body>
<script type="text/javascript" src="<c:url value="static/js/bootstrap.min.js" />" ></script>



<nav class="  navbar navbar-inverse " role="navigation">
	<div class="container-fluid ">
			<!-- <div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#f">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
			</button>
			
			</div>/.navbar-header -->

			<div class="collapse navbar-collapse" id="f">
		
				<ul style="float:left " class="nav navbar-nav ">
									
				
					<li style="float:left"><a href="<c:url value='/list-employeurs' />"><i class="fa fa-user " aria-hidden="true"></i> Employeurs </a></li>
					<li style="float:left"><a href="<c:url value='/list-comptables' />"><i class="fa fa-user" aria-hidden="true" ></i> Comptables </a></li>
					
					<!--    <div style="float:right" class="navbar-header"> 
		      <a class="navbar-brand" >   
		      <center>  </center></a> 
		     <a class="navbar-brand" >    Administrateur  </a>
		    </div> -->
				</ul>
									<ul style="color:white" class="nav navbar-nav navbar-right"><li style="color:red float:right" ><img src="<c:url value="/static/images/admin-online.png"/>" title="Admin" width="50" height="45" />Admin  </li></ul>
					
				<!-- /.nav navbar-nav -->
			</div><!-- collapse navbar-collapse -->
			</div>
	</nav><!-- navbar navbar-default -->

	
</body>
</html>