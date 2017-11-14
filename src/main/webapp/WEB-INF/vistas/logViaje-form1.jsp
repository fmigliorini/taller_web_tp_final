<%@include file='../../templates/Header.jsp' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- /combustible, peaje,arreglo,. -->
<div class="container">
	<h1> Formulario Gastos De Viajes </h1>
	<form:form method="POST" action="cargarLogViaje" modelAttribute="logViaje">
	     <div class="form-row">	
		    <div class="form-group col-md-12">
		   
               <label for="tipoLogViaje">Selecciona Log de viaje:</label>
               <form:select class="form-control" required="required"  path="tipoLogViaje" >
                   <form:option value="combustible">Combustible</form:option>
                   <form:option value="peaje">Peaje</form:option>
                   <form:option value="mantenimiento">Mantenimiento</form:option>
               </form:select>
                 
		    </div>
		        <div class="form-group col-md-12">
	            <label for="precio">Precio</label>
	            <form:input path="precio" type="text" required="required" class="form-control" id="precio" name="precio"/>
	            
	        </div>
	    </div>
	    <input type="submit" class="btn btn-primary" value="Generar Log de Viaje" />
	    
   	    
   	    <a href="indexChofer" class="btn btn-danger">Cancelar</a>
	</form:form>
</div>
<%@include file='../../templates/Footer.jsp' %>