<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Menu_chofer.jsp' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
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
					<h1>Lista de viajes a realizar</h1>
					<h3>Paso 1: Muestra una lista de viajes que va a realizer el chofer , ordenados por hora lista diaria</h3>
						<br>
						<h3>Esta es la lista de los viajes:</h3>
						<br>
						<table class="table table-bordered">
							<thead>
								<tr>
									
									<th scope="col">Id viaje</th>
									<th scope="col">Hora</th>
									<th scope="col">Fecha</th>
									<th scope="col">Origen</th>
									<th scope="col">Destino</th>
									<th scope="col">Kilometros</th>
									<th scope="col">Descripción</th>
									<th scope="col">Precio</th>
									<th scope="col">Peso</th>
									<th scope="col">Estado</th>
									<th scope="col">Tipo de vehículo</th>
									
									
								</tr>
							</thead>
							<tbody>
								<c:forEach var="viajeActivo" items="${listaViajeActivo}">
									<tr>
										<td><c:out value="${viajeActivo.id}" /></td>
										<td><c:out value="${viajeActivo.hora}" /></td>
										<td><c:out value="${viajeActivo.fecha}" /></td>
										<td><c:out value="${viajeActivo.origen}" /></td>
										<td><c:out value="${viajeActivo.destino}" /></td>
										<td><c:out value="${viajeActivo.kilometros}" /></td>
										<td><c:out value="${viajeActivo.descripcion}" /></td>
										<td><c:out value="${viajeActivo.precio}" /></td>
							            <td><c:out value="${viajeActivo.peso}" /></td>
										<td><c:out value="${viajeActivo.estado}" /></td>
										<td><c:out value="${viajeActivo.tipoVehiculo.descripcion}" /></td>
										<td><a href="menu_chofer_viajeActivo" class="btn btn-success">Iniciar recorrido</a></td>		
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
					  <!--  <a href="menu_chofer_viajeActivo" class="btn btn-success">Activar recorrido</a> -->
						<a href="indexChofer" class="btn btn-primary">Volver al menú</a>	
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@include file='../../templates/Footer.jsp' %>