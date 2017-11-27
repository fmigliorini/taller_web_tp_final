<%@include file='../../templates/Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row color-invoice">
		<div class="col-md-12">
			<br />
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 text-center">
					<h2>FACTURA VIAJES PEPE</h2>
				</div>
				<hr />
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<h4>Empresa</h4>
					<strong>Email: </strong> info@mudanzapepe.com <br /> <strong>WEB:
					</strong> www.mudanzapepe.com.ar <br /> <strong>Telefono: </strong>011
					4480-8900 <br /> <strong>Direccion: </strong>Florencio Varela
					1903, B1754JEC San Justo, Buenos Aires <br /> <strong>CUIT:
					</strong> 30-71482650-2 <br /> <strong>Inicio de act.: </strong> 21/04/2011
					<br /> <strong>Fecha: </strong> 02/11/2017
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6 text-right">
					<h4>Factura</h4>
					<strong>Identificador:</strong> ${factura.id } <br/>
					<strong>letra:</strong> ${factura.letra } <br/>
					<strong>Numero Movimiento	:</strong> ${factura.numeroMovimiento } <br/>
					<strong>Fecha y hora:</strong> ${factura.fecha_hora } <br/>					
				</div>
			</div>
			<hr />
			<!--  CLIENT SIDE -->
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<h4>Datos del cliente:</h4>
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
					<strong>Fecha del servicio: </strong> ${factura.viaje.fecha } <br> 
					<strong>Hora: </strong>  ${factura.viaje.hora } <br>
					<strong>Tipo de vehiculo: </strong> ${factura.viaje.tipoVehiculo.descripcion }

				</div>

				<div class="col-lg-6 col-md-6 col-sm-6">
					<br> 
					<strong> Direccion de origen: </strong> ${factura.viaje.origen } <br>
					<strong> Direccion de destino: </strong> ${factura.viaje.destino } <br>
					<strong> Kilometros Recorridos: </strong> ${factura.viaje.kilometros }



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
									<th>Canidad Kilometros </th>
									<th>Precio por kilometros</th>
									<th>Sub Total</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Viaje </td>
									<td>${factura.viaje.kilometros } KM. </td>
									<td>$ ${factura.viaje.tipoVehiculo.precio }</td>
									<td>$ ${factura.viaje.precio }</td>
								</tr>
							</tbody>
						</table>
					</div>
					<hr>
					<div>
						<h3>Total : $ ${ factura.viaje.precio }</h3>
					</div>
					<hr />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 float-right">
					<strong>Observaciones: </strong>
					<p>${factura.viaje.descripcion}</p>
				</div>
			</div>
			<hr />
			<div class="row">
				<a href="#" class="btn btn-primary">volver</a>
			</div>
			<hr>

		</div>
	</div>
</div>
</form>
<%@include file='../../templates/Footer.jsp'%>