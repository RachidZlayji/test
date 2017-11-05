<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html >
        <head>
        	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   

    <link rel="stylesheet" href="/static/css/demo.css">
        	
             <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
             <meta name="viewport" content="initial-scale=1, maximum-scale=1">
			<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
			<link href="<c:url value='/static/css/w3.css' />" rel="stylesheet"></link>	
    		<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'> 
    		
			<link href="<c:url value='/static/css/css1.css' />" rel="stylesheet"></link>
         	<link rel="icon" href="/static/images/expehris.ico"/>
            
            <title>Login</title>
        </head>
        <body   >
		<section style=" height: 661.57px" class="  login-block ">
    <div class="container">
	<div class="row">
		<div class="col-md-4 login-sec">
		    <h2 class="text-center">Connexion</h2>
<form:form class="login-form" modelAttribute="login" action="loginProcess">
  <div class="form-group">
    <label for="exampleInputEmail1" class="text-uppercase"><i class="fa fa-user" aria-hidden="true"></i>  Login</label>
    <input name="username" id="username" class="form-control" placeholder="Login" />  
    	
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1" class="text-uppercase"><i class="fa fa-key" aria-hidden="true"> </i>
       Mot de passe </label>
    <input type="password" name="password" id="password" class="form-control" placeholder="Mot de passe">
   
  </div>
  
  
    <div class="form-check">
    <button type="submit" class="btn btn-login float-right">Valider</button>
    

  </div>
  <br>
  <div class="form-check">
  
      <table align="left" >
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
   </div>
  
</form:form>

           
	</div>
		<div class="col-md-8 banner-sec">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <!--   <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                  </ol> -->
            <div class="carousel-inner" role="listbox">
   
    </div>
  </div>
            </div>	   
		    
		</div>
	</div>
</div>
</section>






        </body> 
        </html>