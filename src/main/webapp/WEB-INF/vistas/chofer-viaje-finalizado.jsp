<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Header.jsp'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container" style="margin-top: 60px !important">
	<div class="alert alert-${tipo}">
		<h1>${titulo}</h1>
		<p>${mensaje}</p>
	</div>
	<a href="listaDeViajesActivos" class="btn btn-primay btn-sm">Volver
		a viajes activos</a>

</div>

<%@include file='../../templates/Footer.jsp'%>