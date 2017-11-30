<%@include file='../../templates/Header_chofer_viaje_activo.jsp' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <br>
    <br>
    <br>
	<h3>Log cargado:</h3>
	<br>
	<div class="row color-invoice">
		<div class="col-md-12">
			<div class="row">
				<br><br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Id log de viaje</th>
							<th scope="col">Descripci�n</th>
							<th scope="col">Precio</th>
							<th scope="col">Fecha inicio</th>
							<th scope="col">Id de viaje</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${logViaje.id}" /></td>
							<td><c:out value="${logViaje.tipoLogViaje}" /></td>
							<td><c:out value="${logViaje.precio}" /></td>
						    <td><c:out value="${logViaje.fecha}" /></td>
							<td><c:out value="${logViaje.viaje.id}" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<hr />
		<hr />
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12">

				<a href="viajeEnProceso" class="btn btn-success btn-sm">Volver
					al men� viaje activo</a>
			</div>
		</div>
		<hr>
		<div class="row"></div>
	</div>
</div>

<%@include file='../../templates/Footer.jsp'%>