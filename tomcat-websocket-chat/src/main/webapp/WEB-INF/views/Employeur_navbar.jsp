<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link rel="icon" href="/static/images/expehrislogo.ico"/>
	
	<title></title>
	        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
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
				<ul style="float:left " class="nav navbar-nav">
									
				
					<li style="float:left"><a href="<c:url value='/listEmployees' />"><i class="fa fa-file-text" aria-hidden="true"></i> Liste des salariés </a></li>
					<li style="float:left"><a href="<c:url value='/listbulletins-${searchedyear}' />"><i class="fa fa-file-text" aria-hidden="true" ></i> Liste des bulletins de paie </a></li>
					
					<!--    <div style="float:right" class="navbar-header"> 
		      <a class="navbar-brand" >   
		      <center>  </center></a> 
		     <a class="navbar-brand" >    Administrateur  </a>
		    </div> -->
				</ul><div style=" paddin:50px ;color:white"  class="collapse navbar-collapse" id="f">
									<ul style=" padding:10px ;color:white" class="nav navbar-nav navbar-right"><li style="color:red float:right" ><img src="<c:url value="/static/images/Employeur_online.png"/>" title="Employeur" width="48" height="30" />Employeur </li></ul>
				</div>
				<!-- /.nav navbar-nav -->
			</div><!-- collapse navbar-collapse -->
			</div>
	</nav><!-- navbar navbar-default -->

	
</body>
</html>