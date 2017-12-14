<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file='../../templates/Header.jsp'%>

	<div class="container" style="margin-top: 60px !important">
		<div class="row color-invoice">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
						<h1>Lista de Usuarios</h1>
						<a class="btn btn-default btn-circle"
							href="${pageContext.request.contextPath}/agregarUsuario"><span
							class="glyphicon glyphicon-user"></span> Agregar Usuario</a>
						<h3>Lista de Choferes</h3>
						<table class="table table-striped custab">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Nombre</th>
									<th scope="col">Apellido</th>
									<th scope="col">DNI</th>
									<th scope="col">Telefono</th>
									<th scope="col">Direccion</th>
									<th scope="col">Email</th>
									<th scope="col">Editar</th>
									<th scope="col">Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="c" items="${chofer}">
									<tr>
										<!-- UNA VEZ QUE ESTE CARGADO LOS DATOS SE PUEDEN -->
										<td><c:out value="${c.id}" /></td>
										<td><c:out value="${c.nombre}" /></td>
										<td><c:out value="${c.apellido}" /></td>
										<td><c:out value="${c.dni}" /></td>
										<td><c:out value="${c.telefono}" /></td>
										<td><c:out value="${c.direccion}" /></td>
										<td><c:out value="${c.email}" /></td>
										<td><c:out value="" /><a
											class="btn btn-default btn-circle"
											href="${pageContext.request.contextPath}/modificarUsuario?idUsuario=${c.getId()}"><span
												class="glyphicon glyphicon-pencil"></span></a></td>
										<td><c:out value="" /> <a
											class="btn btn-default btn-circle"
											href="${pageContext.request.contextPath}/eliminarUsuario?id=${c.getId()}"><span
												class="glyphicon glyphicon-trash"></span> </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						
						<h3>Lista de Administradores</h3>
						<table class="table table-striped custab">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Nombre</th>
									<th scope="col">Apellido</th>
									<th scope="col">DNI</th>
									<th scope="col">Telefono</th>
									<th scope="col">Direccion</th>
									<th scope="col">Email</th>
									<th scope="col">Editar</th>
									<th scope="col">Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="c" items="${admin}">
									<tr>
										<!-- UNA VEZ QUE ESTE CARGADO LOS DATOS SE PUEDEN -->
										<td><c:out value="${c.id}" /></td>
										<td><c:out value="${c.nombre}" /></td>
										<td><c:out value="${c.apellido}" /></td>
										<td><c:out value="${c.dni}" /></td>
										<td><c:out value="${c.telefono}" /></td>
										<td><c:out value="${c.direccion}" /></td>
										<td><c:out value="${c.email}" /></td>
										<td><c:out value="" /><a class="btn btn-default btn-circle"
											href="${pageContext.request.contextPath}/modificarUsuario?idUsuario=${c.getId()}"><span
												class="glyphicon glyphicon-pencil"></span></a></td>
										<td><c:out value="" /> <a
											class="btn btn-default btn-circle"
											href="${pageContext.request.contextPath}/eliminarUsuario?idUsuario=${c.getId()}"><span
												class="glyphicon glyphicon-trash"></span> </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>						
					</div>
				</div>


			</div>
		</div>
	</div>
	
<%@include file='../../templates/Footer.jsp'%>
