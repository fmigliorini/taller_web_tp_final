<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
             <meta charset="utf-8">
	        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Menu chofer</title>
			<!-- Bootstrap core CSS -->
	        <link href="css/bootstrap-new.min.css" rel="stylesheet" >
	        <!-- Bootstrap theme -->
	        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
           
<title>Viaje activado</title>
</head>
<body>
	  <!-- Navigation -->
	    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	      <div class="container">
	        <a class="navbar-brand" href="menu_chofer_viajeActivo">Fletes Pepe </a>
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
	              <a class="nav-link" href="logViajeForm?idViaje=${viajeEnProceso.id}">Cargar Log de viaje</a>
	            </li>
	          </ul>
	        </div>
	      </div>
	    </nav>

</body>
</html>