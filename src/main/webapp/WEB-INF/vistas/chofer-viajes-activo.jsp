<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Menu_chofer.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de viajes a realizar</title>
</head>
<body>

	<div class="container">
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
						<br>
						<h1>Lista de viajes a realizar</h1>
						<br>
						<table class="table table-bordered text-center">
							<thead>
								<tr>
									<th scope="col">Hora</th>
									<th scope="col">Fecha</th>
									<th scope="col">Origen</th>
									<th scope="col">Destino</th>
									<th scope="col">KM</th>
									<th scope="col">Precio</th>
									<th scope="col">Peso</th>
									<th scope="col">Estado</th>
									<th scope="col">Operación</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="viaje" items="${listaViajeActivo}">
									<tr>
										<td><c:out value="${viaje.hora}" /></td>
										<td><c:out value="${viaje.fecha}" /></td>
										<td><c:out value="${viaje.origen}" /></td>
										<td><c:out value="${viaje.destino}" /></td>
										<td><c:out value="${viaje.kilometros}" /></td>
										<td><c:out value="$ ${viaje.precio}" /></td>
										<td><c:out value="${viaje.peso}" /></td>
										<td><c:out value="${viaje.estado}" /></td>
										<td><form action="activarViaje" method="POST"
												name="comenzarViaje">
												<input type="hidden" name="idViaje" value="${viaje.id}" />
												<button class="btn btn-success">Iniciar</button>
											</form></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<a href="indexChofer" class="btn btn-primary">Volver al menú</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file='../../templates/Footer.jsp'%>