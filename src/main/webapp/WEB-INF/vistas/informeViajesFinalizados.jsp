<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file='../../templates/Header.jsp'%>

<div class="container" style="margin-top: 60px !important">
	<div class="row color-invoice">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-12">
					<h1>Lista de Viajes finalizados</h1>

					<table class="table table-striped custab">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Fecha y Hora de Inicio</th>
								<th scope="col">Fecha y Hora de Fin</th>
								<th scope="col">Origen</th>
								<th scope="col">Destino</th>
								<th scope="col">Kilometros</th>
								<th scope="col">Precio</th>
								<th scope="col">Peso</th>
								<th scope="col">Log Viaje</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="v" items="${viajes}">
								<tr>
									<!-- UNA VEZ QUE ESTE CARGADO LOS DATOS SE PUEDEN -->
									<td><c:out value="${v.id}" /></td>
									<td><c:out value="${v.fechaHora}" /></td>
									<td><c:out value="${v.fechaHoraFin}" /></td>
									<td><c:out value="${v.origen}" /></td>
									<td><c:out value="${v.destino}" /></td>
									<td><c:out value="${v.kilometros}" /></td>
									<td><c:out value="${v.precio}" /></td>
									<td><c:out value="${v.peso}" /></td>
									<td><c:out value="" /> <a
										class="btn btn-default"
										href="${pageContext.request.contextPath}/informeLogViaje?idViaje=${v.getId()}"><span
											class="glyphicon glyphicon-eye-open">  </span> Ver</a></td>
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