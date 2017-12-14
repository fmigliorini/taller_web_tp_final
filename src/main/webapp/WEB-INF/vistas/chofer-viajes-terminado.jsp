<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Header.jsp' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de viajes realizados </title>
</head>
<body>

<div class="container">
		<div class="row color-invoice">
			<div class="col-md-12">
			   <h1>Lista de viajes realizados</h1>
			   <br>
				<div class="row">
					<div class="col-md-12">
						<table class="table table-bordered">
							<thead>
								<tr>
									
									<th scope="col">Id viaje</th>
									<th scope="col">Fecha y Hora inicio</th>
									<th scope="col">Fecha y Hora fin</th>
									<th scope="col">Descripción</th>
									<th scope="col">Origen</th>
									<th scope="col">Destino</th>
									<th scope="col">Kilometros</th>
									<th scope="col">Peso</th>
									<th scope="col">Estado</th>
									<th scope="col">Tipo de vehículo</th>
									<th scope="col">Precio</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="viajeTerminado" items="${listaDeViajesTerminados}">
									<tr>
									   <!-- UNA VEZ QUE ESTE CARGADO LOS DATOS SE PUEDEN -->
										<td><c:out value="${viajeTerminado.id}" /></td>
										<td><c:out value="${viajeTerminado.fecha}" /></td>
										<td><c:out value="${viajeTerminado.hora}" /></td>
										<td><c:out value="${viajeTerminado.descripcion}"/></td>
										<td><c:out value="${viajeTerminado.origen}"/></td>
										<td><c:out value="${viajeTerminado.destino}"/></td>
										<td><c:out value="${viajeTerminado.kilometros}"/></td>
										<td><c:out value="${viajeTerminado.peso}" /></td>
										<td><c:out value="${viajeTerminado.estado}"/></td>
										<td><c:out value="${viajeTerminado.tipoVehiculo.descripcion}" /></td>
										<td><c:out value="${viajeTerminado.precio}" /></td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file='../../templates/Footer.jsp' %>