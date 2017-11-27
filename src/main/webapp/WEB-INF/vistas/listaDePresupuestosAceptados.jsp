<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Menu_administrador.jsp' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"
          prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Presupuestos Aceptados</title>
</head>
<body>

    
<div class="container">
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
							 <c:forEach var="mov" items="${listaLog}" >
									<tr>
									   <!-- UNA VEZ QUE ESTE CARGADO LOS DATOS SE PUEDEN -->
										<td><fmt:formatNumber pattern="0000" type="number" value="${mov.getPuntoVenta()}" /> - <fmt:formatNumber pattern="00000000" type="number" value="${mov.getNumeroMovimiento()}" /></td>
										<td><c:out value="${mov.getFecha_hora()}"/></td>
										<td><c:out value="${mov.getViaje().getPrecio()}"/></td>
										<td><c:out value=""/> <a class="btn btn-default btn-circle" href="${pageContext.request.contextPath}/asignarChofer?id=${mov.getId()}"><span class="glyphicon glyphicon-user">Agregar</span> </a>
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
    


	    

</body>
</html>