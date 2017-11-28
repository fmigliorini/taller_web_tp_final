<%@include file='../../templates/Header.jsp' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
					<h1>Lista de presupuesto: </h1>
						<br>
						<br>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th scope="col">id</th>
									<th scope="col">fecha_hora</th>
									<th scope="col">Estado</th>
									<th scope="col">TipoVehiculo</th>
									<th scope="col">Operaciones</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="presupuesto" items="${presupuestos}">
									<tr>
										<td><c:out value="${presupuesto.id}" /></td>	
										<td><c:out value="${presupuesto.fecha_hora}" /></td>
										<td><c:out value="${presupuesto.estadoMovimiento.descripcion}" /></td>
										<td><c:out value="${presupuesto.viaje.tipoVehiculo.descripcion}" /></td>
										<td><a class="btn btn-primary" href="verPresupuesto/<c:out value="${presupuesto.id}" />"> ver Mas</a></td>
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
<%@include file='../../templates/Footer.jsp' %>