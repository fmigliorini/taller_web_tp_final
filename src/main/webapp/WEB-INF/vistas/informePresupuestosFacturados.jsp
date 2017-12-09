<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
          prefix="fmt" %>
<%@include file='../../templates/Header.jsp' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Presupuestos Aceptados</title>
</head>
<body>
<div class="container" style="margin-top:60px!important">
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
					 <h1> Informe de Presupuestos facturados </h1>

						<table class="table table-striped custab">
							<thead>
								<tr>
									<th scope="col" >Numero del presupuesto</th>
									<th scope="col">Cliente</th>
									<th scope="col">Chofer</th>
									<th scope="col">Fecha</th>
									<th scope="col">$Precio</th>
								</tr>
							</thead>
							<tbody>
							 <c:forEach var="mov" items="${presupuestos}" >
									<tr>
									   <!-- UNA VEZ QUE ESTE CARGADO LOS DATOS SE PUEDEN -->
										<td><fmt:formatNumber pattern="0000" type="number" value="${mov.getPuntoVenta()}" /> - <fmt:formatNumber pattern="00000000" type="number" value="${mov.getNumeroMovimiento()}" /></td>
										<td><c:out value="${mov.getUsuario().getNombre()}"/></td>
										<td><c:out value="${mov.getViaje().getVehiculo().getChofer().getNombre()}"/></td>
										<td><c:out value="${mov.getFecha_hora()}"/></td>
										<td><c:out value="${mov.getViaje().getPrecio()}"/></td>
																
									</tr>
								</c:forEach>
									<tr>
									<td></td>
									<td></td>
										<td></td>
								<td>Total Presupuestado</td>
										<td><c:out value="${totalPresupuestado}"/></td>
																
									</tr>
							</tbody>
						</table>
					</div>
				</div>
				

			</div>
		</div>
	</div>

</body>
</html>