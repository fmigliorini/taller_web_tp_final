<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Header_chofer_viaje_activo.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de LogViajes</title>
</head>
<body>
	<div class="container">
		<br>
	    <br>
	    <br>
		<h3>Esta es la lista de los Log cargados:</h3>
		<br>
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">Id log de viaje</th>
									<th scope="col">Id de viaje</th>
									<th scope="col">Descripción</th>
									<th scope="col">Precio</th>
									<th rowspan="2">Total de log de viaje: </th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="logViaje" items="${listaLog}">
									<tr>
										
										<td><c:out value="${logViaje.id}" /></td>
										<!-- No muestra el id de viaje -->
										<td><c:out value="${logViaje.viaje.id}"/></td>
										<td><c:out value="${logViaje.tipoLogViaje}" /></td>
										<td><c:out value="${logViaje.precio}" /></td>
										
									<tr>
								
									
								</c:forEach>
								
							</tbody>
						</table>
					</div>
				</div>
				<hr />
				<hr />
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<a href="menu_chofer_viajeActivo" class="btn btn-success btn-sm">Volver
							al menú viaje activo</a>
					</div>
				</div>
				<hr>
				<div class="row"></div>
			</div>
		</div>
	</div>