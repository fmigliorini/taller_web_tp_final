<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Menu_chofer.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Viajes realizados</title>
</head>
<body>
	<div class="container">
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
						<br />
						<h1>Viajes realizados:</h1>
						<br />
						<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">Id </th>
									<th scope="col">Tipo </th>
									<th scope="col">precio </th>
									<th scope="col">Fecha </th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="Log" items="${listaLogsViajeFinalizado}">

									<tr>

										<td><c:out value="${Log.id}" /></td>
										<td><c:out value="${Log.tipoLogViaje}" /></td>
										<td><c:out value="${Log.tipoLogViaje}" /></td>
										<td><c:out value="${Log.fecha}" /></td>
										
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