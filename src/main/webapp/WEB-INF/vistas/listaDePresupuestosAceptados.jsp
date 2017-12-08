<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
          prefix="fmt" %>
<%@include file='../../templates/Header.jsp' %>

<div class="container" style="margin-top:60px!important">
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
					 <h1> Lista de Presupuestos aceptados </h1>

						<table class="table table-striped custab">
							<thead>
								<tr>
									
									<th scope="col">Numero del presupuesto</th>
									<th scope="col">Fecha</th>
									<th scope="col">$Precio</th>
									<th scope="col">Asignar Chofer</th>
						
								
								</tr>
							</thead>
							<tbody>
							 <c:forEach var="mov" items="${presupuestos}" >
									<tr>
									   <!-- UNA VEZ QUE ESTE CARGADO LOS DATOS SE PUEDEN -->
										<td><fmt:formatNumber pattern="0000" type="number" value="${mov.getPuntoVenta()}" /> - <fmt:formatNumber pattern="00000000" type="number" value="${mov.getNumeroMovimiento()}" /></td>
										<td><c:out value="${mov.getFecha_hora()}"/></td>
										<td><c:out value="${mov.getViaje().getPrecio()}"/></td>
										<td><c:out value=""/> <a class="btn btn-default btn-circle" href="${pageContext.request.contextPath}/asignarVehiculo?id=${mov.getId()}"><span class="glyphicon glyphicon-user">Agregar</span> </a>
										</td>							
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				

			</div>
		</div>
	</div>
<%@include file='../../templates/Footer.jsp' %>
