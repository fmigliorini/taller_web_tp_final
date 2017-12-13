<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="javax.servlet.http.HttpServletRequest"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="MudanzasPepe">
<meta name="author" content="Erika Romanczuk">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Side</title>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
</head>
<style>
.navbar-login {
	width: 305px;
	padding: 10px;
	padding-bottom: 0px;
}

.navbar-login-session {
	padding: 10px;
	padding-bottom: 0px;
	padding-top: 0px;
}

.icon-size {
	font-size: 87px;
}
</style>
<body>
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<a class="navbar-brand" href="#"> </a>
			<div class="nav navbar-nav navbar-right">
				<ul class="nav navbar-nav">
					<li><a
						href="${pageContext.request.contextPath}/listaDeViajesActivos">Viaje Activo</a></li>
					<li><a href="${pageContext.request.contextPath}/listaLogViaje">Ver
							log de viaje</a></li>
					<li><a
						href="${pageContext.request.contextPath}/logViajeForm?idViaje=${viajeEnProceso.id}">Cargar
							Log de viaje</a></li>
				</ul>
			</div>

		</div>
	</div>
	<br>
	<br>
	<br>