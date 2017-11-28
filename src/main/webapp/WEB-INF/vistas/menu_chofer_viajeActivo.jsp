<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	              <a class="nav-link" href="logViajeForm">Cargar Log de viaje</a>
	            </li>
	            <li class="nav-item">
	               <!-- Por ahora el finalizar viaje redireccionará a menú de chofer -->
	              <a class="nav-link" href="index_chofer">Finalizar viaje</a>
	            </li>
	    
	          </ul>
	        </div>
	      </div>
	    </nav>
        <div class="container">
    		<div class="row color-invoice">
        		<div class="col-md-12">
            
            		
     						<h1>Ustede se encuentra en el siguiente recorrido: </h1>
     						<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">Id viaje</th>
									<th scope="col">Hora</th>
									<th scope="col">Fecha</th>
									<th scope="col">Origen</th>
									<th scope="col">Destino</th>
									<th scope="col">Kilometros</th>
									<th scope="col">Descripción</th>
									<th scope="col">Precio</th>
									<th scope="col">Peso</th>
									<th scope="col">Estado</th>
									<th scope="col">Tipo de vehículo</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									    <td><c:out value="${viajeEnProceso.id}" /></td>
										<td><c:out value="${viajeEnProceso.hora}" /></td>
										<td><c:out value="${viajeEnProceso.fecha}" /></td>
										<td><c:out value="${viajeEnProceso.origen}" /></td>
										<td><c:out value="${viajeEnProceso.destino}" /></td>
										<td><c:out value="${viajeEnProceso.kilometros}" /></td>
										<td><c:out value="${viajeEnProceso.descripcion}" /></td>
										<td><c:out value="${viajeEnProceso.precio}" /></td>
							            <td><c:out value="${viajeEnProceso.peso}" /></td>
										<td><c:out value="${viajeEnProceso.estado}" /></td>
										<td><c:out value="${viajeEnProceso.tipoVehiculo.descripcion}" /></td>
								</tr>
							</tbody>
						</table>
     					 </div>
     				</div>
     		   </div>
     	       <div class="container">
    		     <div class="row color-invoice">
        		   <div class="col-md-12">										
				            <form:form role="form" action="finalizarViaje" modelAttribute="viaje" method="post" name="comenzarViaje">
			     	        <form:input type="hidden" path="id" value="${viaje.id }"/>
							<form:button class="btn btn-success">Finalizar viaje</form:button></form:form>
				  </div>
				 </div>
				</div>
			
	</body>
</html>