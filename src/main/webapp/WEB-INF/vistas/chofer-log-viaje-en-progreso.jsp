<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Header_chofer_viaje_activo.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<br> <br> <br>
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
								<th scope="col">Descripción</th>
								<th scope="col">Precio</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="logViaje" items="${listaLogViajeEnProceso}">
								<tr>

									<td><c:out value="${logViaje.id}" /></td>
									<!-- No muestra el id de viaje -->
									<td><c:out value="${logViaje.tipoLogViaje}" /></td>
									<td><c:out value="${logViaje.precio}" /></td>
								<tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<a href="viajeEnProceso" class="btn btn-success btn-sm">Volver
						al menú viaje activo</a>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file='../../templates/Footer.jsp'%>

