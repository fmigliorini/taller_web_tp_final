<%@include file='../../templates/Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h1>Agregar Vehiculo</h1>
	<form:form action="guardarVehiculo" modelAttribute="Vehiculo" method="POST">
		<div class="form-row">
			<div class="form-group col-md-12">
				<div class="form-group col-md-12">
					<label for="nombre">Marca</label>
					<form:input type="text" required="required" class="form-control"
						id="marca" path="marca" placeholder="marca" />
				</div>
				<div class="form-group col-md-12">
					<label for="apellido">Modelo</label>
					<form:input type="text" required="required" class="form-control"
						id="modelo" path="modelo" placeholder="modelo" />
				</div>

				<div class="form-group col-md-12">
					<label for="patente">Patente</label>
					<form:input type="text" required="required" class="form-control"
						id="patente" path="patente" placeholder="patente" />
				</div>

				<div class="form-group col-md-12">
					<label for="Externo">Externo</label>
					<form:checkbox required="required" id="externo"
						path="externo" name="externo" />
				</div>

				<div class="form-group col-md-12">
					<label for="tipovehiculo">Tipo del Vehiculo</label> <select
						name="idTipoVehiculo" id="idTipoVehiculo" class="form-group ">
						<c:forEach items="${lisTipovehiculos}" var="vehiculo">
							<option value="${vehiculo.getId()}">${vehiculo.getDescripcion()}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group col-md-12">
					<label for="chofer">Chofer</label> <select name="idChofer"
						id="idChofer" class="form-group ">
						<c:forEach items="${listChoferes}" var="chofer">
							<option value="${chofer.getId()}">${chofer.getNombre()}
								${chofer.getApellido()}</option>
						</c:forEach>
					</select>
				</div>
				<input type="submit" class="btn btn-primary"
					value="Guardar Vehiculo">
			</div>
		</div>
	</form:form>
</div>


<%@include file='../../templates/Footer.jsp'%>
