<%@include file='../../templates/Header.jsp'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Remitos</title>
</head>
<body>
<body>
	<div class="container">
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
						<br />
						<h1>Lista de Remitos:</h1>
						<br />
						<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">id</th>
									<th scope="col">fecha_hora</th>
									<th scope="col">Estado</th>
									<th scope="col">TipoVehiculo</th>
							
								</tr>
							</thead>
							<tbody>
								<c:forEach var="remito" items="${listaRemitos}">

									<tr>
										<td><c:out value="${remito.id}" /></td>	
										<td><c:out value="${remito.fecha_hora}" /></td>
										<td><c:out value="${remito.estadoMovimiento.descripcion}" /></td>
										<td><c:out value="${remito.viaje.tipoVehiculo.descripcion}" /></td>
										<!--  <td><a class="btn btn-primary" href="verRemito/<c:out value="${remito.id}" />"> ver Mas</a></td>-->
										
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