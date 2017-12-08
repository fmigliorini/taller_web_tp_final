<%@include file='../../templates/Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h1>Modificar Vehiculo</h1>
	<form:form action="actualizarVehiculo" modelAttribute="Vehiculo"
		method="POST">
		<div class="form-row">
			<div class="form-group col-md-12">
				<div class="form-group col-md-12">

					<form:input type="hidden" id="id" name="id" path="id" />
					<label for="nombre">Marca</label>
					<form:input type="text" required="required" class="form-control"
						id="marca" name="marca" path="marca" />
				</div>
				<div class="form-group col-md-12">
					<label for="apellido">Modelo</label>
					<form:input type="text" required="required" class="form-control"
						id="modelo" name="modelo" path="modelo" />
				</div>

				<div class="form-group col-md-12">
					<label for="email">Patente</label>
					<form:input type="text" required="required" class="form-control"
						id="patente" name="patente" path="patente" />
				</div>

				<div class="form-group col-md-12">
					<label for="chofer">Chofer</label> <select name="chofer"
						id="chofer" class="form-group ">
						<c:forEach items="${listChofer}" var="c">
							<option value="${c.getId()}">${c.getNombre()}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group col-md-12">
					<label for="tipovehiculo">Tipo del Vehiculo</label> <select
						name="tipovehiculo" id="tipovehiculo" class="form-group ">
						<c:forEach items="${lisTipovehiculos}" var="vehiculo">
							<option value="${vehiculo.getId()}">${vehiculo.getDescripcion()}</option>
						</c:forEach>
					</select>
				</div>
				<input type="submit" class="btn btn-primary"
					value="Actualizar Vehiculo">
			</div>
		</div>
	</form:form>
</div>


<%@include file='../../templates/Footer.jsp'%>