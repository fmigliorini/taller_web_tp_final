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
					<h1>Lista de Vehiculos</h1>
					<a class="btn btn-default btn-circle"
						href="${pageContext.request.contextPath}/agregarVehiculo"><span
						class="glyphicon glyphicon-trash"></span> Agregar Vehiculo</a>

					<table class="table table-striped custab">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Patente</th>
								<th scope="col">Marca</th>
								<th scope="col">Modelo</th>
								<th scope="col">Chofer</th>
								<th scope="col">Tipo de Vehiculo</th>
								<th scope="col">Externo</th>
								<th scope="col">Editar</th>
								<th scope="col">Eliminar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${vehiculo}">
								<tr>
									<!-- UNA VEZ QUE ESTE CARGADO LOS DATOS SE PUEDEN -->
									<td><c:out value="${c.id}" /></td>
									<td><c:out value="${c.patente}" /></td>
									<td><c:out value="${c.marca}" /></td>
									<td><c:out value="${c.modelo}" /></td>
									<td><c:out value="${c.chofer.nombre}" /></td>
									<td><c:out value="${c.tipoVehiculo.descripcion}" /></td>
									<td><c:out value="${c.externo}" /></td>
									<td><c:out value="" /><a
										class="btn btn-default btn-circle"
										href="${pageContext.request.contextPath}/modificarVehiculo?idVehiculo=${c.getId()}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><c:out value="" /> <a
										class="btn btn-default btn-circle"
										href="${pageContext.request.contextPath}/eliminarVehiculo?idVehiculo=${c.getId()}"><span
											class="glyphicon glyphicon-trash"></span> </a></td>
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