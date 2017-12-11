<%@include file='../../templates/Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container" style="margin-top: 60px">
	<h1>Modificar Usuario</h1>
	<form:form action="actualizarUsuario" modelAttribute="Usuario"
		method="POST">
		<div class="form-row">
			<form:input type="hidden" id="id" path="id" />

			<div class="form-group col-md-12">
				<label for="nombre">Nombre</label>
				<form:input type="text" required="required" class="form-control"
					id="nombre" path="nombre" placeholder="Nombre" />
			</div>
			<div class="form-group col-md-12">
				<label for="apellido">Apellido</label>
				<form:input type="text" required="required" class="form-control"
					id="apellido" path="apellido" placeholder="Apellido"></form:input>
			</div>

			<div class="form-group col-md-12">
				<label for="email">Email</label>
				<form:input type="text" required="required" class="form-control"
					id="email" path="email" placeholder="info@pepeviajes.com.ar"></form:input>
			</div>
			<div class="form-group col-md-12">
				<label for="password">Contraseña</label>
				<form:input type="password" required="required" class="form-control"
					id="password" path="password"></form:input>
			</div>
			<div class="form-group col-md-12">
				<label for="password">Rol</label> <select name="rol" id="rol"
					class="form-group">
					<option class="form-group" value="chofer">Chofer</option>
					<option class="form-group" value="admin">Administrador</option>
				</select>
			</div>
			<div class="form-group col-md-12">
				<label for="telefono">Teléfono</label>
				<form:input type="text" required="required" class="form-control"
					id="telefono" path="telefono" placeholder="11-2233-4455"></form:input>
			</div>
			<div class="form-group col-md-12">
				<label for="dni">DNI</label>
				<form:input type="text" required="required" class="form-control"
					id="dni" path="dni" placeholder="XX.XXX.XXX"></form:input>
			</div>
			<div class="form-group col-md-12">
				<label for="direccion">Direccion</label>
				<form:input type="text" required="required" class="form-control"
					id="direccion" path="direccion"
					placeholder="Calle altura piso depto , localidad, provincia, pais"></form:input>
			</div>
		</div>
		<input type="submit" class="btn btn-primary" value="Guardar Usuario">

	</form:form>
</div>


<%@include file='../../templates/Footer.jsp'%>
