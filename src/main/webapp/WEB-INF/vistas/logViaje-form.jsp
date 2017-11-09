<%@include file='../../templates/Header.jsp' %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="container">
	<h1> Formulario Gastos De Viajes </h1>
    <form action="cargarLogViaje">
        
	    <div class="form-row">	
		    <div class="form-group col-md-12">
		        <label for="descripcion">Descripción </label>
		        <textarea required="required" class="form-control" id="descripcion" name="descripcion" rows="3"></textarea>
		    </div>
		        <div class="form-group col-md-12">
	            <label for="precio">Precio</label>
	            <input type="text" required="required" class="form-control" id="precio" name="precio">
	        </div>
	    </div>
	    <input type="submit" class="btn btn-primary" value="Generar Log de Viaje">
   	    <button type="submit" class="btn btn-danger">Cancelar</button>
	    
	</form>
</div>
<%@include file='../../templates/Footer.jsp' %>