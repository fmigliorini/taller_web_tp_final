<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file='../../templates/Header.jsp'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Viajes activos</title>
</head>
<body>
	<div class="container" style="margin-top: 60px !important">
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
						<h1>Lista de Viajes activos</h1>

						<table class="table table-striped custab">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Hora</th>
									<th scope="col">Fecha</th>
									<th scope="col">Origen</th>
									<th scope="col">Destino</th>
									<th scope="col">Kilometros</th>
									<th scope="col">Precio</th>
									<th scope="col">Peso</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="v" items="${viajes}">
									<tr>
										<!-- UNA VEZ QUE ESTE CARGADO LOS DATOS SE PUEDEN -->
										<td><c:out value="${v.id}" /></td>
										<td><c:out value="${v.hora}" /></td>
										<td><c:out value="${v.fecha}" /></td>
										<td><c:out value="${v.origen}" /></td>
										<td><c:out value="${v.destino}" /></td>
										<td><c:out value="${v.kilometros}" /></td>
										<td><c:out value="${v.precio}" /></td>
										<td><c:out value="${v.peso}" /></td>
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