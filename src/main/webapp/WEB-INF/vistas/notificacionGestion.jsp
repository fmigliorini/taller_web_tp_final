<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Menu_administrador.jsp' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"
          prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notificacion</title>
</head>
<body>
<div class = "container" style="margin-top:60px!important">
  <div class="alert alert-${tipo}">
	<h1> ${titulo}</h1>
<p>${mensaje}</p>
</div>
</div>

</body>
</html>