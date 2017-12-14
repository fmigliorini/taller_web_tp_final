<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file='../../templates/Header.jsp'%>

<div class="container" style="margin-top: 60px !important">
	<div class="row color-invoice">
		<div class="col-md-12">
			<div class="row">

				<h1>Lista de Log del viaje ${viaje.id}</h1>
				<div class="col-md-6">
					<label>Fecha y Hora de Inicio:</label>${viaje.fechaHora}
				</div>
				<div class="col-md-6">
					<label>Fecha y Hora de Fin:</label>${viaje.fechaHoraFin}
				</div>
				<div class="col-md-6">
					<label>Origen:</label>${viaje.origen}
				</div>
				<div class="col-md-6">
					<label>Destino:</label>${viaje.destino}
				</div>
				<div class="col-md-6">

					<label>Kilometros:</label>${viaje.kilometros}
				</div>
				<div class="col-md-6">
					<label>Precio:</label>${viaje.precio}
				</div>
				<table class="table table-striped custab">
					<thead>
						<tr>
							<th scope="col">Fecha</th>
							<th scope="col">Tipo Log</th>
							<th scope="col">Precio</th>


						</tr>
					</thead>
					<tbody>
						<c:forEach var="lv" items="${logViajes}">
							<tr>
								<!-- UNA VEZ QUE ESTE CARGADO LOS DATOS SE PUEDEN -->
								<td><c:out value="${lv.fecha}" /></td>
								<td><c:out value="${lv.tipoLogViaje}" /></td>
								<td><c:out value="${lv.precio}" /></td>

							</tr>
						</c:forEach>
						<tr>
							<td><c:out value="" /></td>
							<td><c:out value="" /><strong>Total</strong></td>
							<td><c:out value="${total}" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>


<%@include file='../../templates/Footer.jsp'%>