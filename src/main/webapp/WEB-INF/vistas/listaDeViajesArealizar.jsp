<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Menu_chofer.jsp' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de viajes a realizar</title>
</head>
<body>
<h1>Hola soy una lista de viajes a realizar</h1>
<h3>Paso 1: Muestra una lista de viajes que va a realizer el chofer , ordenados por hora lista diaria</h3>
<h3>Paso 2:
cuando el chofer hace clik en el viaje o in boton ,  me redirecciona a CargarLogViaje</h3>
<a href="menu_chofer_viajeActivo" class="btn btn-success">Activar recorrido</a>
<a href="indexChofer" class="btn btn-primary">Volver al menú</a>

</body>
</html>
<%@include file='../../templates/Footer.jsp' %>