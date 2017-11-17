<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file='../../templates/Menu_chofer.jsp' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de LogViajes</title>
</head>
<body>
   <div class="container">
	<div class="row color-invoice">
		<div class="col-md-12">

			<div class="row">
				
				<div class="col-md-12"">
                    <br>
   					<h3>Esta es la lista de los Log cargados: </h3><br>
                   
	 				<c:forEach var="chofer" items="${listaLog}">
                                
                                    <table>
                                   
	                                    <tr > 
	                                    	<td><h5>Id de Log de viaje:</h5></td>
	                                    	<td><h5>Precio:</h5></td>
	                                    	<td><h5>Descripción:</h5></td>
	                                    </tr>
	                                    <tr>
		                                    <td> <c:out value="${chofer.id}"/></td>
		                                    <td><h5><c:out value="${chofer.precio}"/></h5></td>
		                                    <td><h5> <c:out value="${chofer.tipoLogViaje}"/></h5></td>
		                                </tr>
                                    
                                    </table>
                                  
					 </c:forEach>    
					 </div>
			</div>
			<hr />
			<hr />
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
				   
					<a href="indexChofer" class="btn btn-success btn-sm">Volver al inicio</a>
				</div>
			</div>
			<hr>
			<div class="row"></div>
		</div>
	</div>     
 
</body>
</html>