<%@include file='../../templates/Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h1>Agregar Vehiculo</h1>
	<form action="guardarVehiculo" modelAttribute="Vehiculo" method="POST">
		<div class="form-row">
			<div class="form-group col-md-12">
				<div class="form-group col-md-12">
					<label for="nombre">Marca</label> <input type="text"
						required="required" class="form-control" id="marca" name="marca"
						placeholder="marca">
				</div>
				<div class="form-group col-md-12">
					<label for="apellido">Modelo</label> <input type="text"
						required="required" class="form-control" id="modelo"
						name="modelo" placeholder="modelo">
				</div>

				<div class="form-group col-md-12">
					<label for="email">Patente</label> <input type="text"
						required="required" class="form-control" id="patente" name="patente"
						placeholder="patente">
				</div>
		

				<div class="form-group col-md-12">
					<label for="tipovehiculo">Tipo del Vehiculo</label> <select
						name="tipovehiculo" id="idTipoVehiculo" class="form-group ">
						<c:forEach items="${lisTipovehiculos}" var="vehiculo">
							<option value="${vehiculo.getId()}">${vehiculo.getDescripcion()}</option>
						</c:forEach>
					</select>
				</div>
				
			    <div class="form-group col-md-12">
					<label for="tipovehiculo">Chofer</label> <select
						name="tipovehiculo" id="chofer" class="form-group ">
						<c:forEach items="${listChoferes}" var="chofer">
							<option value="${chofer.getId()}">${chofer.getNombre()} ${chofer.getApellido()}</option>
						</c:forEach>
					</select>
				</div>
			<input type="submit" class="btn btn-primary" value="Guardar Vehiculo">
	</div>
	</div>
	</form>
</div>


<%@include file='../../templates/Footer.jsp'%>
