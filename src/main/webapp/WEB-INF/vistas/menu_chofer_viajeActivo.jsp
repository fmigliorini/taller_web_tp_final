<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>   
	        <meta charset="utf-8">
	        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Menu Viaje activo</title>
			<!-- Bootstrap core CSS -->
	        <link href="css/bootstrap-new.min.css" rel="stylesheet" >
	        <!-- Bootstrap theme -->
	        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	       <style>
			body {
				  padding-top: 54px;
				}
				
			@media (min-width: 992px) {
				  body {
				    padding-top: 56px;
				  }
	}
	</style>
	<body>
	  <!-- Navigation -->
	    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	      <div class="container">
	        <a class="navbar-brand" href="index">Fletes Pepe </a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	        </button>
	        <div class="collapse navbar-collapse" id="navbarResponsive">
	          <ul class="navbar-nav ml-auto">	
	            <li class="nav-item">
	            <!--Aun no esta terminado --> 
	              <a class="nav-link" href="listaLogViaje">Ver log de viaje</a>
	            </li>
	            <li class="nav-item">
	              <!--logViajeForm es la url  -->
	              <a class="nav-link" href="logViajeForm">Cargar Log de viaje</a>
	            </li>
	            <li class="nav-item">
	               <!-- Por ahora el finalizar viaje redireccionará a menú de chofer -->
	              <a class="nav-link" href="indexChofer">Finalizar viaje</a>
	            </li>
	    
	          </ul>
	        </div>
	      </div>
	    </nav>

	</body>
</html>