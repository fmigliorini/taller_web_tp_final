<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file='../../templates/Header.jsp'%>

<div class="container" style="margin-top: 60px !important">

	<h1>
		Asignar vehiculo al Presupuesto
		<fmt:formatNumber pattern="0000" type="number"
			value="${mov.getPuntoVenta()}" />
		-
		<fmt:formatNumber pattern="00000000" type="number"
			value="${mov.getNumeroMovimiento()}" />
	</h1>
	<div class="row">
		<div class="col-lg-6 col-md-6 col-sm-6">
			<br>
			<strong> Fecha y hora de comienzo del servicio:</strong>${mov.getViaje().getFechaHora() } <br>
			<strong> Fecha y hora de  aproximada de finalizacion :</strong> ${mov.getViaje().getFechaHoraFin() } <br>
			<strong> Tipo de vehiculo:</strong>
			${mov.getViaje().getTipoVehiculo().getDescripcion() }
		</div>

		<div class="col-lg-6 col-md-6 col-sm-6">
			<br> <strong>Direccion de origen:</strong>
			${mov.getViaje().getOrigen() } <br>
			<strong>Direccion de destino:</strong> ${mov.getViaje().getDestino() }
			<br> <strong>Kilometros a recorrer:</strong>
			${mov.getViaje().getKilometros() }

		</div>

	</div>



	<form action="generarMovimientos" method="POST"
		action="${pageContext.request.contextPath}/generarMovimientos">
		<input type="hidden" name="idMovimiento" value="${mov.getId()}">
		<div class="row">
			<div class="form-group col-md-12">
				<label for="origen">Vehiculo</label> <select name="idVehiculo"
					class="form-group col-md-12">
					<c:forEach items="${listVehiculos}" var="vehiculo">
						<option value="${vehiculo.getId()}">${vehiculo.getModelo()}
							${vehiculo.getMarca()} ${vehiculo.getPatente()} - ${vehiculo.isExterno()}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<input type="submit" class="btn btn-primary" value="asignarVehiculo"> <a class="btn btn-danger"
					href="${pageContext.request.contextPath}/rechazarMovimiento?idMovimiento=${mov.getId()}">Rechazar
					Presupuesto</a>
			</div>
		</div>
	</form>

</div>

<%@include file='../../templates/Footer.jsp' %>
