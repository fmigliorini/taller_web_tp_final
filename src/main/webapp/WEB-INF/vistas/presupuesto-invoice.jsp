<%@include file='../../templates/Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row color-invoice">
		<div class="col-md-12">

			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<h2>Presupuesto: ${presupuesto.id}</h2>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<h2>Estado: ${presupuesto.estadoMovimiento.descripcion}</h2>
				</div>
			</div>
			<hr />
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">

					<strong>Email: </strong> info@mudanzapepe.com <br /> <strong>WEB:
					</strong> www.mudanzapepe.com.ar <br /> <strong>Telefono: </strong>011
					4480-8900 <br /> <strong>Direccion: </strong>Florencio Varela
					1903, B1754JEC San Justo, Buenos Aires
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<br /> <strong>CUIT: </strong> 30-71482650-2 <br /> <strong>Inicio
						de act.: </strong> 21/04/2011 <br /> <strong>Fecha: </strong> 02/11/2017

				</div>
			</div>
			<hr />
			<!--  CLIENT SIDE -->
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<h4>Cliente:</h4>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<br> <strong>Nombre: </strong> ${cliente.nombre } <br> <strong>Apellido:
					</strong> ${cliente.apellido } <br> <strong>dni: </strong>
					${cliente.dni }
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<br> <strong>direccion: </strong> ${cliente.direccion } <br>
					<strong>email: </strong> ${cliente.email } <br> <strong>telefono:
					</strong> ${cliente.telefono }
				</div>
			</div>
			<hr />
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<h4>Descripcion del servicio:</h4>
					Fecha del servicio: 01/12/2017 <br> Hora: 16:00 hs. <br>
					Tipo de vehiculo: ${presupuesto.viaje.tipoVehiculo.descripcion }

				</div>

				<div class="col-lg-6 col-md-6 col-sm-6">
					<br> Direccion de origen: ${presupuesto.viaje.origen } <br>
					Direccion de destino: ${presupuesto.viaje.destino } <br>
					Kilometros Recorridos: ${presupuesto.viaje.kilometros }



				</div>

			</div>
			<hr />
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<strong>DETALLE</strong>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Descripcion</th>
									<th>Cant.</th>
									<th>$ Uni.</th>
									<th>%Desc.</th>
									<th>Sub Total</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Servicio de Mudanza con camion , recorrido 15,3</td>
									<td>${presupuesto.viaje.kilometros }</td>
									<td>$ ${presupuesto.viaje.tipoVehiculo.precio }</td>
									<td>0</td>
									<td>$ ${presupuesto.viaje.precio }</td>
								</tr>
							</tbody>
						</table>
					</div>
					<hr>
					<div>
						<h3>Total : $ ${ presupuesto.viaje.precio }</h3>
					</div>
					<hr />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 float-right">
					<strong>Observaciones: </strong>
					<p>${presupuesto.viaje.descripcion}</p>
				</div>
			</div>
			<hr />
			<div class="row text-center">
				<c:choose>
					<c:when
						test="${presupuesto.estadoMovimiento.descripcion.equals('Activo')}">
						<div class="col-lg-4 col-md-4 col-sm-4">
							<form method="post"
								action="${pageContext.request.contextPath}/aceptarPresupuesto">
								<input type="hidden" name="idPresupuesto" value="${presupuesto.id}" /> 
								<input type="submit" class="btn btn-success btn-sm" value="Aceptar Presupuesto" />
							</form>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4">
							<a
								href="${pageContext.request.contextPath}/listarPresupuestosCliente"
								class="btn btn-primary btn-sm">Volver al listado</a>
						</div>						
						<div class="col-lg-4 col-md-4 col-sm-4">
							<form method="post"
								action="${pageContext.request.contextPath}/rechazarPresupuesto">
								<input type="hidden" name="idPresupuesto" value="${presupuesto.id}" /> 
								<input type="submit" class="btn btn-danger btn-sm " value="Rechazar Presupuesto" />
							</form>
						</div>
					</c:when>
					<c:when test="${ not empty factura.id }">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<a class="btn btn-warning btn-sm" href="${pageContext.request.contextPath}/verFactura/${factura.viaje.id}">Ver Facutra</a>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<a href="${pageContext.request.contextPath}/listarPresupuestosCliente" class="btn btn-primary btn-sm">Volver al listado</a>
						</div>
					</c:when>
				</c:choose>

			</div>
			<hr>

		</div>
	</div>
</div>
</form>
<%@include file='../../templates/Footer.jsp'%>