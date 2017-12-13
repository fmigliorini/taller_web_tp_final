<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row color-invoice">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-12">
					<br />
					<h1>Viajes realizados:</h1>
					<br />
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="col">Id viaje</th>
								<th scope="col">Fecha y Hora de Incio</th>
								<th scope="col">Fecha y Hora fin</th>
								<th scope="col">Origen</th>
								<th scope="col">Destino</th>
								<th scope="col">Kilometros</th>
								<th scope="col">Precio</th>
								<th scope="col">Peso</th>
								<th scope="col">Logs</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="viaje" items="${listaViajesFinalizados}">

								<tr>

									<td><c:out value="${viaje.id}" /></td>
									<td><c:out value="${viaje.fechaHora}" /></td>
									<td><c:out value="${viaje.fechaHoraFin}" /></td>
									<td><c:out value="${viaje.origen}" /></td>
									<td><c:out value="${viaje.destino}" /></td>
									<td><c:out value="${viaje.kilometros}" /></td>
									<td><c:out value="${viaje.precio}" /></td>
									<td><c:out value="${viaje.peso}" /></td>
									<td><a href="logViajeFinalizado?idViaje=${viaje.id}">ver más</a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file='../../templates/Footer.jsp'%>