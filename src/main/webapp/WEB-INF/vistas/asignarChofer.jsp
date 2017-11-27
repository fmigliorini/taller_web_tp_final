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
<title>Asignar vehiculo al Presupuesto <fmt:formatNumber pattern="0000" type="number" value="${mov.getPuntoVenta()}" /> - <fmt:formatNumber pattern="00000000" type="number" value="${mov.getNumeroMovimiento()}" /></title>
</head>
<body>

    
<div class="container">
	  <form:form action="generarMovimientos" method="POST" modelAttribute="viaje">
	<h1> Asignar vehiculo al Presupuesto <fmt:formatNumber pattern="0000" type="number" value="${mov.getPuntoVenta()}" /> - <fmt:formatNumber pattern="00000000" type="number" value="${mov.getNumeroMovimiento()}" /> </h1>
	      <div class="row">
  			  <div class="col-lg-6 col-md-6 col-sm-6">
                   <br><strong> Fecha del servicio:</strong>${mov.getViaje().getFecha() }
                    <br><strong> Hora:</strong> ${mov.getViaje().getHora() }
                    <br><strong> Tipo de vehiculo:</strong> ${mov.getViaje().getTipoVehiculo().getDescripcion() }
              </div>
                
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <br> <strong>Direccion de origen:</strong> ${mov.getViaje().getOrigen() }
                    <br><strong>Direccion de destino:</strong> ${mov.getViaje().getDestino() }
                    <br> <strong>Kilometros a recorrer:</strong> ${mov.getViaje().getKilometros() }

                </div>
                
            </div>
	
	
   <div class="row">
 <div class="form-group col-md-12">
		        <label for="origen">Vehiculo</label>
		        <select name="item" class="form-group">
					<c:forEach items="${listVehiculos}" var="vehiculo">
   						<option value="${vehiculo.getId()}">${vehiculo.getModelo()} ${vehiculo.getMarca()} ${vehiculo.getPatente()}</option>
					</c:forEach>
				</select>
				 </div>
 </div>
	    <div class="row">
	     <div class="form-group col-md-12">
	    <input type="submit" class="btn btn-primary" value="Aceptar">
   	    <button type="submit" class="btn btn-danger">Rechazar</button>
	    </div></div>
	</form:form>
</div>
    


	    

</body>
</html>