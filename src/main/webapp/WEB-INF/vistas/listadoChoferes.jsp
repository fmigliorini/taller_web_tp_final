<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file='../../templates/Menu_administrador.jsp' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ABM de chófer</title>
</head>
<body>
<div class="container">
				<div class="row">
					<div class="col-md-12">
					<h1>ABM de chófer</h1>
						<br>
						<h3>Esta es la lista de los chóferes:</h3>
						<br>
						<table class="table table-bordered">
							<thead>
								<tr>
									      <th scope="col">Id</th>
									      <th scope="col">Nombre</th>
									      <th scope="col">Apellido</th>
									      <th scope="col">DNI</th>
									      <th scope="col">Dirección</th>
									      <th scope="col">Email</th>
									      <th scope="col">Telefono</th>
									      <th scope="col">Rol</th>
									      <th scope="col">Editar</th>
									      <th scope="col">Eliminar</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="chofer" items="${listaChoferes}">
									<tr>			
										<td><c:out value="${chofer.getId()}" /></td>
										<td><c:out value="${chofer.nombre}" /></td>
								        <td><c:out value="${chofer.apellido}" /></td>
								        <td><c:out value="${chofer.dni}" /></td>
								        <td><c:out value="${chofer.direccion}" /></td>
								        <td><c:out value="${chofer.email}" /></td>
								        <td><c:out value="${chofer.telefono}" /></td>
								        <td><c:out value="${chofer.rol}" /></td>
								        <td><a href="#" class="btn btn-warning"> <span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
								        <td><a href="#" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Eliminar</a></td>	        
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<a href="chofer-form" class="btn btn-primary">Agregar nuevo Chofer</a>
					</div>
				</div>
			</div>
</body>
</html>