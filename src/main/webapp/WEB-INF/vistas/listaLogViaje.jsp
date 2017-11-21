<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file='menu_chofer_viajeActivo.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de LogViajes</title>
</head>
<body>
	<div class="container">
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
						<br>
						<h3>Esta es la lista de los Log cargados:</h3>
						<br>
						<table class="table table-bordered">
							<thead>
								<tr>
									
									<th scope="col">Id log de viaje</th>
									<th scope="col">Descripci�n</th>
									<th scope="col">Precio</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="chofer" items="${listaLog}">
									<tr>
										
										<td><c:out value="${chofer.id}" /></td>
										<td><c:out value="${chofer.tipoLogViaje}" /></td>
										<td><c:out value="${chofer.precio}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<hr />
				<hr />
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<a href="menu_chofer_viajeActivo" class="btn btn-success btn-sm">Volver
							al men� viaje activo</a>
					</div>
				</div>
				<hr>
				<div class="row"></div>
			</div>
		</div>
	</div>