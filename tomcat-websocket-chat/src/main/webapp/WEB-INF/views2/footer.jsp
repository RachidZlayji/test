<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <title>Footer with Button and Logo</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    
    
       <link href="<c:url value='http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css' />" rel="stylesheet"></link>
   	   <link href="<c:url value='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' />" rel="stylesheet"></link>
   		<link href="<c:url value='/static/css/Footer-with-button-logo.css'/>" rel="stylesheet"></link>
</head>

<body>
<div class="content">
</div>
    <footer id="myFooter">
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <h2 class="logo"><a href="http://www.expehris.com/"> <img src="<c:url value="/static/images/logo-small-300x103 (2).png"/>" title="Expehris icon" width="250" height="100" /> </a></h2>
                </div>
                <div class="col-sm-2">
                    <h5>Commencer</h5>
                    <ul>
                        <li><a href="<c:url value='http://www.expehris.com/' />">Accueil</a></li>
                        <li><a  href="<c:url value='http://www.expehris.com/login/?redirect_to=http%3A%2F%2Fwww.expehris.com%2Fespace-client%2F' />">Inscrivez-vous!</a></li>
                        <li><a href="#">Téléchargements</a></li>
                    </ul>
                </div>
                <div class="col-sm-2">
                    <h5>A propos de nous</h5>
                    <ul>
                        <li><a  href="<c:url value='http://www.expehris.com/qui-sommes-nous/' />">information à propos de l'entreprise</a></li>
                        <li><a  href="<c:url value='http://www.expehris.com/contact/' />">Contact </a></li>
                        <li><a  href="<c:url value='http://www.expehris.com/offre-service/gamme-services-conseil-rh/'/>">Offre de service</a></li>
                    </ul>
                </div>
                <div class="col-sm-2">
                    <h5>Support</h5>
                    <ul>
                        <li><a href="#">FAQ</a></li>
                        <li><a href="#">Help desk</a></li>
                        <li><a href="#">Forums</a></li>
                    </ul>
                </div>
                <div class="col-sm-3">
                    <div class="social-networks">
                        <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
                        <a  href="<c:url value='https://www.facebook.com/expehris/' />" class="facebook"><i class="fa fa-facebook"></i></a>
                        <a href="#" class="google"><i class="fa fa-google-plus"></i></a>
                    </div>
                    <a  href="<c:url value='http://www.expehris.com/contact/' />"><button type="button" class="btn btn-default">Contact us</button></a>
                   <!--  <button type="button" class="btn btn-default">Contact us</button> -->
                </div>
            </div>
        </div>
        <div class="footer-copyright">
            <p>© 2017 Copyright Expehris. </p>
        </div>
    </footer>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>
