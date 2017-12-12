<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file='../../templates/Header_chofer_viaje_activo.jsp'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Viaje activo</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap-new.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<style>
body {
	padding-top: 54px;
}

@media ( min-width : 992px) {
	body {
		padding-top: 56px;
	}
}
</style>
<body>

	<div class="container">
		<div class="row color-invoice">
			<div class="col-md-12">

				<br>
				<h2>${viajeEnProceso.vehiculo.chofer.nombre}seencuentraenel
					siguiente recorrido:</h2>
				<br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Hora</th>
							<th scope="col">Fecha</th>
							<th scope="col">Origen</th>
							<th scope="col">Destino</th>
							<th scope="col">KM</th>
							<th scope="col">Precio</th>
							<th scope="col">Peso</th>
							<th scope="col">Finalizar</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${viajeEnProceso.hora}" /></td>
							<td><c:out value="${viajeEnProceso.fecha}" /></td>
							<td><c:out value="${viajeEnProceso.origen}" /></td>
							<td><c:out value="${viajeEnProceso.destino}" /></td>
							<td><c:out value="${viajeEnProceso.kilometros}" /></td>
							<td><c:out value="$ ${viajeEnProceso.precio}" /></td>
							<td><c:out value="${viajeEnProceso.peso}" /></td>
							<td><form:form role="form" action="finalizarViajeEnProgreso"
									method="post" name="comenzarViaje">
									<button class="btn btn-success">Finalizar viaje</button>
								</form:form></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="container color-invoice">

		<div class="row">
			<div class="col-md-12">
				<button id="verMapa" class="btn btn-primary"
					onclick="loadRoute('${viajeEnProceso.origen}','${viajeEnProceso.destino}')">
					Cargar Ruta</button>
			</div>
		</div>
		<br />
		<div class="row">
			<div id="map" class="col-md-8" style="height: 400px;"></div>
			<div id="directionsPanel" class="col-md-4"
				style="height: 400px; overflow: auto;"></div>
		</div>
	</div>

	<%@include file='../../templates/Footer.jsp'%>

	<script src="js/GMapsRoute.js" type="text/javascript"></script>