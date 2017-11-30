<%@include file='../../templates/Menu_administrador.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<h1>Agregar Usuario</h1>
	<form action="guardarUsuario" modelAttribute="Usuario" method="POST">
		<div class="form-row">
			<div class="form-group col-md-12">
				<div class="form-group col-md-12">
					<label for="nombre">Nombre</label> <input type="text"
						required="required" class="form-control" id="nombre" name="nombre"
						placeholder="Nombre">
				</div>
				<div class="form-group col-md-12">
					<label for="apellido">Apellido</label> <input type="text"
						required="required" class="form-control" id="apellido"
						name="apellido" placeholder="Apellido">
				</div>

				<div class="form-group col-md-12">
					<label for="email">Email</label> <input type="text"
						required="required" class="form-control" id="email" name="email"
						placeholder="info@pepeviajes.com.ar">
				</div>
				<div class="form-group col-md-12">
					<label for="password">Contraseña</label> <input type="password"
						required="required" class="form-control" id="password"
						name="password">
				</div>


				<div class="form-group col-md-12">
					<label for="telefono">Teléfono</label> <input type="text"
						required="required" class="form-control" id="telefono"
						name="telefono" placeholder="11-2233-4455">
				</div>
				<div class="form-group col-md-12">
					<label for="dni">DNI</label> <input type="text" required="required"
						class="form-control" id="dni" name="dni" placeholder="XX.XXX.XXX">
				</div>
				<div class="form-group col-md-12">
					<label for="direccion">Direccion</label> <input type="text"
						required="required" class="form-control" id="direccion"
						name="direccion"
						placeholder="Calle altura piso depto , localidad, provincia, pais">
				</div>
			</div>

			<div class="form-group col-md-12">
				<label for="password">Rol</label> <select name="rol" id="rol"
					class="form-group ">
					<option value="chofer">Chofer</option>
					<option value="admin">Administrador</option>
				</select>
			</div>
			<input type="submit" class="btn btn-primary" value="Guardar Usuario">
	</form>
</div>


<%@include file='../../templates/Footer.jsp'%>
